package structural.bridge;

public class Bridge {

    void main() {
        TV sonyTV = new SonyTV();
        TV samsungTV = new SamsungTV();

        RemoteControl sonyRemote = new AdvancedRemote(sonyTV);
        sonyRemote.turnOff();
        sonyRemote.setChannel(5);
        sonyRemote.turnOff();

        IO.println(" ----------------- ");

        RemoteControl samsungRemote = new AdvancedRemote(samsungTV);
        samsungRemote.turnOff();
        samsungRemote.setChannel(5);
        samsungRemote.turnOff();
    }
}
