package pubsub;

public class EmailSubscriber implements Subscriber {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(Event event) {
        System.out.println(name + " received event: " + event.message);
    }
}
