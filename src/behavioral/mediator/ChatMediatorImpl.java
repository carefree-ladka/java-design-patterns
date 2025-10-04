package behavioral.mediator;

import module java.base;

public class ChatMediatorImpl implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) { // don’t send message to sender
                u.receiveMessage(message);
            }
        }
    }
}
