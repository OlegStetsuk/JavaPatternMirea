package Task08.Command;

public class OrderMostExpensiveDishCommand implements Command{
    @Override
    public void order() {
        System.out.println("The most expensive dish was just ordered!");
    }
}
