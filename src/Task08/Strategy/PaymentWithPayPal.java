package Task08.Strategy;

public class PaymentWithPayPal implements Payment {
    @Override
    public void execute() {
        System.out.println("Payment has been done with PayPal");
    }
}
