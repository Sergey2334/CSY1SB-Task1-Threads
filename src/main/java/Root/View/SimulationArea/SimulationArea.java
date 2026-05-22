package Root.View.SimulationArea;

import Root.View.SimulationArea.DriversPanel.DriversPanel;
import Root.View.SimulationArea.FarmersPanel.FarmersPanel;
import Root.View.SimulationArea.WarehousePanel.WarehousePanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SimulationArea extends JPanel {
    private DriversPanel driversPanel;
    private WarehousePanel warehousePanel;
    private FarmersPanel farmersPanel;

    public SimulationArea() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout());
    }

    private void initializeComponents() {
        this.driversPanel = new DriversPanel();
        this.warehousePanel = new WarehousePanel();
        this.farmersPanel = new FarmersPanel();

        this.add(this.driversPanel, "grow x, grow y, push x 35, push y");
        this.add(this.warehousePanel, "grow x, grow y, push x 30, push y");
        this.add(this.farmersPanel, "grow x, grow y, push x 35, push y");
    }
}