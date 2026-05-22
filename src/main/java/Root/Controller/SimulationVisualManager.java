package Root.Controller;

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

    public void setWarehouseOranges(int orangesAmount)
    {
        this.warehousePanel.setOrangesAmount(orangesAmount);
    }

    public void setFarmersWorkers(int farmersAmount)
    {
        this.farmersPanel.setFarmersAmount(farmersAmount);
    }

    public void setDriversWorkers(int driversAmount)
    {
        this.driversPanel.setDriversAmount(driversAmount);
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
