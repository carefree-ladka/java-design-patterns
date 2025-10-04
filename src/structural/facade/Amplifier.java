package structural.facade;

public class Amplifier {

    public void on() {
        IO.println("Amplifier is on");
    }

    public void off() {
        IO.println("Amplifier is off");
    }

    public void setVolume(int level) {
        IO.println("Setting volume to " + level);
    }
}
