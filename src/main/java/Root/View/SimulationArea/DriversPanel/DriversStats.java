package Root.View.SimulationArea.DriversPanel;

import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;

public class DriversStats extends JPanel {
    public DriversStats() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Driver Stats", true));
        this.add(new JLabel("DRIVERS STATS"));
    }
}
