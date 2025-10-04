package structural.bridge;

public class SonyTV implements TV {
    @Override
    public void off() {
        IO.println("SonyTV is off");
    }

    @Override
    public void on() {
        IO.println("SonyTV is on");
    }

    @Override
    public void tuneChannel(int channel) {
        IO.println("SonyTV tuned channel: " + channel);
    }
}
