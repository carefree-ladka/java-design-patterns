package structural.decorator;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", sugar";
    }

    public double getCost() {
        return coffee.getCost() + 1.0;
    }
}
