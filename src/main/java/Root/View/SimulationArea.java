package Root.View;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import Root.Core.Constants;
import Root.Model.Warehouse;
import Root.Model.Farmer;
import Root.Model.Driver;

public class SimulationArea extends JPanel {
    private Warehouse currentWarehouse;
    private LinkedList<Farmer> currentFarmers = new LinkedList<>();
    private LinkedList<Driver> currentDrivers = new LinkedList<>();

    public SimulationArea() {
        this.setBackground(new Color(33, 37, 41)); // Dark elegant theme
    }

    /**
     * The master refresh engine called by our Swing Timer clock.
     */
    public void updateEngineSnapshot(Warehouse wh, LinkedList<Farmer> farmers, LinkedList<Driver> drivers) {
        this.currentWarehouse = wh;
        this.currentFarmers = farmers;
        this.currentDrivers = drivers;

        // This triggers a complete canvas repaint on the Event Dispatch Thread (EDT)
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Enable Antialiasing for perfectly smooth shapes
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw Headers
        g2.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2.setColor(Color.WHITE);
        g2.drawString("FARMERS ZONE", 80, 40);
        g2.drawString("WAREHOUSE HUB", 480, 40);
        g2.drawString("DRIVERS ZONE", 880, 40);

        // --- 1. DRAW WAREHOUSE (Center Column) ---
        if (this.currentWarehouse != null) {
            int maxCap = Constants.WAREHOUSE_START_MAX_CAPACITY; // Constants.WAREHOUSE_START_MAX_CAPACITY
            // Using a simple trick: split the string to read numbers if getters aren't ready,
            // or modify Warehouse to have a simple getCurrentCapacity() getter!
            // Assuming a safe fallback calculation or a temporary placeholder for capacity:
            int currentCap = this.currentWarehouse.getCurrentCapacity();

            // Draw Warehouse Border Box
            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(4));
            g2.drawRect(450, 80, 200, 400);

            // Calculate filling level height
            double fillPercentage = (double) currentCap / maxCap;
            int fillHeight = (int) (400 * fillPercentage);
            int fillY = 80 + (400 - fillHeight);

            // Fill Warehouse Box dynamically based on count status
            g2.setColor(new Color(40, 167, 69, 180)); // Soft Alpha Green
            g2.fillRect(452, fillY, 196, fillHeight);

            // Print Label metrics inside box
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("SansSerif", Font.BOLD, 24));
            g2.drawString(currentCap + " / " + maxCap, 510, 280);
        }

        // --- 2. DRAW FARMERS (Left Column) ---
        int yOffset = 80;
        g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
        for (Farmer farmer : this.currentFarmers) {
            // Determine active tracking states to shift paint colors dynamically
            boolean isStuckWaiting = farmer.getIdleTimeMs() > 100;
            g2.setColor(isStuckWaiting ? new Color(220, 53, 69) : new Color(255, 193, 7)); // Red if idle, Orange if working

            // Draw Farmer node box circle
            g2.fillOval(50, yOffset, 30, 30);

            // Write telemetry texts beside the visual indicator
            g2.setColor(Color.WHITE);
            g2.drawString("Farmer #" + farmer.getId() + " [Work: " + farmer.getWorkTimeSec() + "s]", 95, yOffset + 20);
            yOffset += 45;
        }

        // --- 3. DRAW DRIVERS (Right Column) ---
        yOffset = 80;
        for (Driver driver : this.currentDrivers) {
            boolean isStuckWaiting = driver.getIdleTimeMs() > 100;
            g2.setColor(isStuckWaiting ? new Color(220, 53, 69) : new Color(0, 123, 255)); // Red if idle, Blue if working

            // Draw Driver vehicle nodes
            g2.fillRect(850, yOffset, 40, 25);

            // Write metrics details beside node indicators
            g2.setColor(Color.WHITE);
            g2.drawString("Driver #" + driver.getId() + " [Work: " + driver.getWorkTimeSec() + "s]", 905, yOffset + 18);
            yOffset += 45;
        }
    }
}