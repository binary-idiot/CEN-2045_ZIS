import java.util.Scanner;

public class StaffInterface {
    private final Scanner input;
    private final AnimalList animals;
    private final SpeciesList species;
    private final AppointmentList appointments;
    private final FeedingSchedule schedule;
    
    public StaffInterface(Scanner input, AnimalList animals, SpeciesList species, AppointmentList appointments, FeedingSchedule schedule) {
        this.animals = animals;
        this.species = species;
        this.appointments = appointments;
        this.schedule = schedule;
        this.input = input;
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
                case 3:
                    addAnimal();
                    break;
                case 4:
                    addSpecies();
                    break;
                case 5:
                    feedAnimal();
                    break;
                case 6:
                    createAppointment();
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
            System.out.println("Welcome to Bervard Zoo, what would you like to do?");
            System.out.println("1. display animals");
            System.out.println("2. display species");
            System.out.println("3. Add animal");
            System.out.println("4. Add Species");
            System.out.println("5. Feed animal");
            System.out.println("6. Create Appointment");
            System.out.println("7. Log out");
            
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
            
            System.out.println(numAnimals + ". Back");
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
            
            System.out.println(numSpecies + ". Back");
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
    
    private void addAnimal() {
        System.out.println("Enter id");
        String id = input.nextLine();
        
        System.out.println("Enter name");
        String name = input.nextLine();
        
        System.out.println("Enter Species name");
        Species species = this.species.getSpecies(input.nextLine());
        
    }
    
    private void addSpecies(){
    
    }
    
    private void feedAnimal(){
    
    }
    
    private void createAppointment(){
    
    }
}
