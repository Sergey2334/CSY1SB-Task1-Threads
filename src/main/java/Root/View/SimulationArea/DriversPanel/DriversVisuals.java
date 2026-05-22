package Root.View.SimulationArea.DriversPanel;

import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;
import java.awt.*;

public class DriversVisuals extends JPanel {
    private int driversAmount = 0;

    public DriversVisuals() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Drivers Visuals", true));
    }

    public void setDriversAmount(int driversAmount) {
        this.driversAmount = driversAmount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Setup layout constraints
        int driverSize = 15;        // Diameter/Size of each driver
        int spacing = 10;           // Space between drivers
        int leftMargin = 15;       // Push away from the left border
        int topMargin = 30;        // Push down past the title border text
        int rightMargin = 15;      // Stop before hitting the right border

        // 2. Calculate dynamic row capacity based on current panel width
        int availableWidth = this.getWidth() - leftMargin - rightMargin;
        int stepSize = driverSize + spacing;
        int maxPerRow = availableWidth / stepSize;

        // Prevent division by zero if the panel is minimized very small
        if (maxPerRow <= 0) {
            maxPerRow = 1;
        }

        // 3. Draw rows dynamically based on calculated maxPerRow
        for (int i = 0; i < this.driversAmount; i++) {
            int column = i % maxPerRow;
            int row = i / maxPerRow;

            int x = leftMargin + (column * stepSize);
            int y = topMargin + (row * stepSize);

            // Calculate the absolute center point for rotation
            int centerX = x + (driverSize / 2);
            int centerY = y + (driverSize / 2);
            int halfSize = driverSize / 2;

            // --- DRAW THE HALO (Background) ---
            Color haloColor = new Color(0, 0, 0, 69);
            g2d.setColor(haloColor);
            int haloSize = driverSize + 4;
            g2d.fillOval(x - 2, y - 2, haloSize, haloSize);

            // --- DRAW THE ROTATED SQUARE ---
            // Save canvas position
            java.awt.geom.AffineTransform oldTransform = g2d.getTransform();

            // Move origin to the center of the shape and rotate 45 degrees
            g2d.translate(centerX, centerY);
            g2d.rotate(Math.toRadians(45));

            // Fill the inside with Orange
            g2d.setColor(new Color(31, 130, 241, 255));
            g2d.fillRect(-halfSize, -halfSize, driverSize, driverSize);

            // Draw the light outer frame border
            g2d.setColor(new Color(143, 185, 237, 255));
            g2d.drawRect(-halfSize, -halfSize, driverSize, driverSize);

            // Restore canvas position for the next iteration
            g2d.setTransform(oldTransform);
        }
    }
}
