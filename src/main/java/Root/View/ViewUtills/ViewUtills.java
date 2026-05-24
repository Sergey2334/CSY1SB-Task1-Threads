package Root.View.ViewUtills;

import Root.Core.Constants;
import Root.Model.Worker;
import com.formdev.flatlaf.ui.FlatLineBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.AffineTransform;

public final class ViewUtills {
    private ViewUtills() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Border createCustomTitledBorder(String title, boolean isBorderVisible) {
        int borderThickness = 0;
        if (isBorderVisible) {
            borderThickness = 1;
        }
        FlatLineBorder flatLineBorder = new FlatLineBorder(new Insets(1, 1, 1, 1), Color.GRAY, borderThickness, 16);
        Border result = BorderFactory.createTitledBorder(flatLineBorder,
                title,
                2,
                2,
                new Font(Constants.COOL_FONT1_STRING, Font.BOLD, 16),
                Color.WHITE);

        return result;
    }

    public static void drawWorker(Graphics g, JPanel panel, int workersAmount, Color workerColor)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Setup layout constraints
        int workerSize = 15;        // Diameter/Size of each driver
        int spacing = 10;           // Space between drivers
        int leftMargin = 15;       // Push away from the left border
        int topMargin = 30;        // Push down past the title border text
        int rightMargin = 15;      // Stop before hitting the right border

        // 2. Calculate dynamic row capacity based on current panel width
        int availableWidth = panel.getWidth() - leftMargin - rightMargin;
        int stepSize = workerSize + spacing;
        int maxPerRow = availableWidth / stepSize;

        // Prevent division by zero if the panel is minimized very small
        if (maxPerRow <= 0) {
            maxPerRow = 1;
        }

        // 3. Draw rows dynamically based on calculated maxPerRow
        for (int i = 0; i < workersAmount; i++) {
            int column = i % maxPerRow;
            int row = i / maxPerRow;

            int x = leftMargin + (column * stepSize);
            int y = topMargin + (row * stepSize);

            // Calculate the absolute center point for rotation
            int centerX = x + (workerSize / 2);
            int centerY = y + (workerSize / 2);
            int halfSize = workerSize / 2;

            // --- DRAW THE HALO (Background) ---
            g2d.setColor(Constants.HALO_COLOR);
            int haloSize = workerSize + 4;
            g2d.fillOval(x - 2, y - 2, haloSize, haloSize);

            // --- DRAW THE ROTATED SQUARE ---
            AffineTransform oldTransform = g2d.getTransform();

            g2d.translate(centerX, centerY);
            g2d.rotate(Math.toRadians(45));

            g2d.setColor(workerColor);
            g2d.fillRect(-halfSize, -halfSize, workerSize, workerSize);

            g2d.setColor(workerColor.brighter().brighter().brighter().brighter().brighter());
            g2d.drawRect(-halfSize, -halfSize, workerSize, workerSize);

            g2d.setTransform(oldTransform);
        }
    }

    public static void drawOranges(Graphics g, JPanel panel, int orangesAmount, Color orangesColor)
    {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Setup layout constraints
        int orangeSize = 10;        // Diameter of each orange
        int spacing = 4;           // Space between oranges
        int leftMargin = 15;       // Push away from the left border
        int topMargin = 30;        // Push down past the title border text
        int rightMargin = 15;      // Stop before hitting the right border

        // 2. Calculate dynamic row capacity based on current panel width
        int availableWidth = panel.getWidth() - leftMargin - rightMargin;
        int stepSize = orangeSize + spacing;
        int maxPerRow = availableWidth / stepSize;

        // Prevent division by zero if the panel is minimized very small
        if (maxPerRow <= 0) {
            maxPerRow = 1;
        }

        // 3. Draw rows dynamically based on calculated maxPerRow
        for (int i = 0; i < orangesAmount; i++) {
            int column = i % maxPerRow;
            int row = i / maxPerRow;

            int x = leftMargin + (column * stepSize);
            int y = topMargin + (row * stepSize);

            g2d.setColor(Constants.HALO_COLOR);

            int haloSize = orangeSize + 4; // Makes the halo 4 pixels bigger than the orange
            g2d.fillOval(x - 2, y - 2, haloSize, haloSize);

            g2d.setColor(orangesColor.brighter().brighter().brighter().brighter().brighter());
            g2d.drawOval(x, y, orangeSize, orangeSize);

            g2d.setColor(orangesColor);
            g2d.fillOval(x, y, orangeSize, orangeSize);
        }
    }
}
