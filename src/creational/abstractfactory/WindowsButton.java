package creational.abstractfactory;

public class WindowsButton implements IButton {

    @Override
    public void paint() {
        IO.println("Painting Windows Button");
    }
}
