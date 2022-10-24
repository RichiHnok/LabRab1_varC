import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Breakfast {
    public ArrayList<Food> breakfast = new ArrayList<>();

    public void addFood(Scanner console){
        String input = console.next();
        String[] set = input.split("/");

        if( set.length != 3 ||
            !(set[0].equals("Sandwich")) ||
            !(Fillings.fillings.containsKey(set[1])) ||
            !(Fillings.fillings.containsKey(set[2]))
        ){

        }
        Sandwich sandwich = new Sandwich(Arrays.copyOfRange(set, 1, set.length));
        breakfast.add(sandwich);
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