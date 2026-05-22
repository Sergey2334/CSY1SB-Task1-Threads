package Root.View.SimulationArea.DriversPanel;

import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;

public class DriversVisuals extends JPanel {
    public DriversVisuals() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Drivers Visuals", true));
        this.add(new JLabel("DRIVERS"));
    }
}
