package structural.proxy;

public class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadDFromDisk();
    }

    private void loadDFromDisk() {
        IO.println("Loading " + filename + " from disk");
    }

    @Override
    public void display() {
        IO.println("Displaying " + filename + " from disk");
    }
}
