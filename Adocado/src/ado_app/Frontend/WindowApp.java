package ado_app.Frontend;

import ado_app.Backend.Tracks;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.net.URL;

public class WindowApp extends JFrame{

    // Opens the window.
    public WindowApp(){
        setIcon();
        openWindow();
    }

    // Sets up the window.

    private void setIcon() {
        try {
            // Gets the image
            URL urlIcon = getClass().getClassLoader().getResource("images/Ado-icono.png");

            if (urlIcon != null) {
                Image icon = Toolkit.getDefaultToolkit().getImage(urlIcon);
                setIconImage(icon);
            }
        } catch (Exception ignored) { }
    }

    private void openWindow(){
        setTitle("Music App (Ado)");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        // Adds a listener to the Window for when the X is clicked.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opc = JOptionPane.showConfirmDialog(this, "Do you wanna close the application?", "System", JOptionPane.YES_NO_OPTION);
                if(opc == JOptionPane.YES_OPTION){
                    // Stops the music and closes the application.
                    Tracks.stopSong();
                    System.exit(0);
                }
            }
        });

        // Adds the panel to the window.
        setContentPane(new PanelPrincipal());
        setVisible(true);
    }
}

