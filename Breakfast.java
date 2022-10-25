import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Comparator;
// import java.util.HashSet;
// import java.util.Iterator;
import java.util.Collections;

public class Breakfast {
    public ArrayList<Food> breakfast = new ArrayList<>();

    public void addFood(Scanner console){

        String input = console.nextLine();
        String[] mealParts = input.split("/");

        if( mealParts.length != 3 ||
            !(mealParts[0].equals(new Sandwich().getName())) ||
            !(Fillings.fillings.containsKey(mealParts[1])) ||
            !(Fillings.fillings.containsKey(mealParts[2]))
        ){
            System.out.println("Incorrect data entered.");
            return;
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

    public void sort(){
        Collections.sort(breakfast, new Comparator<Food>() {
                public int compare(Food f1, Food f2){
                    if(f1 == null) return 1;
                    if(f2 == null) return -1;
                    int len1=0;
                    int len2=0;
                    for(String filling : ((Sandwich) f1).getFillings()){
                        len1 += filling.length();
                    }
                    for(String filling : ((Sandwich) f2).getFillings()){
                        len2 += filling.length();
                    }
                    if(len1 > len2)
                        return 1;
                    if(len2 > len1)
                        return -1;
                    return 0;
                }
            });
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