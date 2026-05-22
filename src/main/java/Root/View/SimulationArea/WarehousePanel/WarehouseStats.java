package Root.View.SimulationArea.WarehousePanel;

import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;

public class WarehouseStats extends JPanel {
    public WarehouseStats() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Stats", true));
        this.add(new JLabel("STATS"));
    }
}
