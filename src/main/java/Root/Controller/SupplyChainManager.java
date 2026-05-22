package Root.Controller;

import Root.Core.MyUtils;
import Root.Model.Driver;
import Root.Model.Farmer;
import Root.Model.Warehouse;
import Root.Model.WarehouseManager;

public class SupplyChainManager implements Runnable {
    private WarehouseManager warehouseManager;
    private WorkerManager farmersManager;
    private WorkerManager driversManager;

    private Warehouse warehouse = new Warehouse();
    private SimulationVisualManager simulationVisualManager;

    public SupplyChainManager(SimulationVisualManager simulationVisualManager) {
        this.warehouseManager = new WarehouseManager(this.warehouse);
        this.simulationVisualManager = simulationVisualManager;
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

        this.simulationVisualManager.setFarmersWorkers(farmerAmount);
        this.simulationVisualManager.setWarehouseOranges(orangesAmount);
        this.simulationVisualManager.setDriversWorkers(driverAmount);
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

        while ((farmersThread.isAlive()) && (driversThread.isAlive())) {
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