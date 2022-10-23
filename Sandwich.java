public class Sandwich extends Food {
    private String filling1;
    private String filling2;

    public Sandwich(String filling1, String filling2){
        super("Sandwich");
        this.filling1 = filling1;
        this.filling2 = filling2;
    }

    public Sandwich(){
        super("Sandwich");
        filling1 = null;
        filling2 = null;
    }

    public String getFilling1(){
        return this.filling1;
    }
    public void setFilling1(String filling1){
        this.filling1 = filling1;
    }

    public String getFilling2(){
        return this.filling2;
    }
    public void setFilling2(String filling2){
        this.filling2 = filling2;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) // сравниваем ссылки
            return true;
        if(obj == null || getClass() != obj.getClass()) // проверка на принадлежность нужному классу
            return false;
        Sandwich sandwich = (Sandwich) obj; // преобразование к нужному классу
        return( 
            this.filling1.equals(sandwich.filling1) && this.filling2.equals(sandwich.filling2) ||
            this.filling1.equals(sandwich.filling2) && this.filling2.equals(sandwich.filling1)
        ); // сравниваем поля объектов
    }
}
