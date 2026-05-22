package Root.Core;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;

public final class MyUtils {
    private MyUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static Random random = new Random();

    public static int getRandomNumber(int min, int max) {
        return random.nextInt(min, max + 1);
    }

    public static void printAllUIManagerComponents() {
        // Convert the raw keys to Strings, filter out any nulls, sort them, and print
        UIManager.getDefaults().keySet().stream()
                .map(Object::toString)
                .sorted()
                .forEach(System.out::println);
    }

    public static void printAllFonts() {
        // Gets all Fonts
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : fonts) {
            System.out.println(font);
        }
    }
}