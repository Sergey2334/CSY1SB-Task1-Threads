package Root.View.SimulationControlsArea.AddSubResetArea;

import Root.View.SimulationControlsArea.ControlsUtills.SimulationControlButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class AddSubResetPanel extends JPanel {
    public AddSubResetPanel() {
        this.initialize();
    }
    private void initialize()
    {
        this.setLayout(new MigLayout("gap 10 10, insets 5 5 5 5"));

        this.add(new SimulationControlButton("SUB CAP"), "grow x, push x");
        this.add(new SimulationControlButton("RESET"), "grow x, push x");
        this.add(new SimulationControlButton("ADD CAP"), "grow x, push x");
    }
}
