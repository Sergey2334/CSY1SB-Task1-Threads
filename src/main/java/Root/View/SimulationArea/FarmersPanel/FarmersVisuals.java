package Root.View.SimulationArea.FarmersPanel;

import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;

public class FarmersVisuals extends JPanel {
    public FarmersVisuals() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Farmers Visuals", true));
        this.add(new JLabel("FARMERS"));
    }
}
