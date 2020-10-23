import java.time.LocalTime;
import java.util.Map;

public class FeedingTask {
	private final Animal animal;
	private final LocalTime time;
	private boolean compleationStatus;
	
	public FeedingTask(Animal animal, LocalTime time, boolean compleationStatus) {
		this.animal = animal;
		this.time = time;
		this.compleationStatus = compleationStatus;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public boolean getCompleationStatus() {
		return compleationStatus;
	}
	
	public void setCompleationStatus(boolean compleationStatus) {
		this.compleationStatus = compleationStatus;
	}
	
	public FeedingTask buildTask(Map<String, String> taskMap) {
		Map<String, String> animalMap = DBInterface.filter("animals", a -> a.getKey().equals(taskMap.get("animal"))).get(taskMap.get("animal"));
		
		Animal animal = Animal.buildAnimal(animalMap);
		return new FeedingTask(animal, LocalTime.parse(taskMap.get("time")), Boolean.parseBoolean(taskMap.get("complete")));
	}
}
