package solidprinciples.ecommerce.payment;

public class PayPalPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        IO.println("Paid $" + amount + " with PayPal");
    }
}
