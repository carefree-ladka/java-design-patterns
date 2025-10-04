package behavioral.strategy;

public class Main {
    void main() {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment("123-456-7897"));
        cart.checkout(500);

        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(1500);

        cart.setPaymentStrategy(new UpiPayment("user@upi"));
        cart.checkout(300);
    }
}
