import java.util.Scanner;

public class LoginInterface {
	private final Scanner input;
	private final VisitorInterface visitor;
	private final StaffInterface staff;
	private final VetInterface vet;
	
	
	public LoginInterface(Scanner input, VisitorInterface visitor, StaffInterface staff, VetInterface vet){
		this.input = input;
		this.visitor = visitor;
		this.staff = staff;
		this.vet = vet;
		
	}
	
	public void run(){
		boolean exit = false;
		
		do{
			int select = prompt();
			switch(select){
				case 1:
					visitor.run();
					break;
				case 2:
					staff.run();
					break;
				case 3:
					vet.run();
					break;
				default:
					exit = true;
			}
		}while(!exit);
		
		input.close();
	}
	
	private int prompt() {
		System.out.println("Welcome to Bervard Zoo Information System");
		
		int selection;
		Boolean validSelection = false;
		
		do {
			System.out.println("Login as:");
			System.out.println("1. Visitor");
			System.out.println("2. Staff");
			System.out.println("3. Vet");
			System.out.println("4. Exit");
			System.out.println("Enter number for corresponding login:");
			
			selection = input.nextInt();
			input.nextLine();
			if(selection >= 1 && selection <= 4){
				validSelection = true;
			}else{
				System.out.println("Invalid Selection, enter number before selection and press enter\n");
			}
			
		}while(!validSelection);
		
		return selection;
	}
}
