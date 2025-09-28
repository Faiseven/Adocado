package ado_app.Backend;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImagenResized {

    private ImagenResized(){}

    public static ImageIcon resizeImage(String path){
        // It gets the URL from the JAR classpath, so it won't have to create folders that must always be next the JAR.
        URL imageURL = ImagenResized.class.getClassLoader().getResource(path);

        if(imageURL == null){
            JOptionPane.showMessageDialog(null, "Image not found", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        ImageIcon original = new ImageIcon(imageURL);
        Image img = original.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        // Returns the rescaled image.
        return new ImageIcon(img);
    }
}
