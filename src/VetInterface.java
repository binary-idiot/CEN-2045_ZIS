import java.time.LocalDateTime;
import java.util.Scanner;

public class VetInterface {
	private Scanner input;
	private final AnimalList animals;
	private final AppointmentList appointments;
	
	public VetInterface(Scanner input, AnimalList animals, AppointmentList appointments) {
		this.animals = animals;
		this.appointments = appointments;
		this.input = input;
	}
	
	public void run(){
		boolean loggedin = true;
		
		do{
			int selection = prompt();
			
			switch(selection) {
				case 1:
					displayAnimals();
					break;
				case 2:
					modifyNotes();
					break;
				case 3:
					viewAppointments();
					break;
				case 4:
					createAppointment();
					break;
				case 5:
					removeAppointment();
					break;
				case 6:
					orderMedicine();
					break;
				default:
					loggedin = false;
			}
			
		}while(loggedin);
	}
	
	private int prompt(){
		boolean validSelection = false;
		int selection;
		
		do {
			System.out.println("Welcome to Bervard Zoo, what would you like to do?");
			System.out.println("1. Display animals");
			System.out.println("2. Modify notes");
			System.out.println("3. View appointment");
			System.out.println("4. Create appointment");
			System.out.println("5. Remove appointment");
			System.out.println("6. Order Medicine");
			System.out.println("7. Logout");
			
			selection = input.nextInt();
			if(selection >= 1 && selection <= 7){
				validSelection = true;
			}else{
				System.out.println("Invalid Selection, enter number before selection and press enter\n");
			}
			
		}while(!validSelection);
		
		return selection;
	}
	
	private void displayAnimals() {
		boolean display = true;
		int selection;
		int numAnimals = this.animals.getAnimals().size();
		
		do{
			System.out.println("Which animal do you want to view?");
			
			for(int i = 0; i < numAnimals; i++){
				System.out.println((i+1) + ". " + animals.getAnimal(i).getName());
			}
			
			System.out.println((numAnimals + 1) + ". Back");
			selection = input.nextInt() - 1;
			
			if(selection >=0 && selection < numAnimals){
				System.out.println(animals.getAnimal(selection).toString());
			}else if(selection == numAnimals){
				display = false;
			}else{
				System.out.println("Invalid Selection, enter number before selection and press enter\n");
			}
			
		}while(display);
	}
	
	private void modifyNotes() {
		System.out.println("Which animal do you want to add notes to?");
		Animal animal = animals.getAnimal(input.nextInt());
		
		System.out.println("What notes do you want to add?");
		String notes = input.nextLine();
		
		animal.modifyNotes(notes);
	}
	
	private void viewAppointments() {
		for(int i = 0; i < appointments.getAppointments().size(); i++){
			System.out.println((i + 1) + ". " + appointments.getAppointments().get(i).toString()
			);
		}
	}
	
	private void createAppointment(){
		System.out.println("Enter animal");
		Animal animal = animals.getAnimal(input.nextInt());
		
		System.out.println("Enter appointment time (YYYY-MM-DDThh:mm:00)");
		LocalDateTime time = LocalDateTime.parse(input.nextLine());
		
		appointments.addApointment(new Appointment(animal, time));
	}
	
	private void removeAppointment() {
		System.out.println("Enter appointment you want to remove");
		viewAppointments();
		int appointmentNum = input.nextInt();
		Appointment appointment = appointments.getAppointments().get(appointmentNum);
		appointments.removeAppointment(appointment);
	}
	
	private void orderMedicine() {
		System.out.println("Which medicine do you want to order");
	}
}
