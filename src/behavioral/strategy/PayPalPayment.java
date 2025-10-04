package behavioral.strategy;

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        IO.println("Paid " + amount + " using PayPal " + email);
    }
}
