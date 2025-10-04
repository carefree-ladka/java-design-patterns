package behavioral.strategy;

public class UpiPayment implements PaymentStrategy {
    private String UPIId;

    public UpiPayment(String UPIId) {
        this.UPIId = UPIId;
    }

    @Override
    public void pay(int amount) {
        IO.println("Paid " + amount + " using UPI " + UPIId);
    }
}
