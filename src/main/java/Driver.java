public class Driver implements Runnable {
    private int id;
    private boolean isWorking;
    private int drivesCount;
    private int orangesCollected;
    private long workTimeMs;
    private long idleTimeMs;

    private static int idCounter = 1;

    private WarehouseManager warehouseManager;

    public Driver(WarehouseManager warehouseManager) {
        this.id = idCounter++;
        this.isWorking = true;
        this.drivesCount = 0;
        this.orangesCollected = 0;
        this.workTimeMs = 0;
        this.idleTimeMs = 0;

        this.warehouseManager = warehouseManager;
    }

    public String toString() {
        return "D #" + this.id + " [working: " + this.isWorking + ", drives: " + this.drivesCount + ", collected: " + this.orangesCollected + "] [WorkTime: " + this.workTimeMs / 1000 + ", IdleTime: " + this.idleTimeMs / 1000 + "]";
    }

    @Override
    public void run() {
        // Simulate Waiting at Start
        MyUtils.sleep(MyUtils.getRandomNumber(Constants.DRIVER_MIN_DRIVE_TIME, Constants.DRIVER_MAX_DRIVE_TIME));

        while (this.isWorking) {
            this.drive();
            try {
                this.collect();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void drive() {
        long startWorkTimeMs = System.nanoTime();

        // Simulate Drive/working
        MyUtils.sleep(MyUtils.getRandomNumber(Constants.DRIVER_MIN_DRIVE_TIME, Constants.DRIVER_MAX_DRIVE_TIME));
        this.drivesCount++;

        long endWorkTimeMs = System.nanoTime();
        this.workTimeMs += (endWorkTimeMs - startWorkTimeMs) / 1_000_000; // Converting Nano To Millis
    }

    public void collect() throws InterruptedException {
        this.idleTimeMs += this.warehouseManager.remove();
        this.orangesCollected++;
    }

    public long getWorkTimeMs() {
        return this.workTimeMs;
    }

    public long getIdleTimeMs() {
        return this.idleTimeMs;
    }

    public void fire() {
        this.isWorking = false;
    }
}