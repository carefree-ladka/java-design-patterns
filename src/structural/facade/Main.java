package structural.facade;

public class Main {

    void main() {
        Amplifier amplifier = new Amplifier();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();

        HomeTheater homeTheater = new HomeTheater(amplifier, dvdPlayer, projector);
        homeTheater.watchMovie("The Emily Dickinson");
        homeTheater.endMovie();
    }
}
