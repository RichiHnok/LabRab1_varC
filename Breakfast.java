import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Scanner;
// import java.util.HashMap;
// import java.util.Comparator;
import java.util.StringTokenizer;
// import java.util.HashSet;
// import java.util.Iterator;
// import java.util.Collections;

public class Breakfast{
    public ArrayList<Food> breakfast = new ArrayList<>();

    public Food createMeal(Scanner console){
        String input = console.nextLine();
        StringTokenizer mealParts = new StringTokenizer(input, "/");
        String meal = mealParts.nextToken();

        if(meal.equals("Sandwich")){
            if(mealParts.countTokens() < 1){
                // обратка сэндвича без начинок
            }
            String[] fillings = new String[mealParts.countTokens()];
            int amountOfFillings = mealParts.countTokens();
            for(int i=0; i < amountOfFillings; i++){
                String temp = mealParts.nextToken();
                if(Sandwich.availableFillings.containsKey(temp))
                    fillings[i] = temp;
                else{
                    // обработка неправильного ввода
                }
            }
            Sandwich sandwich = new Sandwich(fillings);
            return sandwich;

        }else if(meal.equals("Apple")){
            if(mealParts.countTokens() != 1){
                // обработка неправильного ввода
            }
            String appleSize = mealParts.nextToken();
            Apple apple = new Apple(appleSize);
            return apple;

        }else if(meal.equals("Cheese")){
            Cheese cheese = new Cheese();
            return cheese;

        }

        return null;
    }

    public void anotherAddFood(Food food){
        breakfast.add(food);
    }

    // public void addFood(Scanner console){

    //     String input = console.nextLine();
    //     StringTokenizer mealParts = new StringTokenizer(input, "/");
    //     String meal = mealParts.nextToken();

    //     if(meal.equals("Sandwich")){
    //         if(mealParts.countTokens() < 1){
    //             // обратка сэндвича без начинок
    //         }
    //         String[] fillings = new String[mealParts.countTokens()];
    //         int amountOfFillings = mealParts.countTokens();
    //         for(int i=0; i < amountOfFillings; i++){
    //             String temp = mealParts.nextToken();
    //             if(Sandwich.availableFillings.containsKey(temp))
    //                 fillings[i] = temp;
    //             else{
    //                 // обработка неправильного ввода
    //             }
    //         }
    //         Sandwich sandwich = new Sandwich(fillings);
    //         breakfast.add(sandwich); 
        
    //     }else if(meal.equals("Apple")){
    //         if(mealParts.countTokens() != 1){
    //             // обработка неправильного ввода
    //         }
    //         String appleSize = mealParts.nextToken();
    //         Apple apple = new Apple(appleSize);
    //         breakfast.add(apple);

    //     }else if(meal.equals("Cheese")){
    //         Cheese cheese = new Cheese();
    //         breakfast.add(cheese);

    //     }else{
    //         // Здесь должен быть обработка некорректного ввода
    //     }
    // }

    public void consume(){
        
    }

    public int count(Food food){
        // System.out.print("Which meal you want to count?\n> ");
        // String input = console.nextLine();

        // Object countingMeal = new Object();
        // StringTokenizer mealParts = new StringTokenizer(input, "/");
        // String meal = mealParts.nextToken();
        // if(meal.equals("Sandwich")){
        //     if(mealParts.countTokens() < 1){
        //         // обратка сэндвича без начинок
        //     }
        //     String[] fillings = new String[mealParts.countTokens()];
        //     for(int i=0; i < mealParts.countTokens(); i++){
        //         String temp = mealParts.nextToken();
        //         if(Sandwich.availableFillings.containsKey(temp))
        //             fillings[i] = temp;
        //         else{
        //             // обработка неправильного ввода
        //         }
        //     }
        //     countingMeal = new Sandwich(fillings);

        // }else if(meal.equals("Apple")){
        //     if(mealParts.countTokens() != 1){
        //         // обработка неправильного ввода
        //     }
        //     String appleSize = mealParts.nextToken();
        //     countingMeal = new Apple(appleSize);

        // }else if(meal.equals("Cheese")){
        //     countingMeal = new Cheese();

        // }else{

        // }
        Food countingMeal = food;

        int counter=0;
        for(Food currentMeal : breakfast){
            if(countingMeal.equals(currentMeal))
                counter++;
        }       
        return counter;
    }

    public void anotherCount(int counter){
        System.out.println("Amount of this meal is " + counter);
    }

    public void show(){
        System.out.println("Breakfast consists of:");
        for(Food meal: breakfast){
            meal.show();
        }
    }

    public void sort(){
        // Collections.sort(breakfast, new Comparator<Food>() {
        //     public int compare(Object f1, Food f2){
        //         (f1.getClass() f1);
        //         if(f1 == null) return 1;
        //         if(f2 == null) return -1;
        //         // int len1=0;
        //         // int len2=0;
        //         // for(String filling : ((Sandwich) f1).getFillings()){
        //         //     len1 += filling.length();
        //         // }
        //         // for(String filling : ((Sandwich) f2).getFillings()){
        //         //     len2 += filling.length();
        //         // }
        //         // if(len1 > len2)
        //         //     return 1;
        //         // if(len2 > len1)
        //         //     return -1;
        //         return 0;
        //     }
        // });
    }

    // public void calculateCalories(){
    //     int calories = 0;
    //     for(Food meal : breakfast){
    //         for(String mealPart : (meal.getClass() meal).getFillings()){

    //         }
    //     }
    //     System.out.println("Breakfast contains " + calories);
    // }
}