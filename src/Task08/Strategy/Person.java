package Task08.Strategy;

public class Person {
    public Payment payment;
    public boolean hasStripe;
    public Person(boolean hasStripe){
        this.hasStripe = hasStripe;
    }
    public void pay() {
        if (hasStripe) {
            payment = new PaymentWithStripe();
            return;
        }
        payment = new PaymentWithPayPal();
        payment.execute();
    }
}
