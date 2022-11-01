import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;

public class Sandwich extends Food {
    private HashSet<String> fillings = new HashSet<>();

    private static HashMap<String, Integer> availableFillings= new HashMap<>(){{
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

    public Sandwich(String[] fillings){
        super("Sandwich");
        for(String filling : fillings){
            this.fillings.add(filling);
        }
    }

    public Sandwich(){
        super("Sandwich");

    }

    public String[] getFillings(){
        String[] fillings = new String[this.fillings.size()];
        int i=0;
        for(String filling : this.fillings){
            fillings[i] = filling;
            i++;
        }
        return fillings;
    }

    @Override
    public void show(){
        System.out.print(getName() + " with ");
        Iterator<String> filling = fillings.iterator();
        while(filling.hasNext()){
            System.out.print(filling.next());

            if(filling.hasNext()){
                System.out.print(", ");
            }else{
                System.out.print("\n");
            }
        }
    }

    @Override
    public void consume(){
        System.out.println(toString() + " is consumed");
    }

    @Override
    public String toString(){
        StringBuilder meal = new StringBuilder();
        meal.append(getName() + " with ");
        for(String filling: fillings){
            meal.append(filling + " ");
        }
        return meal.toString();
    }

    @Override
    public int calculateCalories(){
        int calories = 200;
        for(String filling : fillings){
            calories += availableFillings.get(filling);
        }

        return calories;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) // сравниваем ссылки
            return true;
        if(obj == null || getClass() != obj.getClass()) // проверка на принадлежность нужному классу
            return false;
        Sandwich sandwich = (Sandwich) obj; // преобразование к нужному классу
        return(this.fillings.equals(sandwich.fillings)); // сравниваем поле объектов
    }
}
