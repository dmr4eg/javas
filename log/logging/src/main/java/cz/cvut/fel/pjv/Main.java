package cz.cvut.fel.pjv;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        LOGGER.setLevel(Level.FINE);
        FileHandler fh = new FileHandler("log.txt");
        fh.setLevel(Level.FINE);
        fh.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fh);

        LOGGER.severe("Error...");
        LOGGER.warning("Warn...");
        LOGGER.info("Info...");
        LOGGER.fine("Fine...");





        System.out.println("Hello world!");
    }
}