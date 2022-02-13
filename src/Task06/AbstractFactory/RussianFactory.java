package Task06.AbstractFactory;

public class RussianFactory implements CountryFactory{
    @Override
    public Product createClothes() {
        return new Clothes();
    }

    @Override
    public Product createFood() {
        return new Food();
    }
}
