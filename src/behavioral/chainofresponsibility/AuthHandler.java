package behavioral.chainofresponsibility;

public class AuthHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("AUTH")) {
            IO.println("Auth Handler");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
