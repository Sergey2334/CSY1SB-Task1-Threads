package Root.Controller;

import Root.Model.*;
import Root.Model.SimulationVisualManager;

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
        int farmerAmount = this.farmersManager.getWorkers().size();
        int orangesAmount = this.warehouse.getCurrentCapacity();
        int driverAmount = this.driversManager.getWorkers().size();

        double orangesStoredPerSecond = this.warehouseManager.getOrangesStoredPerSecond();
        double orangesCollectedPerSecond = this.warehouseManager.getOrangesCollectedPerSecond();
        int totalOrangesStored = this.warehouseManager.getTotalOrangesStored();
        int totalOrangesCollected = this.warehouseManager.getTotalOrangesCollected();
        int currentCapacity = this.warehouse.getCurrentCapacity();
        int maxCapacity = this.warehouse.getTotalCapacity();

        this.simulationVisualManager.setFarmersWorkersVisuals(farmerAmount);
        this.simulationVisualManager.setWarehouseOrangesVisuals(orangesAmount);
        this.simulationVisualManager.setDriversWorkersVisuals(driverAmount);

        this.simulationVisualManager.setWarehouseStats(orangesStoredPerSecond, orangesCollectedPerSecond, totalOrangesStored, totalOrangesCollected, currentCapacity, maxCapacity);
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
}