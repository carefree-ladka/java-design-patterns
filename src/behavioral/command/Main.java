package behavioral.command;

public class Main {
    void main() {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        // Turn light on
        remote.executeCommand(lightOn);   // The light is ON

        // Turn light off
        remote.executeCommand(lightOff);  // The light is OFF

        // Undo last action (turns light ON again)
        remote.undo();                    // The light is ON

        // Redo last undone action (turns light OFF again)
        remote.redo();                    // The light is OFF
    }
}
