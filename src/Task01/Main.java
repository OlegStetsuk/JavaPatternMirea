package Task01;
import java.lang.Math;
import java.util.function.Predicate;

class Check implements Predicate<Integer> {

    @Override
    public boolean test(Integer n) {

        var log = Math.log(n)/Math.log(2);
        return (int)log == log;
    }
}

public class Main{

    public static void main(String[] args) {
        Check obj = new Check();
        System.out.println(obj.test(10));
        System.out.println(obj.test(8));
    }
}
