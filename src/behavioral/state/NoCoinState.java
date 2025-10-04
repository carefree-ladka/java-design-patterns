package behavioral.state;

public class NoCoinState implements State {
    private VendingMachine machine;

    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        IO.println("Coin inserted");
        machine.setState(machine.getHasCoinState());
    }

    @Override
    public void pressButton() {
        IO.println("Insert coin first");
    }
}
