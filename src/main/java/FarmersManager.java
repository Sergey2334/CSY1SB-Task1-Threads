import java.util.LinkedList;

public class FarmersManager implements Runnable {
    private WarehouseManager warehouseManager;
    private LinkedList<Farmer> farmers = new LinkedList<>();

    public FarmersManager(WarehouseManager warehouseManager) {
        this.warehouseManager = warehouseManager;
    }

    @Override
    public void run() {
        this.startFarmers();

        while (true) {
            synchronized (System.out) {
                this.printFarmers();
            }
            MyUtils.sleep(5 * 1000);

            for (Farmer farmer : this.farmers) {
                if (farmer.getIdleTimeMs() >= 2 * 1000) {
                    farmer.fire();
                }
            }
        }
    }

    private void initializeFarmers() {
        for (int i = 0; i < 5; i++) {
            this.farmers.add(new Farmer(this.warehouseManager));
        }
    }

    private void startFarmers() {
        this.initializeFarmers();

        for (Farmer farmer : this.farmers) {
            Thread farmerThread = new Thread(farmer);
            farmerThread.start();
        }
    }

    public void addFarmer() {
        this.farmers.add(new Farmer(this.warehouseManager));
    }

    public void removeFarmer(Farmer farmer) {
        this.farmers.remove(farmer);
    }

    public void printFarmers() {
        for (Farmer farmer : this.farmers) {
            System.out.println(farmer);
        }
        System.out.println();
    }
}
