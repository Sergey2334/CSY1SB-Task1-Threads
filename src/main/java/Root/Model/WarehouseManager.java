package Root.Model;

import java.util.concurrent.atomic.AtomicInteger;

public class WarehouseManager implements Runnable {
    private Warehouse warehouse;

    // Thread-safe counters for statistics
    private AtomicInteger orangesStored;
    private AtomicInteger orangesCollected;
    private long startTimeMillis;

    public WarehouseManager(Warehouse warehouse) {
        this.warehouse = warehouse;

        this.orangesStored = new AtomicInteger(0);
        this.orangesCollected = new AtomicInteger(0);
        this.startTimeMillis = System.currentTimeMillis();
    }

    @Override
    public void run() {

    }

    public double getOrangesStoredPerSecond() {
        long elapsedTimeMillis = System.currentTimeMillis() - this.startTimeMillis;
        if (elapsedTimeMillis == 0) return 0.0;
        double elapsedTimeSeconds = elapsedTimeMillis / 1000.0;
        return this.orangesStored.get() / elapsedTimeSeconds;
    }

    // Calculates the average oranges collected per second
    public double getOrangesCollectedPerSecond() {
        long elapsedTimeMillis = System.currentTimeMillis() - this.startTimeMillis;

        // Prevent division by zero if called immediately
        if (elapsedTimeMillis == 0) return 0.0;

        double elapsedTimeSeconds = elapsedTimeMillis / 1000.0;
        return this.orangesCollected.get() / elapsedTimeSeconds;
    }

    public int getTotalOrangesStored() {
        return this.orangesStored.get();
    }

    public int getTotalOrangesCollected() {
        return this.orangesCollected.get();
    }

    public synchronized void add() throws InterruptedException {
        while (this.warehouse.getIsFull()) {
            wait();
        }
        this.warehouse.add();
        // Increment the count when an orange is produced/added
        this.orangesStored.incrementAndGet();
        notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        while (this.warehouse.getIsEmpty()) {
            wait();
        }
        this.warehouse.remove();
        this.orangesCollected.incrementAndGet();
        notifyAll();
    }
}