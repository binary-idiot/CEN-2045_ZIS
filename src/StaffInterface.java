public class StaffInterface {

    static AnimalList animals;
    static SpeciesList species;

    public static void main(String[] args) {
        animals = new AnimalList();
        species = new SpeciesList();

        for (Species species : species.getSpeciesList()){
            System.out.println("Species: (" + species.toString() + ")\n\nListing all " + species.getName() + ":");
            animals.getAnimals().stream()
                    .filter(a -> a.getSpecies().getName().equals(species.getName()))
                    .forEach(animal -> System.out.println("----\n" + animal.toString()));
        }
    }
}
