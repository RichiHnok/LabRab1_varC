import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args){  
        Scanner console = new Scanner(System.in);
        
        Breakfast breakfast = new Breakfast();
        breakfast.addFood(console);
        breakfast.addFood(console);
        breakfast.show();

        console.close();
    }
}