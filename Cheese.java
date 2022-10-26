public class Cheese extends Food {
    private int cheeseCalories = 400;

    public Cheese(){
        super("Cheese");
    }

    @Override
    public void consume(){
        System.out.println(toString() + " is consumed.");
    }

    @Override
    public int calculateCalories(){
        return cheeseCalories;
    }
}
