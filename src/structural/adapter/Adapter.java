package structural.adapter;

public class Adapter {
    void main() {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("MP3", "song.mp3"); // Playing MP3: song.mp3
        audioPlayer.play("MP4", "movie.mp4"); // Playing MP4 movie.mp4
        audioPlayer.play("VLC", "video.vlc"); // Playing VLC video.vlc
        audioPlayer.play("AVI", "oldmovie.avi"); // Invalid audio type: AVI
    }
}
