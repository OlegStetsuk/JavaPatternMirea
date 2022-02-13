package Task06.Factory;

public class DogeFactory implements Factory{
    @Override
    public Animal animalFactory() {
        return new Doge();
    }
}
