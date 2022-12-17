import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args){  
        System.out.println("Programm started.");
        Scanner console = new Scanner(System.in);
        
        Breakfast breakfast = new Breakfast();

        while(true){
            try{
                System.out.print("> ");
                String command = console.nextLine();
    
                if(command.equals("-exit")){
                    System.out.println("Program completed.");
                    break;
                }
    
                switch(command){
                    case "-add":
                        System.out.print("Which meal you want to add?\n");
                        breakfast.addFood(breakfast.createMeal(console));
                        break;
                    case "-consume":
                        System.out.print("Which meal you want to consume?\n");
                        breakfast.consume(breakfast.createMeal(console));
                        break;
                    case "-sort":
                        breakfast.sort();
                        break;
                    case "-show":
                        breakfast.show();
                        break;
                    case "-count":
                        System.out.print("Which meal you want to count?\n");
                        breakfast.anotherCount(breakfast.count(breakfast.createMeal(console)));
                        break;
                    case "-calories":
                        breakfast.calculateCalories();
                        break;
                    case "-help":
                        System.out.println("The following commands are available:");
                        System.out.println("-add  (Adds to breakfast anoyher product)");
                        System.out.println("-consume  (Removes from breakfast a certain meal)");
                        System.out.println("-sort  (Sorts list of meals in breakfst by their name length)");
                        System.out.println("-show (This command shows from what meals breakfast consits)");
                        System.out.println("-count  (Counts amount of choosen meal)");
                        System.out.println("-calories  (This command shows the total calories of breakfast )");
                        System.out.println("-help (Show available commands and its functions)");
                        System.out.println("-exit (Completes programm)");
                        break;
                    default :
                        System.out.println("There is no such command. To get know which commands are available use -help.");
                        break;
                }
            }catch(NullPointerException e){
                System.out.println("--Invalid input--");
                continue;
            }
        }

        console.close();
    }
}