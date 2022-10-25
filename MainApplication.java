import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args){  
        System.out.println("Programm started.");
        Scanner console = new Scanner(System.in);
        
        Breakfast breakfast = new Breakfast();

        while(true){
            System.out.print("> ");
            String command = console.nextLine();

            if(command.equals("-exit")){
                System.out.println("Program completed.");
                break;
            }

            switch(command){
                case "-add":
                    breakfast.addFood(console);
                    break;
                case "-sort":
                    breakfast.sort();
                    break;
                case "-show":
                    breakfast.show();
                    break;
                case "-count":
                    breakfast.showCount(console);
                    break;
                case "-help":
                    System.out.println("The following commands are available:");
                    System.out.println("-add  (Adds to breakfast another sandwich with 2 fillings)");
                    System.out.println("-count  (Counts amount of choosen meal)");
                    System.out.println("-sort  (Sorts list by word length)");
                    System.out.println("-show (Show from what breakfast consits)");
                    System.out.println("-help (Show available commands and its functions)");
                    System.out.println("-exit (Completes programm)");
                    break;
                default :
                    System.out.println("There is no such command. If you struggle use -help.");
                    break;
            }
        }

        console.close();
    }
}