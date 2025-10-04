package structural.composite;

public class Composite {
    void main() {
        Employee e1 = new Developer("Alice", "Frontend Developer");
        Employee e2 = new Developer("Bob", "Backend Developer");
        Employee d1 = new Designer("John", "UI/UX Developer");

        Manager engManager = new Manager("David", "Engineering");
        engManager.addEmployee(e1);
        engManager.addEmployee(e2);


        Manager designManager = new Manager("Eva", "Design");
        designManager.addEmployee(d1);

        Manager generalManager = new Manager("Frank", "General Management");
        generalManager.addEmployee(engManager);
        generalManager.addEmployee(designManager);

        generalManager.showDetails();
    }
}
