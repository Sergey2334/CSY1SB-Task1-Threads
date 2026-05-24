package Root.Controller;

import Root.Core.Constants;
import Root.Core.MyUtils;
import Root.Model.WarehouseManager;
import Root.Model.Worker;

import java.util.LinkedList;

public class WorkerManager<W extends Worker> implements Runnable {
    private WarehouseManager warehouseManager;
    private LinkedList<W> workers = new LinkedList<>();
    private WorkerFactory<W> factory; // The factory that knows how to make 'W'

    private int totalWorkers = 0;

    private boolean start;
    private boolean isPaused;

    public WorkerManager(WarehouseManager warehouseManager, WorkerFactory<W> factory) {
        this.warehouseManager = warehouseManager;
        this.factory = factory;

        this.start = false;
        this.isPaused = false;
    }

    @Override
    public void run() {
        while (!this.start) {
            MyUtils.sleep(100);
        }
        this.initializeWorkers();

        while (!this.workers.isEmpty()) {
            while (!this.isPaused) {
                MyUtils.sleep(2 * 1000); // Gives the CPU some time to Breathe

                synchronized (this) {
                    for (int i = this.workers.size() - 1; i >= 0; i--) {
                        W worker = this.workers.get(i);
                        if (worker.getIdleTimeMs() >= Constants.MAX_IDLE_TIME_BEFORE_FIRE) {
                            worker.fire();
                            this.workers.remove(i);
                        }
                    }
                }
            }
        }
    }

    public void start() {
        this.start = true;
    }

    public void togglePause() {
        for (W worker : this.workers) {
            worker.togglePaused();
        }
        this.isPaused = !this.isPaused;
    }

    private void initializeWorkers() {
        for (int i = 0; i < Constants.WORKERS_AMOUNT_START; i++) {
            this.addWorker();
        }
    }

    public synchronized void addWorker() {
        // Use the factory to safely bypass Type Erasure!
        W newWorker = this.factory.create(this.warehouseManager);
        this.workers.add(newWorker);

        this.totalWorkers++;

        Thread workerThread = new Thread(newWorker);
        workerThread.start();
    }

    public synchronized void removeWorker(W worker) {
        if (this.workers.contains(worker)) {
            worker.fire();
            this.workers.remove(worker);
        }
    }

    public void removeFirstWorker() {
        if (!this.workers.isEmpty()) {
            this.removeWorker(this.workers.getFirst());
        }
    }

    public void setWorkersSpeedMultiplier(int value) {
        if (this.workers.isEmpty()) {
            return;
        }
        synchronized (this) {
            for (W worker : this.workers) {
                worker.setMinWorkTime(worker.getInitialMinWorkTime() / Math.max(value, 1));
                worker.setMaxWorkTime(worker.getInitialMaxWorkTime() / Math.max(value, 1));
            }
        }
    }

    public synchronized void printWorkers() {
        for (W worker : this.workers) {
            System.out.println(worker);
        }
    }

    // --- Getters ---
    public LinkedList<W> getWorkers() {
        return this.workers;
    }

    public synchronized int getWorkersFiredAmount() {
        return this.totalWorkers - this.workers.size();
    }

    public synchronized int getBestWorker() {
        int bestWorker = 0;
        long minIdleTime = Constants.MAX_IDLE_TIME_BEFORE_FIRE;

        for (W worker : this.workers) {
            if (worker.getIdleTimeMs() < minIdleTime) {
                bestWorker = worker.getId();
                minIdleTime = worker.getIdleTimeMs();
            }
        }

        return bestWorker;
    }

    public synchronized int getWorstWorker() {
        int worstWorker = 0;
        long maxIdleTime = 0;

        for (W worker : this.workers) {
            if (worker.getIdleTimeMs() > maxIdleTime) {
                worstWorker = worker.getId();
                maxIdleTime = worker.getIdleTimeMs();
            }
        }

        return worstWorker;
    }
}