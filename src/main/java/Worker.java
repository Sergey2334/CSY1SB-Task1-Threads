public abstract class Worker implements Runnable {
    private int id;
    private boolean isWorking;
    private int roleWorkCount;
    private int warehouseWorkCount;
    private long workTimeSec;

    // Real Time idleTime Tracker
    private long accumulatedIdleTimeMs;
    private long currentWaitStartNs;

    private WarehouseManager warehouseManager;
    private Thread executionThread;

    public Worker(int id, WarehouseManager warehouseManager) {
        this.id = id;
        this.isWorking = true;
        this.roleWorkCount = 0;
        this.warehouseWorkCount = 0;
        this.workTimeSec = 0;

        this.accumulatedIdleTimeMs = 0;
        this.currentWaitStartNs = 0;

        this.warehouseManager = warehouseManager;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract void run();

    protected final void captureExecutionThread() {
        this.executionThread = Thread.currentThread();
    }

    // Simulate Work
    public void roleWork(int minWorkTime, int maxWorkTime) {
        int workTime = MyUtils.getRandomNumber(minWorkTime, maxWorkTime);
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
            action.execute();
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

    // Gets Real Idle Time, And Not Waiting To Be Awake :D
    public synchronized long getIdleTimeMs() {
        if (this.currentWaitStartNs == 0) {
            return this.accumulatedIdleTimeMs;
        }
        long liveWaitMs = (System.nanoTime() - this.currentWaitStartNs) / 1_000_000;
        return this.accumulatedIdleTimeMs + liveWaitMs;
    }

    public int getId() {
        return this.id;
    }

    public long getWorkTimeSec() {
        return this.workTimeSec;
    }

    protected WarehouseManager getWarehouseManager() {
        return this.warehouseManager;
    }
}