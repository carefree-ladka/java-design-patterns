package behavioral.nullobject;

public class CustomerFactory {
    private static final String[] names = {"Alice", "Bob", "Charlie"};

    public static AbstractCustomer getCustomer(String name) {
        for (String s : names) {
            if (s.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
