public class Farmer implements Runnable {
    private int id;
    private boolean isWorking;
    private int orangesPicked;
    private int orangesStored;
    private long workTimeMs;
    private long idleTimeMs;

    private static int idCounter = 1;

    private WarehouseManager warehouseManager;

    public Farmer(WarehouseManager warehouseManager) {
        this.id = idCounter++;
        this.isWorking = true;
        this.orangesPicked = 0;
        this.orangesStored = 0;
        this.workTimeMs = 0;
        this.idleTimeMs = 0;

        this.warehouseManager = warehouseManager;
    }

    public String toString() {
        return "F #" + this.id + " [working: " + this.isWorking + ", picked: " + this.orangesPicked + ", stored: " + this.orangesStored + "] [WorkTime: " + this.workTimeMs / 1000 + ", IdleTime: " + this.idleTimeMs / 1000 + "]";
    }

    @Override
    public void run() {
        while (isWorking) {
            this.pickOrange();
            try {
                this.storeOrange();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pickOrange() {
        long startWorkTimeMs = System.nanoTime();

        // Simulate harvesting/working
        MyUtils.sleep(MyUtils.getRandomNumber(Constants.FARMER_MIN_PICKING_TIME, Constants.FARMER_MAX_PICKING_TIME));
        this.orangesPicked++;

        long endWorkTimeMs = System.nanoTime();
        this.workTimeMs += (endWorkTimeMs - startWorkTimeMs) / 1_000_000; // Converting Nano To Millis
    }

    public void storeOrange() throws InterruptedException {
        this.idleTimeMs += this.warehouseManager.add();
        this.orangesStored++;
    }

    public long getWorkTimeMs() {
        return this.workTimeMs;
    }

    public long getIdleTimeMs() {
        return this.idleTimeMs;
    }

    public void fire()
    {
        this.isWorking = false;
    }
}
