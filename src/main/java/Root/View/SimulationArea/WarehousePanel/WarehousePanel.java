package Root.View.SimulationArea.WarehousePanel;

import Root.View.ViewUtills.ViewUtills;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class WarehousePanel extends JPanel {
    private WarehouseStorage warehouseStorage;
    private WarehouseStats warehouseStats;

    public WarehousePanel() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 1"));
        this.setBorder(ViewUtills.createCustomTitledBorder("Warehouse Panel", true));
    }

    private void initializeComponents() {
        this.warehouseStorage = new WarehouseStorage();
        this.warehouseStats = new WarehouseStats();

        this.add(this.warehouseStorage, "grow x, grow y, push x, push y");
        this.add(this.warehouseStats, "grow x, grow y, push x, push y");
    }

    public void setOrangesAmount(int orangesAmount) {
        this.warehouseStorage.setOrangesAmount(orangesAmount);
    }
}
