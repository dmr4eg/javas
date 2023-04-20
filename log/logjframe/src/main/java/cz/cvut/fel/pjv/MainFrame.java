package cz.cvut.fel.pjv;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        Logger LOGGER = Logger.getLogger("");
        LOGGER.setLevel(Level.FINE);
        LOGGER.getHandlers()[0].setLevel(Level.FINEST);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}