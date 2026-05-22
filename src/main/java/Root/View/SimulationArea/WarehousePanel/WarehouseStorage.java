package Root.View.SimulationArea.WarehousePanel;

import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;

public class WarehouseStorage extends JPanel {
    public WarehouseStorage() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Warehouse Oranges", true));
        this.add(new JLabel("STORAGE"));
    }
}
