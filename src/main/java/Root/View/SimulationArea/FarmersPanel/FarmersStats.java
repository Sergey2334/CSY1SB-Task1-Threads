package Root.View.SimulationArea.FarmersPanel;

import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;

public class FarmersStats extends JPanel {
    public FarmersStats() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Farmers Stats", true));
        this.add(new JLabel("FARMERS STATS"));
    }
}
