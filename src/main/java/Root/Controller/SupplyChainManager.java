package Root.Controller;

import Root.Core.Constants;
import Root.Core.MyUtils;
import Root.Model.*;
import Root.Model.SimulationVisualManager;

import java.util.LinkedList;

public class SupplyChainManager implements Runnable {
    private WarehouseManager warehouseManager;
    private WorkerManager farmersManager;
    private WorkerManager driversManager;
    private boolean isStarted;
    private boolean isPaused;

    private Warehouse warehouse = new Warehouse();
    private SimulationVisualManager simulationVisualManager;

    public SupplyChainManager(SimulationVisualManager simulationVisualManager) {
        this.isStarted = false;
        this.isPaused = false;

        this.simulationVisualManager = simulationVisualManager;
        this.warehouseManager = new WarehouseManager(this.warehouse);
        /*
        Replacing this...
        this.farmerManager = new WorkerManager<Farmer>(this.warehouseManager, new WorkerFactory<Farmer>() {
            @Override
            public Farmer create(WarehouseManager manager) {
                return new Farmer(manager);
            }
        });
         */

        this.farmersManager = new WorkerManager<Farmer>(this.warehouseManager, Farmer::new);
        this.driversManager = new WorkerManager<Driver>(this.warehouseManager, manager -> new Driver(manager));
    }

    private void update() {
        this.updateWarehouseVisuals();
        this.updateFarmersVisuals();
        this.updateDriversVisuals();
    }

    @Override
    public void run() {
        Thread warehouseThread = new Thread(this.warehouseManager);
        Thread farmersThread = new Thread(this.farmersManager);
        Thread driversThread = new Thread(this.driversManager);

        Thread simulationVisualsThread = new Thread(this.simulationVisualManager);

        warehouseThread.start();
        farmersThread.start();
        driversThread.start();
        simulationVisualsThread.start();

        while (true) {
            if (!this.isStarted || this.isPaused) {
                MyUtils.sleep(100);
                continue;
            }
            this.update();

            // Give's The CPU Some Time
            MyUtils.sleep(10);
        }
    }

    // --- Getters ---
    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public WarehouseManager getWarehouseManager() {
        return this.warehouseManager;
    }

    public WorkerManager<Farmer> getFarmersManager() {
        return this.farmersManager;
    }

    public WorkerManager<Driver> getDriversManager() {
        return this.driversManager;
    }

    // --- Setters ===
    // ADD_RESET_SUB Panel
    public void addMaxCapacity() {
        this.warehouse.setTotalCapacity(this.warehouse.getTotalCapacity() + 1);
    }

    public void resetCapacity() {
        this.warehouse.setTotalCapacity(Constants.WAREHOUSE_START_MAX_CAPACITY);
    }

    public void subMaxCapacity() {
        this.warehouse.setTotalCapacity(Math.max(this.warehouse.getTotalCapacity() - 1, 0));
    }

    // SLIDERS Panel
    public void addFarmer() {
        if (!this.isStarted || this.isPaused)
        {
            return;
        }

        this.farmersManager.addWorker();
    }

    public void addDriver() {
        if (!this.isStarted || this.isPaused)
        {
            return;
        }

        this.driversManager.addWorker();
    }

    public void subFarmer() {
        if (!this.isStarted || this.isPaused)
        {
            return;
        }

        this.farmersManager.removeFirstWorker();
    }

    public void subDriver() {
        if (!this.isStarted || this.isPaused)
        {
            return;
        }

        this.driversManager.removeFirstWorker();
    }

    public void setFarmerSpeedMultiplier(int value) {
        this.farmersManager.setWorkersSpeedMultiplier(value);
    }

    public void setDriverSpeedMultiplier(int value) {
        this.driversManager.setWorkersSpeedMultiplier(value);
    }

    public void setStarted() {
        this.isStarted = true;
    }

    public void togglePaused() {
        if (!this.isStarted)
        {
            return;
        }
        this.farmersManager.togglePause();
        this.driversManager.togglePause();
        this.isPaused = !this.isPaused;
    }

    // --- Helpers ---
    private void updateFarmersVisuals() {
        LinkedList<Worker> farmersList = this.farmersManager.getWorkers();
        int farmersFiredAmount = this.farmersManager.getWorkersFiredAmount();
        int bestFarmer = this.farmersManager.getBestWorker();
        int worstFarmer = this.farmersManager.getWorstWorker();

        this.simulationVisualManager.setFarmersWorkersVisuals(farmersList);
        this.simulationVisualManager.setFarmersStats(farmersList.size(), farmersFiredAmount, bestFarmer + "", worstFarmer + "");
    }

    private void updateDriversVisuals() {
        LinkedList driversList = this.driversManager.getWorkers();
        int driversFiredAmount = this.driversManager.getWorkersFiredAmount();
        int bestDriver = this.driversManager.getBestWorker();
        int worstDriver = this.driversManager.getWorstWorker();

        this.simulationVisualManager.setDriversWorkersVisuals(driversList);
        this.simulationVisualManager.setDriversStats(driversList.size(), driversFiredAmount, bestDriver + "", worstDriver + "");
    }

    private void updateWarehouseVisuals() {
        int orangesAmount = this.warehouse.getCurrentCapacity();

        double orangesStoredPerSecond = this.warehouseManager.getOrangesStoredPerSecond();
        double orangesCollectedPerSecond = this.warehouseManager.getOrangesCollectedPerSecond();
        int totalOrangesStored = this.warehouseManager.getTotalOrangesStored();
        int totalOrangesCollected = this.warehouseManager.getTotalOrangesCollected();
        int currentCapacity = this.warehouse.getCurrentCapacity();
        int maxCapacity = this.warehouse.getTotalCapacity();

        this.simulationVisualManager.setWarehouseOrangesVisuals(orangesAmount, this.warehouse.getTotalCapacity());
        this.simulationVisualManager.setWarehouseStats(orangesStoredPerSecond, orangesCollectedPerSecond, totalOrangesStored, totalOrangesCollected, currentCapacity, maxCapacity);
    }
}