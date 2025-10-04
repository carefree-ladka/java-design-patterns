package structural.decorator;

public class Main {
    void main() {
        Coffee coffee = new SimpleCoffee();
        IO.println(coffee.getDescription() + " $" + coffee.getCost()); // Simple Coffee $5.0

        Coffee milkCoffee = new MilkDecorator(coffee);
        IO.println(milkCoffee.getDescription() + " $" + milkCoffee.getCost()); // Simple Coffee, Milk $7.0

        Coffee sugarCoffee = new SugarDecorator(milkCoffee);
        IO.println(sugarCoffee.getDescription() + " $" + sugarCoffee.getCost()); // Simple Coffee, Milk, sugar $8.0
    }
}
