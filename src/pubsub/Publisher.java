package pubsub;

import module java.base;

public class Publisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(Event event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.onEvent(event);
        }
    }
}
