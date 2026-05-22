package Root.View.SimulationArea.DriversPanel;

import Root.View.SimulationArea.WarehousePanel.WarehouseStats;
import Root.View.SimulationArea.WarehousePanel.WarehouseStorage;
import Root.View.ViewUtills.ViewUtills;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class DriversPanel extends JPanel {
    private DriversVisuals driversVisuals;
    private DriversStats driversStats;

    public DriversPanel() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 1"));
        this.setBorder(ViewUtills.createCustomTitledBorder("Drivers Panel", true));
    }

    private void initializeComponents() {
        this.driversVisuals = new DriversVisuals();
        this.driversStats = new DriversStats();

        this.add(this.driversVisuals, "grow x, grow y, push x, push y");
        this.add(this.driversStats, "grow x, grow y, push x, push y");
    }
}
