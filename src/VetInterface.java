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
	
	}
}
