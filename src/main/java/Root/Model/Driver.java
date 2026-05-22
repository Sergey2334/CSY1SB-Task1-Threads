package Root.Model;

import Root.Core.Constants;

public class Driver extends Worker {
    private int drivesCount;
    private int orangesCollected;

    private static int idCounter = 1;

    // Synchronized to prevent duplicate IDs if multiple threads create drivers
    private static synchronized int nextId() {
        return idCounter++;
    }

    public Driver(WarehouseManager warehouseManager) {
        super(nextId(), warehouseManager);
        this.drivesCount = 0;
        this.orangesCollected = 0;
    }

    @Override
    public void run() {
        this.captureExecutionThread(); // Must be first!

        while (this.getIsWorking() && !Thread.currentThread().isInterrupted()) {

            this.roleWork(Constants.DRIVER_MIN_DRIVE_TIME, Constants.DRIVER_MAX_DRIVE_TIME);
            this.drivesCount++;

            if (Thread.currentThread().isInterrupted()) {
                break;
            }

            this.warehouseWork(() -> this.getWarehouseManager().remove());
            this.orangesCollected++;
        }
    }

    @Override
    public String toString() {
        return "D #" + this.getId()
                + " [working: " + this.getIsWorking()
                + ", drives: " + this.drivesCount
                + ", collected: " + this.orangesCollected
                + "] [WorkTime: " + this.getWorkTimeSec()
                + "s, IdleTime: " + this.getIdleTimeMs() / 1000 + "s]";
    }

    // --- Getters ---
    public int  getDrivesCount() {
        return this.drivesCount;
    }
    public int getOrangesCollected() {
        return this.orangesCollected;
    }
}