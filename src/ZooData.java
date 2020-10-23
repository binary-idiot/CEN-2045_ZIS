import java.util.HashMap;
import java.util.Map;

public class ZooData {

    private static Map<String, Map<String, Map<String, String>>> data = null;

    private static Map<String, Map<String, Map<String, String>>> createZooData(){
        Map<String, Map<String, Map<String, String>>> zooData = new HashMap<>();

        zooData.put("animals", createAnimalData());
        zooData.put("species", createSpeciesData());
        zooData.put("enclosures", createEnclosureData());
        zooData.put("appointments", createAppointmentData());
        zooData.put("tasks", createFeedingData());

        return zooData;
    }

    private static Map<String, Map<String, String>> createAnimalData(){
        Map<String, Map<String, String>> animals = new HashMap<>();

        animals.put("a1", createAnimal("a1", "lidya", "bat", "1", "- very playful\n- will try to escape"));
        animals.put("a2", createAnimal("a2", "theo", "fox", "2", "- shy around new people\n- sprained front right ankle"));
        animals.put("a3", createAnimal("a3", "violet", "fox", "2", ""));
        animals.put("a4", createAnimal("a4", "pascal", "bluejay", "1", ""));
        animals.put("a5", createAnimal("a5", "oscar", "elephant", "3", "- allergic to peanuts"));
        animals.put("a6", createAnimal("a6", "moxy", "rhino", "3", ""));
        animals.put("a7", createAnimal("a7", "swish", "dolphin", "4", "- rescued from poachers"));
        animals.put("a8", createAnimal("a8", "maya", "elephant", "3", ""));
        animals.put("a9", createAnimal("a9", "julian", "orca", "4", ""));
        animals.put("a10", createAnimal("a10", "ralph", "flamingo", "1", "- broke left leg, requires surgery to set\n- surgery successful"));

        return animals;
    }

    private static Map<String, Map<String, String>> createSpeciesData(){
        Map<String, Map<String, String>> species = new HashMap<>();

        species.put("bat", createSpecies("bat", "lives in damp caves", "insects", "5"));
        species.put("fox", createSpecies("fox", "very adaptable", "omnipellets", "10"));
        species.put("bluejay", createSpecies("bluejay", "feather pigment is actually brown, appears blue due to refraction", "seeds", "5"));
        species.put("elephant", createSpecies("elephant", "can weigh over 10k lbs", "herb medley", "15"));
        species.put("rhino", createSpecies("rhino", "extremely aggressive", "herb medley", "10"));
        species.put("dolphin", createSpecies("dolphin", "highly intelligent", "fish paste", "15"));
        species.put("orca", createSpecies("orca", "not actually whales", "fish paste", "30"));
        species.put("flamingo", createSpecies("flamingo", "get pink color from eating shrimp", "insects", "20"));

        return species;
    }

    private static Map<String, Map<String, String>> createEnclosureData(){
        Map<String, Map<String, String>> enclosures = new HashMap<>();

        enclosures.put("1", createEnclosure("1", "aviary"));
        enclosures.put("2", createEnclosure("2", "forest"));
        enclosures.put("3", createEnclosure("3", "plains"));
        enclosures.put("4", createEnclosure("4", "aquatic"));

        return enclosures;
    }

    private static Map<String, Map<String, String>> createAppointmentData(){
        Map<String, Map<String, String>> appointments = new HashMap<>();

        appointments.put("1", createAppointment("a2", "2020-10-20T10:30:00"));
        appointments.put("2", createAppointment("a5", "2020-10-22T13:00:00"));
        appointments.put("3", createAppointment("a10", "2020-10-25T15:15:00"));

        return appointments;
    }

    private static Map<String, Map<String, String>> createFeedingData(){
        Map<String, Map<String, String>> tasks = new HashMap<>();

        tasks.put("1", createFeedingTask("a1", "10:00", "true"));
        tasks.put("2", createFeedingTask("a2", "11:00", "true"));
        tasks.put("3", createFeedingTask("a3", "11:00", "false"));
        tasks.put("4", createFeedingTask("a4", "10:00", "false"));
        tasks.put("5", createFeedingTask("a5", "13:00", "false"));
        tasks.put("6", createFeedingTask("a6", "13:00", "false"));
        tasks.put("7", createFeedingTask("a7", "14:00", "false"));
        tasks.put("8", createFeedingTask("a8", "13:00", "false"));
        tasks.put("9", createFeedingTask("a9", "14:00", "false"));
        tasks.put("10", createFeedingTask("a10", "10:00a", "false"));

        return tasks;
    }

    private static Map<String, String> createAnimal(String id, String name, String species, String enclosure, String notes){
        Map<String, String> animal = new HashMap<>();

        animal.put("id", id);
        animal.put("name", name);
        animal.put("species", species);
        animal.put("enclosure", enclosure);
        animal.put("notes", notes);

        return animal;
    }

    private static Map<String, String> createSpecies(String name, String info, String food, String amount){
        Map<String, String> species = new HashMap<>();

        species.put("name", name);
        species.put("info", info);
        species.put("food", food);
        species.put("amount", amount);

        return species;
    }

    private static Map<String, String> createEnclosure(String id, String info){
        Map<String, String> enclosure = new HashMap<>();

        enclosure.put("id", id);
        enclosure.put("info", info);

        return enclosure;
    }

    private static Map<String, String> createAppointment(String animal, String time) {
        Map<String, String> appointment = new HashMap<>();

        appointment.put("animal", animal);
        appointment.put("time", time);

        return appointment;
    }

    private static Map<String, String> createFeedingTask(String animal, String time, String complete) {
        Map<String, String> task = new HashMap<>();

        task.put("animal", animal);
        task.put("time", time);
        task.put("complete", complete);

        return task;
    }

        public static Map<String, Map<String, Map<String, String>>> getZooData(){

        if(data == null){
            data =  createZooData();
        }

        return data;
    }
}
