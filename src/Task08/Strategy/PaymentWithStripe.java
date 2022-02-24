package Task08.Strategy;

public class PaymentWithStripe implements Payment{
    @Override
    public void execute() {
        System.out.println("Payment has been done with Stripe");
    }
}
