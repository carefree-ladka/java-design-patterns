package behavioral.observer;

public class Main {
    void main() {
        NewsAgency newsAgency = new NewsAgency();
        Observer cnn = new NewsChannel("CNN");
        Observer bbc = new NewsChannel("BCC");
        Observer ndtv = new NewsChannel("NDTV");

        newsAgency.addObserver(cnn);
        newsAgency.addObserver(bbc);
        newsAgency.addObserver(ndtv);

        newsAgency.setLatestNews("Breaking: Design Patterns are awesome!");
        newsAgency.setLatestNews("Update: The walking dead is awesome");
    }
}
