import java.util.Map;

public class Animal {

    private final String id;
    private final String name;
    private final Species species;
    private final Enclosure enclosure;
    private String notes;

    public Animal(String id, String name, Species species, Enclosure enclosure) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.enclosure = enclosure;
        this.notes = null;
    }

    public void modifyNotes(String note) {
        if(this.notes != null){
            this.notes += "/n" + note;
        }else{
            this.notes = note;
        }
    }

    @Override
    public String toString(){
        return String.format("ID: %s, Name: %s, Species: %s, Enclosure: %d, Notes:\n %s\n",
                getId(), getName(), getSpecies().getName(), getEnclosure().getId(), getNotes());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public String getNotes() {
        return notes.equals("") ? notes : "No notes yet";
    }

    public static Animal buildAnimal(Map<String, String> animalMap){

        Map<String, String> speciesMap = DBInterface.filter("species", s -> s.getKey().equals(animalMap.get("species"))).get(animalMap.get("species"));
        Map<String, String> enclosureMap = DBInterface.filter("enclosures", e -> e.getKey().equals(animalMap.get("enclosure"))).get(animalMap.get("enclosure"));

        Enclosure enclosure = new Enclosure(Integer.parseInt(enclosureMap.get("id")), enclosureMap.get("info"));
        Species species = new Species(speciesMap.get("name"), speciesMap.get("info"), speciesMap.get("food"), Integer.parseInt(speciesMap.get("amount")));

        Animal animal = new Animal(animalMap.get("id"), animalMap.get("name"), species, enclosure);
        animal.modifyNotes(animalMap.get("notes"));

        return animal;
    }
}
