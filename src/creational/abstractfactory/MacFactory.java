package creational.abstractfactory;

public class MacFactory implements GUIFactory {

    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ICheckbox createCheckbox() {
        return new MacCheckbox();
    }
}
