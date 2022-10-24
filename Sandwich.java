import java.util.HashSet;
import java.util.Iterator;

public class Sandwich extends Food {
    private HashSet<String> fillings = new HashSet<>();

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
        System.out.print("Sandwich with ");
        Iterator<String> filling = fillings.iterator();
        while(filling.hasNext()){
            System.out.print(filling.next());

            if(filling.hasNext()){
                System.out.print(", ");
            }else{
                System.out.println(".");
            }
        }
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) // сравниваем ссылки
            return true;
        if(obj == null || getClass() != obj.getClass()) // проверка на принадлежность нужному классу
            return false;
        Sandwich sandwich = (Sandwich) obj; // преобразование к нужному классу
        return(this.fillings.equals(sandwich.fillings)); // сравниваем поля объектов
    }
}
