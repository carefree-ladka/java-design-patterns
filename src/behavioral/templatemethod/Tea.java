package behavioral.templatemethod;

public class Tea extends Beverage {

    @Override
    protected void brew() {
        IO.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        IO.println("Adding lemon");
    }
}
