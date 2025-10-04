package behavioral.command;

public class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        IO.println("Light is on");
    }

    public void turnOff() {
        isOn = false;
        IO.println("Light is off");
    }

    public boolean isOn() {
        return isOn;
    }
}
