package ado_app.Frontend;

import javax.swing.*;

public class AppLauncher {

    static {
        try {
            // Makes the app look modern and prettier.
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ignored) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WindowApp::new);
    }
}
