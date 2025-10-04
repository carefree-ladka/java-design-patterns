package structural.composite;

public class Designer implements Employee {
    private final String name;
    private final String role;

    public Designer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showDetails() {
        IO.print("Designer " + this.name + " " + this.role);
    }
}
