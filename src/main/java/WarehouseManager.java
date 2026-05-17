public class WarehouseManager implements Runnable {
    private Warehouse warehouse;

    public WarehouseManager(Warehouse warehouse) {
        this.warehouse = warehouse;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (System.out) {
                System.out.println(this.warehouse);
                System.out.println();
            }
            MyUtils.sleep(5 * 1000);
        }
    }

    public synchronized long add() throws InterruptedException {
        long startIdleTimeMs = System.nanoTime();

        while (this.warehouse.getIsFull()) {
            wait();
        }
        this.warehouse.add();
        notifyAll();

        long endIdleTimeMs = System.nanoTime();
        return (endIdleTimeMs - startIdleTimeMs) / 1_000_000;
    }

    public synchronized long remove() throws InterruptedException {
        long startIdleTimeMs = System.nanoTime();

        while (this.warehouse.getIsEmpty()) {
            wait();
        }
        this.warehouse.remove();
        notifyAll();

        long endIdleTimeMs = System.nanoTime();
        return (endIdleTimeMs - startIdleTimeMs) / 1_000_000;
    }
}
