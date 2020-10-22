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
}
