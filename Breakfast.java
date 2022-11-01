import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Comparator;
import java.util.StringTokenizer;
// import java.util.HashSet;
// import java.util.Iterator;
import java.util.Collections;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Breakfast{
    public ArrayList<Food> breakfast = new ArrayList<>();

    public Food createMeal(Scanner console){
        String input = console.nextLine();
        StringTokenizer mealParts = new StringTokenizer(input, "/");
        String meal = mealParts.nextToken();

        if(meal.equals("Sandwich")){
            if(mealParts.countTokens() < 1){
                //~ System.out.println("Wrong input");
                return null;
            }
            String[] fillings = new String[mealParts.countTokens()];
            int amountOfFillings = mealParts.countTokens();
            for(int i=0; i < amountOfFillings; i++){
                String temp = mealParts.nextToken();
                // if(Sandwich.availableFillings.containsKey(temp)) //^
                HashMap<String, Integer> availableFillings = null;
                try{
                    Field field = Sandwich.class.getDeclaredField("availableFillings");
                    field.setAccessible(true);
                    availableFillings = (HashMap<String, Integer>)  field.get(null);
                }catch(NoSuchFieldException | IllegalAccessException e){
                    e.printStackTrace();
                }
                if(availableFillings.containsKey(temp)){    //todo 
                    fillings[i] = temp;
                }else{
                    //~ System.out.println("Wrong input");
                    return null;    
                }
            }
            Sandwich sandwich = new Sandwich(fillings);
            return sandwich;

        }else if(meal.equals("Apple")){
            if(mealParts.countTokens() != 1){
                //~ System.out.println("Wrong input");
                return null;
            }
            String appleSize = mealParts.nextToken();
            if(Apple.availableSizes.containsKey(appleSize)){
                Apple apple = new Apple(appleSize);
                return apple;
            }else{
                //~ System.out.println("Wrong input");
                return null;
            }

        }else if(meal.equals("Cheese")){
            Cheese cheese = new Cheese();
            return cheese;

        }
        //~ System.out.println("Wrong input");
        return null;
    }

    public void addFood(Food food){
        if(food == null)
            throw new NullPointerException();
            
        breakfast.add(food);
    }

    public void consume(Food food){
        if(food == null)
            throw new NullPointerException();

        Food consumableFood = food;
        int index = breakfast.indexOf(consumableFood);
        if(index != -1){
            // breakfast.remove(index).consume(); //^
            try{
                Class<? extends Food> foodClass = breakfast.get(index).getClass(); 
                Method consumeMethod = foodClass.getMethod("consume");
                consumeMethod.invoke(breakfast.remove(index)); //todo
            }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }else{
            // System.out.println("Breakfast doesn't consists " + consumableFood.toString()); //^
            try{
                Class<? extends Food> foodClass = breakfast.get(index).getClass(); 
                Method toStringMethod = foodClass.getMethod("toString");
                System.out.println("Breakfast doesn't consists " + toStringMethod.invoke(consumableFood)); //todo
            }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }
    }

    public int count(Food food){
        if(food == null)
            throw new NullPointerException();

        Food countingMeal = food;

        int counter=0;
        for(Food currentMeal : breakfast){
            // if(countingMeal.equals(currentMeal)) //^
            //     counter++;
            try{
                Class<? extends Food> foodClass = countingMeal.getClass(); 
                Method equalsMethod = foodClass.getMethod("equals", Object.class);
                if((boolean) equalsMethod.invoke(countingMeal, currentMeal)); //todo
                    counter++;
            }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }       
        return counter;
    }

    public void anotherCount(int counter){
        System.out.println("Amount of this meal is " + counter);
    }

    public void show(){
        System.out.println("Breakfast consists of:");
        for(Food meal: breakfast){
            // meal.show(); //^
            
            try{
                Class<? extends Food> foodClass = meal.getClass(); 
                Method showMethod = foodClass.getMethod("show");
                showMethod.invoke(meal); //todo
            }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }
    }

    public void sort(){
        Collections.sort(breakfast, new Comparator<Food>(){
            public int compare(Food f1, Food f2){
                if(f1 == null) return 1;
                if(f2 == null) return -1;
                // int len1 = f1.toString().length(); //^ 
                // int len2 = f2.toString().length(); //^
                    int len1=0;
                    int len2=0;
                try{
                    Class<? extends Food> foodClass = Food.class; 
                    Method toStringMethod = foodClass.getMethod("toString");
                    len1 = ((String) toStringMethod.invoke(f1)).length(); //todo
                    len2 = ((String) toStringMethod.invoke(f2)).length(); //todo
                }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                    e.printStackTrace();
                }
    
                if(len1 > len2)
                    return 1;
                if(len2 > len1)
                    return -1;
                return 0;
            }
        });
    }
    
    public void calculateCalories(){
        int calories = 0;
        for(Food meal : breakfast){
            // calories += meal.calculateCalories(); //^
            try{
                Class<? extends Food> foodClass = meal.getClass(); 
                Method calculateCaloriesMethod = foodClass.getMethod("calculateCalories");
                calories += (int) calculateCaloriesMethod.invoke(meal); //todo
            }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }

        }
        System.out.println("Breakfast contains in total " + calories + " calories");
    }
}