package creational.abstractfactory;

public class WindowsCheckbox implements ICheckbox {

    @Override
    public void paint() {
        IO.println("Painting Windows Checkbox");
    }
}
