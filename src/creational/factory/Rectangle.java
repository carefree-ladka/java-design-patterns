package creational.factory;

public class Rectangle implements IShape {

    @Override
    public void draw() {
        IO.println("Drawing Rectangle");
    }
}
