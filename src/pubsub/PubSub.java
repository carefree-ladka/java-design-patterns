package pubsub;

public class PubSub {
    void main() {
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new EmailSubscriber("Alice");
        Subscriber subscriber2 = new EmailSubscriber("Bob");

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        publisher.publish(new Event("New Article Published!"));

        publisher.unsubscribe(subscriber1);
        publisher.publish(new Event("Another Article Published!"));

        /*
        Alice received event: New Article Published!
        Bob received event: New Article Published!
        Bob received event: Another Article Published!
         */
    }
}
