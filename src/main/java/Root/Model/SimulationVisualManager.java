package Root.Model;

import Root.Core.MyUtils;
import Root.View.SimulationArea.DriversPanel.DriversPanel;
import Root.View.SimulationArea.FarmersPanel.FarmersPanel;
import Root.View.SimulationArea.WarehousePanel.WarehousePanel;

import javax.swing.*;
import java.util.LinkedList;

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

    public void setFarmersWorkersVisuals(LinkedList<Worker> farmersList) {
        this.farmersPanel.setFarmersVisuals(farmersList);
    }

    public void setDriversWorkersVisuals(LinkedList<Worker> driversList) {
        this.driversPanel.setDriversVisuals(driversList);
    }

    public void setWarehouseStats(double orangesStoredPerSec, double orangesCollectedPerSec, int totalStored, int totalCollected, int currentCapacity, int totalCapacity) {
        this.warehousePanel.setOrangesStats(orangesStoredPerSec, orangesCollectedPerSec, totalStored, totalCollected, currentCapacity, totalCapacity);
    }

    public void setFarmersStats(int workersAmount, int workersFired, String bestWorker, String worstWorker) {
        this.farmersPanel.setFarmersStats(workersAmount, workersFired, bestWorker, worstWorker);
    }

    public void setDriversStats(int workersAmount, int workersFired, String bestWorker, String worstWorker) {
        this.driversPanel.setDriversStats(workersAmount, workersFired, bestWorker, worstWorker);
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
