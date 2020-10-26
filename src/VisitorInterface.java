import java.util.ArrayList;
import java.util.Scanner;

public class VisitorInterface {
	private final Scanner input;
	private final SpeciesList species;
	private final AnimalList animals;
	
	public VisitorInterface(Scanner input, SpeciesList species, AnimalList animals) {
		this.input = input;
		this.species = species;
		this.animals = animals;
	}
	
	public void run(){
		boolean loggedIn = true;
		
		do {
			int selection = prompt();
			switch(selection){
				case 1:
					displayAnimals();
					break;
				case 2:
					displaySpecies();
					break;
				default:
					loggedIn = false;
			}
			
		}while(loggedIn);
	}
	
	private int prompt(){
		boolean validSelection = false;
		int selection;
		
		do {
			System.out.println("Welcome to Bervard Zoo, what would you like to know?");
			System.out.println("1. Learn about a specific animal");
			System.out.println("2. Learn about a species");
			System.out.println("3. Log out");
			
			selection = input.nextInt();
			if(selection >= 1 && selection <= 3){
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
	
	private void displaySpecies() {
		boolean display = true;
		int selection;
		int numSpecies = this.species.getSpeciesList().size();
		
		do{
			System.out.println("Which species do you want to view?");
			
			for(int i = 0; i < numSpecies; i++){
				System.out.println((i+1) + ". " + species.getSpecies(i).getName());
			}
			
			System.out.println((numSpecies + 1) + ". Back");
			selection = input.nextInt() - 1;
			
			if(selection >=0 && selection < numSpecies){
				System.out.println(species.getSpecies(selection).toString());
			}else if(selection == numSpecies){
				display = false;
			}else{
				System.out.println("Invalid Selection, enter number before selection and press enter\n");
			}
			
		}while(display);
	}
}
