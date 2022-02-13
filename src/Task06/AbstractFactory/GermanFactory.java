package Task06.AbstractFactory;

public class GermanFactory implements CountryFactory{
    @Override
    public Product createClothes() {
        return new Clothes();
    }

    @Override
    public Product createFood() {
        return new Food();
    }
}
