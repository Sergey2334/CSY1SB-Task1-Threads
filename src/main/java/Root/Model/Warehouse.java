package Root.Model;

import Root.Core.Constants;

public class Warehouse {
    private int totalCapacity;
    private int currentCapacity;

    public Warehouse() {
        this.totalCapacity = Constants.WAREHOUSE_START_MAX_CAPACITY;
        this.currentCapacity = 0;
    }

    public String toString() {
        int progressBarLength = (this.totalCapacity * 3);
        int progressBarLengthFill = (this.currentCapacity * 3);
        String progressBar = "[";
        for (int i = 0; i < progressBarLengthFill; i++) {
            progressBar = progressBar + "#";
        }
        for (int i = 0; i < progressBarLength - progressBarLengthFill; i++) {
            progressBar = progressBar + " ";
        }
        progressBar = progressBar + "] " + ((float) (this.currentCapacity * 100) / this.totalCapacity) + "% ";

        return "Warehouse: CurrentCapacity: " + progressBar + this.currentCapacity + "/" + this.totalCapacity;
    }

    public synchronized boolean getIsFull() {
        return this.currentCapacity == this.totalCapacity;
    }

    public synchronized boolean getIsEmpty() {
        return this.currentCapacity == 0;
    }

    public synchronized int getCurrentCapacity() {
        return this.currentCapacity;
    }

    public synchronized int getTotalCapacity() {
        return this.totalCapacity;
    }

    public synchronized void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        if (this.currentCapacity >= this.totalCapacity)
        {
            this.currentCapacity = this.totalCapacity;
        }
    }

    public void add() {
        this.currentCapacity++;
    }

    public void remove() {
        this.currentCapacity--;
    }
}
