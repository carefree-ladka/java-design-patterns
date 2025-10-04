package behavioral.state;

public class HasCoinState implements State {
    private VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        IO.println("Coin already inserted");
    }

    @Override
    public void pressButton() {
        IO.println("Item dispensed");
        machine.setState(machine.getNoCoinState());
    }
}
