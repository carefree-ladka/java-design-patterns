package structural.bridge;

public class SamsungTV implements TV {

    @Override
    public void off() {
        IO.println("SamsungTV is off");
    }

    @Override
    public void tuneChannel(int channel) {
        IO.println("SamsungTV tuned channel: " + channel);
    }

    @Override
    public void on() {
        IO.println("SamsungTV is on");
    }
}
