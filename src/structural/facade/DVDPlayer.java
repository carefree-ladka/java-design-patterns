package structural.facade;

public class DVDPlayer {

    public void on() {
        IO.println("DVD Player is on");
    }

    public void off() {
        IO.println("DVD Player is off");
    }

    public void play(String movie) {
        IO.println("DVD Player is playing " + movie);
    }
}
