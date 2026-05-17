import java.util.LinkedList;

public class DriversManager implements Runnable {
    private WarehouseManager warehouseManager;
    private LinkedList<Driver> drivers = new LinkedList<>();

    public DriversManager(WarehouseManager warehouseManager) {
        this.warehouseManager = warehouseManager;
    }

    @Override
    public void run() {
        this.startDrivers();

        while (true) {
            synchronized (System.out) {
                this.printDrivers();
            }
            MyUtils.sleep(5 * 1000);

            for (Driver driver : drivers) {
                if (driver.getIdleTimeMs() >= 2 * 1000) {
                    driver.fire();
                }
            }
        }

    }

    private void initializeDrivers() {
        for (int i = 0; i < 5; i++) {
            this.drivers.add(new Driver(this.warehouseManager));
        }
    }

    private void startDrivers() {
        this.initializeDrivers();

        for (Driver driver : this.drivers) {
            Thread driverThread = new Thread(driver);
            driverThread.start();
        }
    }

    public void addDriver() {
        this.drivers.add(new Driver(this.warehouseManager));
    }

    public void removeDriver(Driver driver) {
        this.drivers.remove(driver);
    }

    public void printDrivers() {
        for (Driver driver : this.drivers) {
            System.out.println(driver);
        }
        System.out.println();
    }

}
