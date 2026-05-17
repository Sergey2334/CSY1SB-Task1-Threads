public class SupplyChainManager {
    private WarehouseManager warehouseManager;
    private FarmersManager farmersManager;
    private DriversManager driversManager;

    private Warehouse warehouse = new Warehouse();

    public SupplyChainManager() {
        this.warehouseManager = new WarehouseManager(this.warehouse);
        this.farmersManager = new FarmersManager(this.warehouseManager);
        this.driversManager = new DriversManager(this.warehouseManager);
    }

}
