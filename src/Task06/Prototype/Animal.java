package Task06.Prototype;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(){};
    public Animal(Animal animal){
        this.name = animal.name;
        this.age = animal.age;
    }

    public abstract Animal clone();

}
