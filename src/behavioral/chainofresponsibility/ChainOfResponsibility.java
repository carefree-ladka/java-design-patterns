package behavioral.chainofresponsibility;

public class ChainOfResponsibility {

    void main() {
        Handler auth = new AuthHandler();
        Handler log = new LoggingHandler();
        Handler data = new DataHandler();

        auth.setNext(log);
        log.setNext(data);

        // Send requests
        auth.handleRequest("AUTH");
        auth.handleRequest("LOG");
        auth.handleRequest("DATA");
        auth.handleRequest("UNKNOWN");
    }
}
