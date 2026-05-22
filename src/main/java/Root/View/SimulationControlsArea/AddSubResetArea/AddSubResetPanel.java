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
        this.setLayout(new MigLayout("fill , align center"));

        this.add(new SimulationControlButton("SUB CAP"));
        this.add(new SimulationControlButton("RESET"));
        this.add(new SimulationControlButton("ADD CAP"));
    }
}
