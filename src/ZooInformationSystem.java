import java.util.Scanner;

public class ZooInformationSystem {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		AnimalList animals = new AnimalList();
		SpeciesList species = new SpeciesList();
		AppointmentList appointments = new AppointmentList();
		FeedingSchedule schedule = new FeedingSchedule();
		
		VisitorInterface visitor = new VisitorInterface(input, species, animals);
		StaffInterface staff = new StaffInterface(input, animals, species, appointments, schedule);
		VetInterface vet = new VetInterface(input, animals, appointments);
		LoginInterface login = new LoginInterface(input, visitor, staff, vet);
		
		login.run();
		
		input.close();
	}
}
