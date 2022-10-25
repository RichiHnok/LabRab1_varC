import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Breakfast {
    public ArrayList<Food> breakfast = new ArrayList<>();

    public void addFood(Scanner console){
        // try{

        // }catch(ClassNotFoundException e){

        // }catch(NoSuchMethodException e){

        // }
        String input = console.nextLine();
        String[] mealParts = input.split("/");

        if( mealParts.length != 3 ||
            !(mealParts[0].equals(new Sandwich().getName())) ||
            !(Fillings.fillings.containsKey(mealParts[1])) ||
            !(Fillings.fillings.containsKey(mealParts[2]))
        ){

        }
        String[] fillings = Arrays.copyOfRange(mealParts, 1, mealParts.length);
        Sandwich sandwich = new Sandwich(fillings);
        breakfast.add(sandwich);
    }

    public int count(Scanner console){
        System.out.print("Which meal you want to count?\n> ");
        String input = console.nextLine();
        String[] mealParts = input.split("/");

        String[] fillings = Arrays.copyOfRange(mealParts, 1, mealParts.length);
        Sandwich sandwich = new Sandwich(fillings);
        int counter=0;
        for(Food meal : breakfast){
            if(sandwich.equals(meal))
                counter++;
        }       
        return counter;
    }

    public void showCount(Scanner console){
        System.out.print("Which meal you want to count?\n> ");
        String input = console.nextLine();
        String[] mealParts = input.split("/");

        String[] fillings = Arrays.copyOfRange(mealParts, 1, mealParts.length);
        Sandwich sandwich = new Sandwich(fillings);
        int counter=0;
        for(Food meal : breakfast){
            if(sandwich.equals(meal))
                counter++;
        }       

        System.out.print("Amount of " + sandwich.getName());
        for(String filling : sandwich.getFillings()){
            System.out.print("/" + filling);
        }
        System.out.println(" is " + counter);
    }

    public void show(){
        System.out.println("Breakfast consists of:");
        for(Food meal: breakfast){
            meal.show();
        }
    }
}

class Fillings{
    public static HashMap<String, Integer> fillings= new HashMap<>(){{
        put("Ham", 300);
        put("Cheese", 350);
        put("Cabbage", 27);
        put("Egg", 160);
        put("Tuna", 130);
        put("Pickles", 24);
        put("Tomato", 20);
        put("Sausage", 430);
        put("Mayonaise", 60);
        put("Butter", 750);
    }};
}