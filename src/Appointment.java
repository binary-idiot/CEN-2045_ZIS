import java.time.LocalDateTime;
import java.util.Map;

public class Appointment {
    private final Animal animal;
    private final LocalDateTime time;

    public Appointment(Animal animal, LocalDateTime time) {
        this.animal = animal;
        this.time = time;
    }

    public Animal getAnimal() {
        return animal;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public static Appointment buildAppointment(Map<String, String> appointmentMap){
        Map<String, String> animalMap = DBInterface.filter("animal", a -> a.getKey().equals(appointmentMap.get("animal"))).get(appointmentMap.get("animal"));
        Animal animal = Animal.buildAnimal(animalMap);

        return new Appointment(animal, LocalDateTime.parse(appointmentMap.get("time")));
    }
}
