import java.util.ArrayList;
import java.util.Map;

public class FeedingSchedule {
	ArrayList<FeedingTask> schedule;
	
	public FeedingSchedule(){
		this.schedule = retrieveTasks();
	}
	
	public boolean addTask(FeedingTask task){
		if(DBInterface.add(task.toString())){
			schedule.add(task);
			return true;
		}
		
		return false;
	}
	
	public boolean removeTask(FeedingTask task){
		if(DBInterface.delete(task.toString())){
			schedule.remove(task);
			return true;
		}
		
		return false;
	}
	
	public boolean completeTask(FeedingTask task){
		task.setCompleationStatus(true);
		if(DBInterface.update(task.toString())){
			return true;
		}
		
		task.setCompleationStatus(false);
		return false;
	}
	
	public FeedingTask getNext(){
		FeedingTask task = schedule.get(0);
		removeTask(task);
		return task;
	}
	
	public ArrayList<FeedingTask> getSchedule() {
		return schedule;
	}
	
	private ArrayList<FeedingTask> retrieveTasks() {
		ArrayList<FeedingTask> schedule = new ArrayList<>();
		
		for(Map.Entry<String, Map<String, String>> entry : DBInterface.select("tasks").entrySet()){
			Map<String, String> taskMap = entry.getValue();
			
			FeedingTask task = FeedingTask.buildTask(taskMap);
			schedule.add(task);
		}
		
		return schedule;
	}
}
