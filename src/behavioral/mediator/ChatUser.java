package behavioral.mediator;

public class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {
        super(name, mediator);
    }

    @Override
    public void sendMessage(String message) {
        IO.println(this.name + " sending : " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        IO.println(this.name + " received :" + message);
    }
}
