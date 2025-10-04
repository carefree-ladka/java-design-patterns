package structural.composite;

import module java.base;

public class Manager implements Employee {
    private final String name;
    private final String department;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void addEmployee(Employee emp) {
        this.subordinates.add(emp);
    }

    public void removeEmployee(Employee emp) {
        this.subordinates.remove(emp);
    }

    @Override
    public void showDetails() {
        IO.println("Manager " + this.name + " Department " + this.department);
        for (Employee emp : subordinates) {
            emp.showDetails();
        }
    }
}
