package Root.Model;

import Root.Core.Constants;
import Root.Core.MyUtils;
import Root.Core.WarehouseAction;

public abstract class Worker implements Runnable {
    private int id;
    private boolean isWorking;
    private boolean isIdle;
    private int roleWorkCount;
    private int warehouseWorkCount;
    private long workTimeSec;


    private int initialMinWorkTime;
    private int initialMaxWorkTime;
    private int minWorkTime;
    private int maxWorkTime;

    // Real Time idleTime Tracker
    private long accumulatedIdleTimeMs;
    private long currentWaitStartNs;

    private WarehouseManager warehouseManager;
    private Thread executionThread;

    private boolean isPaused;

    public Worker(int id, WarehouseManager warehouseManager, int minWorkTime, int maxWorkTime) {
        this.id = id;
        this.isWorking = true;
        this.isIdle = false;
        this.roleWorkCount = 0;
        this.warehouseWorkCount = 0;
        this.workTimeSec = 0;

        this.initialMinWorkTime = minWorkTime;
        this.initialMaxWorkTime = maxWorkTime;

        this.minWorkTime = minWorkTime;
        this.maxWorkTime = maxWorkTime;

        this.accumulatedIdleTimeMs = 0;
        this.currentWaitStartNs = 0;

        this.warehouseManager = warehouseManager;

        this.isPaused = false;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract void run();

    public void togglePaused() {
        this.isPaused = !this.isPaused;
    }

    protected final void captureExecutionThread() {
        this.executionThread = Thread.currentThread();
    }

    // Simulate Work
    public void roleWork() {
        int workTime = MyUtils.getRandomNumber(this.minWorkTime, this.maxWorkTime);
        MyUtils.sleep(workTime);

        this.workTimeSec += (workTime / 1000);
        this.roleWorkCount++;
    }

    /**
     * Executes the warehouse operation while live-tracking wait time.
     * The finally block guarantees time calculation even if the thread is interrupted.
     */
    public void warehouseWork(WarehouseAction action) {
        if (!this.getIsWorking()) {
            return;
        }

        synchronized (this) {
            this.currentWaitStartNs = System.nanoTime();
        }

        try {
            this.isIdle = true;
            action.execute();
            this.isIdle = false;
            this.warehouseWorkCount++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.isWorking = false;
        } finally {
            synchronized (this) {
                if (this.currentWaitStartNs != 0) {
                    long elapsed = (System.nanoTime() - this.currentWaitStartNs) / 1_000_000;
                    this.accumulatedIdleTimeMs += elapsed;
                    this.currentWaitStartNs = 0; // Reset
                }
            }
        }
    }


    public synchronized void fire() {
        this.isWorking = false;
        if (this.executionThread != null) {
            this.executionThread.interrupt(); // Kicks the thread awake from wait() instantly
        }
    }

    // --- Getters ---
    public synchronized boolean getIsWorking() {
        return this.isWorking;
    }

    public int getInitialMinWorkTime() {
        return this.initialMinWorkTime;
    }

    public int getInitialMaxWorkTime() {
        return this.initialMaxWorkTime;
    }

    public boolean getIsPaused() {
        return this.isPaused;
    }

    // Gets Real Idle Time, And Not Waiting To Be Awake :D
    public synchronized long getIdleTimeMs() {
        if (this.currentWaitStartNs == 0) {
            return this.accumulatedIdleTimeMs;
        }
        long liveWaitMs = (System.nanoTime() - this.currentWaitStartNs) / 1_000_000;
        return this.accumulatedIdleTimeMs + liveWaitMs;
    }

    public synchronized boolean getIsIdle() {
        return this.isIdle;
    }

    public synchronized int getId() {
        return this.id;
    }

    public long getWorkTimeSec() {
        return this.workTimeSec;
    }

    protected WarehouseManager getWarehouseManager() {
        return this.warehouseManager;
    }

    // --- Setters ---
    public void setInitialMinWorkTime(int initialMinWorkTime) {
        this.initialMinWorkTime = initialMinWorkTime;
    }

    public void setInitialMaxWorkTime(int initialMaxWorkTime) {
        this.initialMaxWorkTime = initialMaxWorkTime;
    }

    public void setMinWorkTime(int minWorkTime) {
        this.minWorkTime = minWorkTime;
    }

    public void setMaxWorkTime(int maxWorkTime) {
        this.maxWorkTime = maxWorkTime;
    }
}