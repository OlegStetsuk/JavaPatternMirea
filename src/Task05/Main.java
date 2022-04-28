package Task05;

public class Main {
    public static void main(String[] args) {
        FirstSingleton singleton1 = FirstSingleton.getInstance();
        FirstSingleton singleton1Another = FirstSingleton.getInstance();

        SecondSingleton singleton2 = SecondSingleton.getInstance();
        SecondSingleton singleton2Another = SecondSingleton.getInstance();

        ThirdSingleton singleton3 = ThirdSingleton.INSTANCE;
        ThirdSingleton singleton3Another = ThirdSingleton.INSTANCE;

        System.out.println("Singleton 1 hashes");
        System.out.println(singleton1.hashCode() + " " + singleton1Another.hashCode() + " " + singleton1.equals(singleton1Another) + "\n");

        System.out.println("Singleton 2 hashes");
        System.out.println(singleton2.hashCode() + " " + singleton2Another.hashCode() + " " + singleton2.equals(singleton2Another) + "\n");

        System.out.println("Singleton 3 hashes");
        System.out.println(singleton3.hashCode() + " " + singleton3Another.hashCode() + " " + singleton3.equals(singleton3Another) + "\n");
    }
}
