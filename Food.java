public abstract class Food implements Consumable, Nutritious{
    private String name;

    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    public Food(String name){
        this.name = name;
    }

    public void show(){
        System.out.println(name);
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) // сравниваем ссылки
            return true;
        if(obj == null || getClass() != obj.getClass()) // проверка на принадлежность нужному классу
            return false;
        Food food = (Food) obj; // преобразование к нужному классу
        return this.name.equals(food.name); // сравниваем поля объектов
    }

    @Override
    public void consume(){}

    @Override
    public abstract int calculateCalories(); 
}
