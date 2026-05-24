package Root.View.SimulationArea.WarehousePanel;

import Root.Core.Constants;
import Root.View.ViewUtills.ViewUtills;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class WarehouseStats extends JPanel {
    private JLabel orangesStoredPerSecond;
    private JLabel orangesCollectedPerSecond;
    private JLabel totalOrangesStored;
    private JLabel totalOrangesCollected;
    private JLabel warehouseCapacity;

    public WarehouseStats() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 1, fill"));
        this.setBorder(ViewUtills.createCustomTitledBorder("Stats", true));
    }

    private void initializeComponents() {
        this.orangesStoredPerSecond = new JLabel("Oranges Stored / S : ");
        this.orangesCollectedPerSecond = new JLabel("Oranges Collected / S : ");
        this.totalOrangesStored = new JLabel("Total Oranges Stored : ");
        this.totalOrangesCollected = new JLabel("Total Oranges Collected : ");
        this.warehouseCapacity = new JLabel("Warehouse Capacity : ");

        Font textFont = Constants.COOL_FONT1;
        this.orangesStoredPerSecond.setFont(textFont);
        this.orangesCollectedPerSecond.setFont(textFont);
        this.totalOrangesStored.setFont(textFont);
        this.totalOrangesCollected.setFont(textFont);
        this.warehouseCapacity.setFont(textFont);

        this.add(this.orangesStoredPerSecond, "grow x, push x");
        this.add(this.orangesCollectedPerSecond, "grow x, push x");
        this.add(this.totalOrangesStored, "grow x, push x");
        this.add(this.totalOrangesCollected, "grow x, push x");
        this.add(this.warehouseCapacity, "grow x, push x");
    }

    public void setStats(double orangesStoredPerSec, double orangesCollectedPerSec, int totalStored, int totalCollected, int currentCapacity, int totalCapacity) {
        String stored = String.format("%.2f", orangesStoredPerSec);
        String collected = String.format("%.2f", orangesCollectedPerSec);

        this.orangesStoredPerSecond.setText("Oranges Stored / S : " + stored);
        this.orangesCollectedPerSecond.setText("Oranges Collected / S : " + collected);
        this.totalOrangesStored.setText("Total Oranges Stored : " + totalStored);
        this.totalOrangesCollected.setText("Total Oranges Collected : " + totalCollected);
        this.warehouseCapacity.setText("Warehouse Capacity : " + currentCapacity + " / " +  totalCapacity);
    }
}
