package solidprinciples.ecommerce.payment;

public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        IO.println("Paid $" + amount + " with Credit Card");
    }
}
