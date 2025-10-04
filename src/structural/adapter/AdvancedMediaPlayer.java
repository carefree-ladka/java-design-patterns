package structural.adapter;

public class AdvancedMediaPlayer {
    public void playVLC(String fileName) {
        IO.println("Playing VLC " + fileName);
    }

    public void playMP4(String fileName) {
        IO.println("Playing MP4 " + fileName);
    }
}
