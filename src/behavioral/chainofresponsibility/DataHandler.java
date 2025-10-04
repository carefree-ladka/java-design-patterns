package behavioral.chainofresponsibility;

public class DataHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("DATA")) {
            IO.println("DataHandler: Handling DATA request");
        } else if (next != null) {
            next.handleRequest(request);
        } else {
            IO.println("No handler found for request: " + request);
        }
    }
}
