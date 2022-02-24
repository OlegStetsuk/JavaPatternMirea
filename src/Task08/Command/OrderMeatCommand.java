package Task08.Command;

public class OrderMeatCommand implements Command{
    @Override
    public void order() {
        System.out.println("Meat was ordered");
    }
}
