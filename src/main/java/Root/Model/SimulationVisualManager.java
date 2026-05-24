package Root.Model;

import Root.Core.MyUtils;
import Root.View.SimulationArea.DriversPanel.DriversPanel;
import Root.View.SimulationArea.FarmersPanel.FarmersPanel;
import Root.View.SimulationArea.WarehousePanel.WarehousePanel;

import javax.swing.*;

public class SimulationVisualManager implements Runnable {
    private FarmersPanel farmersPanel;
    private WarehousePanel warehousePanel;
    private DriversPanel driversPanel;

    private final long OPTIMAL_TIME_NS = 1_000_000_000 / 60;

    public SimulationVisualManager(FarmersPanel farmersPanel, WarehousePanel warehousePanel, DriversPanel driversPanel) {
        this.farmersPanel = farmersPanel;
        this.warehousePanel = warehousePanel;
        this.driversPanel = driversPanel;
    }

    public void setWarehouseOrangesVisuals(int orangesAmount) {
        this.warehousePanel.setOrangesVisuals(orangesAmount);
    }

    public void setFarmersWorkersVisuals(int farmersAmount) {
        this.farmersPanel.setFarmersAmountVisuals(farmersAmount);
    }

    public void setDriversWorkersVisuals(int driversAmount) {
        this.driversPanel.setDriversAmountVisuals(driversAmount);
    }

    public void setWarehouseStats(double orangesStoredPerSec, double orangesCollectedPerSec, int totalStored, int totalCollected, int currentCapacity, int totalCapacity) {
        this.warehousePanel.setOrangesStats(orangesStoredPerSec, orangesCollectedPerSec, totalStored, totalCollected, currentCapacity, totalCapacity);
    }

    @Override
    public void run() {
        while (true) {
            long startTime = System.nanoTime();

            SwingUtilities.invokeLater(() -> {
                this.warehousePanel.repaint();
                this.farmersPanel.repaint();
                this.driversPanel.repaint();
            });

            long elapsedTime = System.nanoTime() - startTime;
            long sleepTimeNs = OPTIMAL_TIME_NS - elapsedTime;
            long sleepTimeMs = sleepTimeNs / 1_000_000;

            if (sleepTimeMs > 0) {
                MyUtils.sleep((int) sleepTimeMs);
            } else {
                // The system is lagging behind! Do not sleep so we can try to catch up.
                Thread.yield();
            }
        }
    }
}
