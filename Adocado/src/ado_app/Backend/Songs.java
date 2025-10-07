package ado_app.Backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Songs {

    // ArrayList that'll save the paths' songs from the JSON (URL/String).
    private static List<String> playList;

    // Class that starts first to load the songs from the JSON.
    static {
        loadSongsFromJSON();
    }

    private Songs(){
        // Prevents an instance variable from being created from this class (new Songs).
    }

    private static void loadSongsFromJSON() {
        ObjectMapper mapper = new ObjectMapper();

        // Gets the JSON file from resources folder (classpath).
        try (InputStream is = Songs.class.getClassLoader().getResourceAsStream("config/Songs.json")) {
            if (is == null) {
                JOptionPane.showMessageDialog(null, "We didn't found the JSON file.", "System", JOptionPane.ERROR_MESSAGE);
            }

            // Reads the JSON file and turns it into a List of Strings.
            playList = mapper.readValue(is, new TypeReference<>() {});
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading JSON file", "System", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Returns List of Strings.
    public static List<String> getPlayList() {
        return playList;
    }

    // Returns List size
    public static int size() {
        return playList.size();
    }

    // Based on the index will return the song (String) of the song indicated by index in the JSON.
    public static String getSong(int index) {
        return playList.get(index);
    }
}
