package Root.View.SimulationArea;

import Root.Controller.SimulationVisualManager;
import Root.Controller.SupplyChainManager;
import Root.View.SimulationArea.DriversPanel.DriversPanel;
import Root.View.SimulationArea.FarmersPanel.FarmersPanel;
import Root.View.SimulationArea.WarehousePanel.WarehousePanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SimulationArea extends JPanel {
    private FarmersPanel farmersPanel;
    private WarehousePanel warehousePanel;
    private DriversPanel driversPanel;

    private SimulationVisualManager simulationVisualManager;
    private SupplyChainManager supplyChainManager;

    public SimulationArea() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        // 1. "fill" stretches the whole grid vertically and horizontally
        String layoutConstraints = "fill, insets 0";

        // 2. Lock columns into exact proportions: 35%, 30%, 35%
        String columnConstraints = "[35%, fill, grow][30%, fill, grow][35%, fill, grow]";

        // 3. Stretches the row vertically to fill the full height
        String rowConstraints    = "[fill]";

        this.setLayout(new MigLayout(layoutConstraints, columnConstraints, rowConstraints));
    }

    private void initializeComponents() {
        this.farmersPanel = new FarmersPanel();
        this.warehousePanel = new WarehousePanel();
        this.driversPanel = new DriversPanel();

        this.simulationVisualManager = new SimulationVisualManager(this.farmersPanel, this.warehousePanel, this.driversPanel);

        this.supplyChainManager = new SupplyChainManager(this.simulationVisualManager);
        Thread supplyChainThread = new Thread(this.supplyChainManager);

        this.add(this.farmersPanel);
        this.add(this.warehousePanel);
        this.add(this.driversPanel);

        supplyChainThread.start();
    }


}