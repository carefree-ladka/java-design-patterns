package behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        IO.println("Paid amount " + amount + " using Credit Card " + cardNumber);
    }
}
