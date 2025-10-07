package ado_app.Frontend;

import ado_app.Backend.Tracks;
import ado_app.Backend.Songs;
import ado_app.Backend.EventButtons;
import ado_app.Backend.ImagenResized;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel {

    // If each button starts its own instance, the music wouldn't be coordinated.
    // Right here we use instance, since we create an ActionListener instance.
    private final ActionListener Evbu = new EventButtons();

    // Initializes the font that will be used in the buttons.
    private final Font font = new Font("Arial", Font.BOLD, 12);

    public PanelPrincipal() {
        if (!Songs.getPlayList().isEmpty()) {
            Tracks.loadSong(Songs.getSong(0));
        }

        // Set up the JPanel components.
        getPanel();
        getButtons();
        getTitle();
        getImage();
    }

    private void getPanel() {
        setLayout(null);
        setBackground(new Color(25, 25, 25));
    }

    private void getButtons() {
        JButton btActivate = new JButton("Play");
        btActivate.setFont(font);
        btActivate.setBackground(new Color(70, 130, 180));
        btActivate.setForeground(Color.WHITE);
        btActivate.setBounds(100, 310, 100, 40);
        btActivate.addActionListener(Evbu);
        add(btActivate);

        JButton btLeft = new JButton("<");
        btLeft.setFont(font);
        btLeft.setBackground(new Color(75, 0, 130));
        btLeft.setForeground(Color.WHITE);
        btLeft.setBounds(55, 310, 40, 40);
        btLeft.addActionListener(Evbu);
        add(btLeft);

        JButton btRight = new JButton(">");
        btRight.setFont(font);
        btRight.setBackground(new Color(75, 0, 130));
        btRight.setForeground(Color.WHITE);
        btRight.setBounds(205, 310, 40, 40);

        // It's polymorphism because a variable (general type) can store different objects
        // that have their own implementation (@Override) of the same method.
        // For example, the @Override of EventButton() and the @Override of an anonymous class
        // same variable, but point to different @Overrides.
        btRight.addActionListener(Evbu);
        add(btRight);
    }

    // Set up the title label.
    private void getTitle(){
        JLabel Title = new JLabel("ADOCADO");
        Title.setFont(new Font("Arial", Font.BOLD, 24));
        Title.setForeground(new Color(138, 43, 226));
        Title.setBounds(80, 5, 150, 30);
        add(Title);
    }

    // Set up the image label.
    private void getImage(){
        JLabel Image = new JLabel();
        Image.setBounds(30, 20, 320, 300);
        Image.setIcon(ImagenResized.resizeImage("images/AdoCado.png")); // Send the image path, and we set the returned image.
        add(Image);
    }
}

