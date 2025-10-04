package creational.factory;

public class Circle implements IShape {

    @Override
    public void draw() {
        IO.println("Drawing Circle");
    }
}
