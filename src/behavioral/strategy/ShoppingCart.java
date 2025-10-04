package behavioral.strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;


    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            throw new IllegalArgumentException("Payment Strategy not set");
        }
        paymentStrategy.pay(amount);
    }
}
