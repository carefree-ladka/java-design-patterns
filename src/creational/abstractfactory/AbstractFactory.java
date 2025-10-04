package creational.abstractfactory;

public class AbstractFactory {

    private static GUIFactory getGUIFactory(String osType) {
        if (osType.equalsIgnoreCase("Mac")) {
            return new MacFactory();
        } else if (osType.equalsIgnoreCase("Windows")) {
            return new WindowsFactory();
        }
        throw new IllegalArgumentException("Unsupported OS Type");
    }

    void main() {
        GUIFactory guiFactory = getGUIFactory("Mac");
        IButton button = guiFactory.createButton();
        ICheckbox checkbox = guiFactory.createCheckbox();
        button.paint();
        checkbox.paint();

        guiFactory = getGUIFactory("windows");
        IButton button2 = guiFactory.createButton();
        ICheckbox checkbox2 = guiFactory.createCheckbox();
        button2.paint();
        checkbox2.paint();
    }
}
