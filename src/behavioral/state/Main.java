package behavioral.state;

public class Main {
    void main() {
        VendingMachine machine = new VendingMachine();

        machine.pressButton(); // Insert coin first
        machine.insertCoin(); // Coin inserted
        machine.insertCoin(); // Coin already inserted
        machine.pressButton(); // Item dispensed
        machine.pressButton(); // Insert coin first
    }
}
