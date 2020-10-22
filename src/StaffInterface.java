public class StaffInterface {

    static AnimalList animals;

    public static void main(String[] args) {
        animals = new AnimalList();

        for (Animal animal : animals.getAnimals()){
            System.out.println(animal.toString());
        }
    }
}
