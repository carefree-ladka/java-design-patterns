package creational.factory;

public class Factory {

    void main() {
        ShapeFactory shapeFactory = new ShapeFactory();

        IShape shape1 = shapeFactory.createShape(ShapeType.CIRCLE);
        shape1.draw(); // Drawing Circle

        IShape shape2 = shapeFactory.createShape(ShapeType.SQUARE);
        shape2.draw(); // Drawing Square

        IShape shape3 = shapeFactory.createShape(ShapeType.RECTANGLE);
        shape3.draw(); // Drawing Rectangle
    }
}
