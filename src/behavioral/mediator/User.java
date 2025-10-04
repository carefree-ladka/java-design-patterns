package behavioral.mediator;

public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    abstract void sendMessage(String message);

    abstract void receiveMessage(String message);
}
