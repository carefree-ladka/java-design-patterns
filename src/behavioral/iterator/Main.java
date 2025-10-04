package behavioral.iterator;

public class Main {

    void main() {
        NameRepository repository = new NameRepository();

        Iterator<String> iterator = repository.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            IO.println("Name : " + name);
        }
    }
}
