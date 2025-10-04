package behavioral.nullobject;

public class Main {
    void main() {
        AbstractCustomer c1 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer c2 = CustomerFactory.getCustomer("John");
        AbstractCustomer c3 = CustomerFactory.getCustomer("David");
        AbstractCustomer c4 = CustomerFactory.getCustomer("Michael");
        AbstractCustomer c5 = CustomerFactory.getCustomer("Sara");

        IO.println(c1.getName()); // Bob
        IO.println(c2.getName()); // Not available
        IO.println(c3.getName()); // Not available
        IO.println(c4.getName()); // Not available
        IO.println(c5.getName()); // Not available
    }
}
