public class StaffInterface {

    static AnimalList animals;
    static SpeciesList species;
    static AppointmentList appointments;

    public static void main(String[] args) {
        animals = new AnimalList();
        species = new SpeciesList();
        appointments = new AppointmentList();

        for(Species species : species.getSpeciesList()){
            System.out.println("Species: (" + species.toString() + ")\n\nListing all " + species.getName() + ":");
            animals.getAnimals().stream()
                    .filter(a -> a.getSpecies().getName().equals(species.getName()))
                    .forEach(animal -> System.out.println("----\n" + animal.toString()));
        }
        
        for(Appointment appointment : appointments.getAppointments()){
            System.out.println("Appointment for " + appointment.getAnimal().getName() + " scheduled at " + appointment.getTime().toString());
        }
    }
}
