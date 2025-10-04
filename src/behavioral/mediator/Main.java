package behavioral.mediator;

public class Main {
    void main() {
        ChatMediator chatMediator = new ChatMediatorImpl();

        User u1 = new ChatUser(chatMediator, "Alice");
        User u2 = new ChatUser(chatMediator, "Bob");
        User u3 = new ChatUser(chatMediator, "Charlie");

        chatMediator.addUser(u1);
        chatMediator.addUser(u2);
        chatMediator.addUser(u3);

        u1.sendMessage("Hello Alice");
        u2.sendMessage("Hello Bob");
    }
}
