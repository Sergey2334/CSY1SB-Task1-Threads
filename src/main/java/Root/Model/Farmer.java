package Root.Model;

import Root.Core.Constants;

public class Farmer extends Worker {
    private int orangesPicked;
    private int orangesStored;

    private static int idCounter = 1;

    // Synchronized to prevent duplicate IDs if multiple threads create farmers
    private static synchronized int nextId() {
        return idCounter++;
    }

    public Farmer(WarehouseManager warehouseManager) {
        super(nextId(), warehouseManager, Constants.FARMER_MIN_PICKING_TIME, Constants.FARMER_MAX_PICKING_TIME);
        this.orangesPicked = 0;
        this.orangesStored = 0;
    }

    @Override
    public void run() {
        this.captureExecutionThread(); // Must be first!

        while (this.getIsWorking() && !Thread.currentThread().isInterrupted()) {

            while (!this.getIsPaused())
            {
                this.roleWork();
                this.orangesPicked++;

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                this.warehouseWork(() -> this.getWarehouseManager().add());
                this.orangesStored++;
            }
        }
    }

    @Override
    public String toString() {
        return "F #" + this.getId()
                + " [working: " + this.getIsWorking()
                + ", picked: " + this.orangesPicked
                + ", stored: " + this.orangesStored
                + "] [WorkTime: " + this.getWorkTimeSec()
                + "s, IdleTime: " + this.getIdleTimeMs() / 1000 + "s]";
    }

    // --- Getters ---
    public int getOrangesPicked() {
        return this.orangesPicked;
    }
    public int getOrangesStored() {
        return this.orangesStored;
    }
}