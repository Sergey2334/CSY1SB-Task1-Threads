import java.util.LinkedList;

public class WorkerManager<W extends Worker> implements Runnable {
    private WarehouseManager warehouseManager;
    private LinkedList<W> workers = new LinkedList<>();
    private WorkerFactory<W> factory; // The factory that knows how to make 'W'

    public WorkerManager(WarehouseManager warehouseManager, WorkerFactory<W> factory) {
        this.warehouseManager = warehouseManager;
        this.factory = factory;
    }

    @Override
    public void run() {
        this.startWorkers();

        while (true) {
            MyUtils.sleep(2 * 1000); // Gives the CPU some time to Breathe

            synchronized (this) {
                for (int i = this.workers.size() - 1; i >= 0; i--) {
                    W worker = this.workers.get(i);
                    if (worker.getIdleTimeMs() >= 2 * 1000) {
                        worker.fire();
                        this.workers.remove(i);
                    }
                }
            }
        }
    }

    private void initializeWorkers() {
        for (int i = 0; i < 5; i++) {
            this.addWorker();
        }
    }

    private void startWorkers() {
        this.initializeWorkers();

        for (W worker : this.workers) {
            Thread workerThread = new Thread(worker);
            workerThread.start();
        }
    }

    public synchronized void addWorker() {
        // Use the factory to safely bypass Type Erasure!
        W newWorker = this.factory.create(this.warehouseManager);
        this.workers.add(newWorker);
    }

    public synchronized void removeWorker(W worker) {
        if (this.workers.contains(worker)) {
            worker.fire();
            this.workers.remove(worker);
        }
    }

    public synchronized void printWorkers() {
        for (W worker : this.workers) {
            System.out.println(worker);
        }
    }
}