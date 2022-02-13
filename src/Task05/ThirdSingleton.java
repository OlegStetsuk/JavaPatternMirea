package Task05;

public class ThirdSingleton {
    private static final ThirdSingleton INSTANCE = new ThirdSingleton();

    private ThirdSingleton() {

    }

    public static ThirdSingleton getInstance() {
        return INSTANCE;
    }
}