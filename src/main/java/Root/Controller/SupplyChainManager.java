package Root.Controller;

import Root.Model.*;
import Root.Model.SimulationVisualManager;

import java.util.LinkedList;

public class SupplyChainManager implements Runnable {
    private WarehouseManager warehouseManager;
    private WorkerManager farmersManager;
    private WorkerManager driversManager;

    private Warehouse warehouse = new Warehouse();
    private SimulationVisualManager simulationVisualManager;

    public SupplyChainManager(SimulationVisualManager simulationVisualManager) {
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
            this.update();

//            MyUtils.sleep(2 * 1000); // Check status every 2 seconds
//            System.out.println("=== SYSTEM SNAPSHOT ===");
//            System.out.println(this.warehouse);
//            System.out.println("-----------------------");
//            this.farmersManager.printWorkers();
//            System.out.println();
//            this.driversManager.printWorkers();
//            System.out.println("=======================\n");
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

        this.simulationVisualManager.setWarehouseOrangesVisuals(orangesAmount);
        this.simulationVisualManager.setWarehouseStats(orangesStoredPerSecond, orangesCollectedPerSecond, totalOrangesStored, totalOrangesCollected, currentCapacity, maxCapacity);
    }
}