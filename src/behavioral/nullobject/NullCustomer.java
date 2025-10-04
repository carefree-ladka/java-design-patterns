package behavioral.nullobject;

public class NullCustomer extends AbstractCustomer {

    @Override
    public String getName() {
        return "Not available";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
