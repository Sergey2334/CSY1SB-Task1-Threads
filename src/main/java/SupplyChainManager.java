public class SupplyChainManager implements Runnable {
    private WarehouseManager warehouseManager;
    private WorkerManager farmersManager;
    private WorkerManager driversManager;

    private Warehouse warehouse = new Warehouse();

    public SupplyChainManager() {
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

    @Override
    public void run() {
        Thread warehouseThread = new Thread(this.warehouseManager);
        Thread farmersThread = new Thread(this.farmersManager);
        Thread driversThread = new Thread(this.driversManager);

        warehouseThread.start();
        farmersThread.start();
        driversThread.start();

        while (true) {
            MyUtils.sleep(2000); // Check status every 2 seconds
            System.out.println("=== SYSTEM SNAPSHOT ===");
            System.out.println(warehouse);
            System.out.println("-----------------------");
            farmersManager.printWorkers();
            System.out.println();
            driversManager.printWorkers();
            System.out.println("=======================\n");
        }
    }
}