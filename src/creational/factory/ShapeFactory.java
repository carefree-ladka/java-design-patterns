package creational.factory;

public class ShapeFactory {

    public IShape createShape(ShapeType shapeType) {
        return switch (shapeType) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
            default -> throw new IllegalArgumentException("Invalid shapeType");
        };
    }
}
