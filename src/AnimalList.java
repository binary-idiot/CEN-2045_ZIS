import java.util.ArrayList;
import java.util.Map;

public class AnimalList {
    private ArrayList<Animal> animals;

    public AnimalList() {
        this.animals = retrieveAnimals();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public Animal getAnimal(int i){
        return animals.get(i);
    }

    public boolean addAnimal(Animal animal){
        if(DBInterface.add(animal.toString())){
            animals.add(animal);
            return true;
        }

        return false;
    }

    private ArrayList<Animal> retrieveAnimals(){
        ArrayList<Animal> animals = new ArrayList<>();

        for(Map.Entry<String, Map<String, String>> entry : DBInterface.select("animals").entrySet()){
            Map<String, String> animalMap = entry.getValue();
            Map<String, String> speciesMap = DBInterface.filter("species", s -> s.getKey().equals(animalMap.get("species"))).get(animalMap.get("species"));
            Map<String, String> enclosureMap = DBInterface.filter("enclosures", e -> e.getKey().equals(animalMap.get("enclosure"))).get(animalMap.get("enclosure"));

            Enclosure enclosure = new Enclosure(Integer.parseInt(enclosureMap.get("id")), enclosureMap.get("info"));
            Species species = new Species(speciesMap.get("name"), speciesMap.get("info"), speciesMap.get("food"), Integer.parseInt(speciesMap.get("amount")));

            Animal animal = new Animal(animalMap.get("id"), animalMap.get("name"), species, enclosure);
            animal.modifyNotes(animalMap.get("notes"));
            animals.add(animal);
        }

        return animals;
    }
}
