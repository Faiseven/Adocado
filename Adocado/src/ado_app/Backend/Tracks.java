package ado_app.Backend;

import javax.sound.sampled.*;
import javax.swing.JOptionPane;
import java.net.URL;

public class Tracks {

    // We use encapsulation so that they do not have access to these variables.
    private static Clip clip;
    private static int pausedMusic = 0;

    private Tracks(){}

    public static void loadSong(String path){
        try {
            if(clip != null && clip.isRunning()){
                clip.stop();
            }

            // Use URLs to get the path from the JAR classpath so you don't have to use folders alongside the JAR all the time.
            URL soundURL = Tracks.class.getClassLoader().getResource(path);

            if (soundURL == null) {
                JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
                if(clip != null){
                    clip.close();
                }
                System.exit(0);
            }

            //? Uses the path of the classpath.
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL);

            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The song couldn't be loaded. Reset the program", "Error", JOptionPane.ERROR_MESSAGE);
            if(clip != null){
                clip.close();
            }
            System.exit(0);
        }
    }


    public static void playSong(){
        if(clip != null){
            clip.setFramePosition(pausedMusic); // Continue from saved position (if not reset).
            clip.start();
        }
    }

    public static void stopSong(){
        if(clip != null && clip.isRunning()){
            pausedMusic = clip.getFramePosition(); // Save the current position (Do not reset).
            clip.stop();
        }
    }

    public static void resetSong(){
        clip.stop();
        pausedMusic = 0;
        clip.setFramePosition(pausedMusic); // Restart the music only when the song changes.
    }
}
