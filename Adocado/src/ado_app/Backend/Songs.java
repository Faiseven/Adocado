package ado_app.Backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Songs {

    // ArrayList that'll save the paths (URL/String).
    private static List<String> playList;

    // it is executed only once when loading the class, to load the songs from the JSON.
    static {
        loadSongsFromJSON();
    }

    private Songs(){
        // Prevents an instance variable from being created from this class (new Songs).
    }

    private static void loadSongsFromJSON() {
        ObjectMapper mapper = new ObjectMapper();


        try (InputStream is = Songs.class.getClassLoader().getResourceAsStream("config/Songs.json")) {
            if (is == null) {
                JOptionPane.showMessageDialog(null, "We didn't found the JSON file.", "System", JOptionPane.ERROR_MESSAGE);
            }
            // Reads the index by index from de JSON, it returns list with all the path of the songs, which is stored in the playList.
            playList = mapper.readValue(is, new TypeReference<>() {
            });
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading JSON file", "System", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Returns list of Strings.
    public static List<String> getPlayList() {
        return playList;
    }

    // Returns list size
    public static int size() {
        return playList.size();
    }

    // Based on the index will be the song (URL/String/Path) of the song indicated in the JSON.
    public static String getSong(int index) {
        return playList.get(index);
    }
}
