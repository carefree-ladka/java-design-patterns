package structural.proxy;

public class Main {
    void main() {
        Image img1 = new ProxyImage("photo1.png");
        Image img2 = new ProxyImage("photo2.png");

        // Image is loaded only when display() is called
        img1.display();  // Loads + Displays
        img1.display(); // Already loaded, just displays
        img2.display(); // Loads + Displays
    }
}
