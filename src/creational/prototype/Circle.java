package creational.prototype;

public class Circle implements IPrototype {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        IO.println("Circle [radius=" + radius + "]");
    }

    @Override
    public IPrototype clone() {
        try {
            return (IPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
