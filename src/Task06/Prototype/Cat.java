package Task06.Prototype;

public class Cat extends Animal{
    private boolean eatsALot;
    public Cat(){}
    public Cat(Cat cat) {
        super(cat);
        this.eatsALot = cat.eatsALot;
    }

    @Override
    public Animal clone() {
        return new Cat(this);
    }
}
