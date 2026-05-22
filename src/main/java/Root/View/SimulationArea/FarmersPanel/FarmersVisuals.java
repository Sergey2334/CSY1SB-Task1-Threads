package Root.View.SimulationArea.FarmersPanel;

import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class FarmersVisuals extends JPanel {
    private int farmersAmount = 0;

    public FarmersVisuals() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Farmers Visuals", true));
    }

    public void setFarmersAmount(int farmersAmount) {
        this.farmersAmount = farmersAmount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Setup layout constraints
        int farmerSize = 15;        // Diameter/Size of each driver
        int spacing = 10;           // Space between drivers
        int leftMargin = 15;       // Push away from the left border
        int topMargin = 30;        // Push down past the title border text
        int rightMargin = 15;      // Stop before hitting the right border

        // 2. Calculate dynamic row capacity based on current panel width
        int availableWidth = this.getWidth() - leftMargin - rightMargin;
        int stepSize = farmerSize + spacing;
        int maxPerRow = availableWidth / stepSize;

        // Prevent division by zero if the panel is minimized very small
        if (maxPerRow <= 0) {
            maxPerRow = 1;
        }

        // 3. Draw rows dynamically based on calculated maxPerRow
        for (int i = 0; i < this.farmersAmount; i++) {
            int column = i % maxPerRow;
            int row = i / maxPerRow;

            int x = leftMargin + (column * stepSize);
            int y = topMargin + (row * stepSize);

            // Calculate the absolute center point for rotation
            int centerX = x + (farmerSize / 2);
            int centerY = y + (farmerSize / 2);
            int halfSize = farmerSize / 2;

            // --- DRAW THE HALO (Background) ---
            Color haloColor = new Color(0, 0, 0, 69);
            g2d.setColor(haloColor);
            int haloSize = farmerSize + 4;
            g2d.fillOval(x - 2, y - 2, haloSize, haloSize);

            // --- DRAW THE ROTATED SQUARE ---
            // Save canvas position
            AffineTransform oldTransform = g2d.getTransform();

            // Move origin to the center of the shape and rotate 45 degrees
            g2d.translate(centerX, centerY);
            g2d.rotate(Math.toRadians(45));

            // Fill the inside with Orange
            g2d.setColor(new Color(31, 241, 66, 255));
            g2d.fillRect(-halfSize, -halfSize, farmerSize, farmerSize);

            // Draw the light outer frame border
            g2d.setColor(new Color(180, 232, 188, 255));
            g2d.drawRect(-halfSize, -halfSize, farmerSize, farmerSize);

            // Restore canvas position for the next iteration
            g2d.setTransform(oldTransform);
        }
    }
}
