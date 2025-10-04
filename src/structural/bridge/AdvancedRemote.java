package structural.bridge;


public class AdvancedRemote extends RemoteControl {

    public AdvancedRemote(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        tv.on();
    }

    @Override
    public void turnOff() {
        tv.off();
    }

    @Override
    public void setChannel(int channel) {
        tv.tuneChannel(channel);
    }

    public void mute() {
        IO.println("TV is muted");
    }
}
