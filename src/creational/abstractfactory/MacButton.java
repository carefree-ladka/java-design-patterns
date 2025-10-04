package creational.abstractfactory;

public class MacButton implements IButton {

    @Override
    public void paint() {
        IO.println("Painting Mac Button");
    }
}
