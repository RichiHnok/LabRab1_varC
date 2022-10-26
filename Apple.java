import java.util.HashMap;

public class Apple extends Food {
    public HashMap<String, Integer> sizes = new HashMap<>(){{
        put("Small", 10);
        put("Medium", 15);
        put("Big", 20);
    }};

    private String size;

    public String getSize(){
        return size;
    }

    public Apple(String size){
        super("Apple");
        this.size = size;
    }

    public Apple(){
        super("Apple");
    }
    
    @Override
    public void consume(){
        System.out.println(size + getName() + "is consumed");
    }

    @Override
    public void show(){
        System.out.println(size + " " + getName());
    }

    @Override
    public int calculateCalories(){
        return 0;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Apple apple = (Apple) obj;
        return (this.size.equals(apple.getSize()));
    }
}
