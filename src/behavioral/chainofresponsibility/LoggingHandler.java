package behavioral.chainofresponsibility;

public class LoggingHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("LOG")) {
            IO.println("LoggingHandler: Handling LOG request");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
