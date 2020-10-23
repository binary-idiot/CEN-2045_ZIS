import java.util.ArrayList;
import java.util.Map;

public class AnimalList {
    private final ArrayList<Animal> animals;

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

            Animal animal = Animal.buildAnimal(animalMap);
            animals.add(animal);
        }

        return animals;
    }
}
