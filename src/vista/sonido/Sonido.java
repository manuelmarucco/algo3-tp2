package vista.sonido;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Sonido {
    private Clip clip;
    private boolean playing;

    public Sonido(String fileName) {
        playing = false;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                this.clip = AudioSystem.getClip();
                AudioInputStream ais = AudioSystem.getAudioInputStream(file.toURI().toURL());
                this.clip.open(ais);
            }
            else {
                throw new RuntimeException("Sonido: file not found: " + fileName);
            }
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Sonido: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            throw new RuntimeException("Sonido: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            throw new RuntimeException("Sonido: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            throw new RuntimeException("Sonido: Line Unavailable: " + e);
        }
    }
    public void playSingleTime(){
        clip.setFramePosition(0);
        clip.loop(0);
        clip.start();
        playing = true;
    }
    public void playLoop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        playing = true;
    }

    public void stop(){
        clip.stop();
        playing = false;
    }

    public boolean isPlaying(){
        return playing;
    }
}