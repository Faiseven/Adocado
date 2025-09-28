package ado_app.Backend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//  It implies that it is an ActionListener class, such as new ActionListener(), or an anonymous class.
public class EventButtons implements ActionListener {

    private int index = 0;
    private boolean playing = false;

    public EventButtons(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton btn) {
            String text = btn.getText();

            switch (text) {
                case "Play" -> {
                    btn.setText("Stop");
                    btn.setBackground(new Color(123, 31, 162));
                    playIt();
                }
                case "Stop" -> {
                    btn.setText("Play");
                    btn.setBackground(new Color(70, 130, 180));
                    stopIt();
                }
                case "<" -> {
                    index --;
                    // If it goes down to -1, it returns to the last song.
                    if (index < 0) {
                        index = Songs.size() - 1; // Array could return 10, but there would be 11 values (0-9).
                    }
                    nextSong();

                }
                case ">" -> {
                    index++;
                    // If the index is greater than or equal to (3), return to the first song in the JSON.
                    if (index >= Songs.size()) {
                        // If you pass the last index, return to the first song.
                        index = 0;
                    }
                    nextSong();
                }
            }
        }
    }

    private void playIt() {
        playing = true;
        Tracks.playSong();
    }

    private void stopIt() {
        playing = false;
        Tracks.stopSong();
    }

    private void nextSong() {
        // Send the index, and in the function return the path of the song in the specified JSON index.
        Tracks.loadSong(Songs.getSong(index)); // Abstraction, we don't care what's behind it, just knowing what it does.
        Tracks.resetSong();
        if (playing) {
            Tracks.playSong();
        }
    }
}
