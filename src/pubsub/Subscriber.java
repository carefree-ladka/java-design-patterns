package pubsub;

public interface Subscriber {
    void onEvent(Event event);
}
