import java.time.LocalDateTime;
import java.util.Optional;
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
                    viewSchedule();
                    break;
                case 6:
                    feedAnimal();
                    break;
                case 7:
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
            System.out.println("5. View feeding schedule");
            System.out.println("6. Feed animal");
            System.out.println("7. Create Appointment");
            System.out.println("8. Log out");
            
            selection = input.nextInt();
            if(selection >= 1 && selection <= 8){
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
    
    private Animal addAnimal() {
        System.out.println("Enter id");
        String id = input.nextLine();
        
        System.out.println("Enter name");
        String name = input.nextLine();
        
        System.out.println("Enter Species name");
        String speciesName = input.nextLine();
        Species species;
        Optional<Species> speciesResult = this.species.getSpecies(input.nextLine());
        if(speciesResult.isPresent()){
            species = speciesResult.get();
        }else{
            System.out.println(speciesName + " does not exist, create now");
            species = addSpecies();
        }
        
        System.out.println("Enter enclosure number");
        int enclosure = input.nextInt();
        
        System.out.println("Enter enclosure info");
        String info = input.nextLine();
        
        Animal animal = new Animal(id, name, species, new Enclosure(enclosure, info));
        animals.addAnimal(animal);
        return animal;
    }
    
    private Species addSpecies(){
        System.out.println("Enter name");
        String name = input.nextLine();
        
        System.out.println("Enter info");
        String info = input.nextLine();
        
        System.out.println("Enter food");
        String food = input.nextLine();
        
        System.out.println("Enter food amount");
        int amount = input.nextInt();
        
        Species species = new Species(name, info, food, amount);
        this.species.addSpecies(species);
        return species;
    }
    
    private void viewSchedule(){
        for(int i = 0; i < schedule.getSchedule().size(); i++){
            System.out.println((i + 1) + ". " + schedule.getSchedule().get(i).toString());
        }
    }
    
    private void feedAnimal(){
        System.out.println("1. Feed next animal\nor\n2. Feed specific animal");
        int selection = input.nextInt();
        FeedingTask task;
        
        if(selection == 1) {
            task = schedule.getNext();
        }else if(selection == 2){
            System.out.println("Enter number of feeding task to complete");
            viewSchedule();
            int selectedTask = input.nextInt() - 1;
             task = schedule.getSchedule().get(selectedTask);
        }else{
            System.out.println("Invalid selection");
            return;
        }
    
        schedule.completeTask(task);
        System.out.println(task.getAnimal() + " fed");
    }
    
    private void createAppointment(){
        System.out.println("Enter animal");
        Animal animal = animals.getAnimal(input.nextInt());
        
        System.out.println("Enter appointment time (YYYY-MM-DDThh:mm:00)");
        LocalDateTime time = LocalDateTime.parse(input.nextLine());
        
        appointments.addApointment(new Appointment(animal, time));
    }
}
