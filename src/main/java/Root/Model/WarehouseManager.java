package Root.Model;

public class WarehouseManager implements Runnable {
    private Warehouse warehouse;

    public WarehouseManager(Warehouse warehouse) {
        this.warehouse = warehouse;
    }


    @Override
    public void run() {

    }

    public synchronized void add() throws InterruptedException {
        while (this.warehouse.getIsFull()) {
            wait();
        }
        this.warehouse.add();
        notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        while (this.warehouse.getIsEmpty()) {
            wait();
        }
        this.warehouse.remove();
        notifyAll();
    }
}
