package creational.prototype;

public class Prototype {

    void main() {
        Circle circle1 = new Circle(10);
        circle1.draw(); // Circle [radius=10]

        Circle circle2 = (Circle) circle1.clone();
        circle2.setRadius(20);
        circle2.draw(); // Circle [radius=20]

        // Original circle remains unchanged
        circle1.draw(); // Circle [radius=10]
    }
}
