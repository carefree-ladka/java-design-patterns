package creational.abstractfactory;

public interface GUIFactory {
    IButton createButton();

    ICheckbox createCheckbox();
}
