package behavioral.templatemethod;

public class Coffee extends Beverage {

    @Override
    protected void brew() {
        IO.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        IO.println("Adding sugar & lemon");
    }
}
