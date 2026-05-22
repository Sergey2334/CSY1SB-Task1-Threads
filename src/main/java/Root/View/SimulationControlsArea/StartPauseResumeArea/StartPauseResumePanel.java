package Root.View.SimulationControlsArea.StartPauseResumeArea;

import Root.View.SimulationControlsArea.ControlsUtills.SimulationControlButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class StartPauseResumePanel extends JPanel {
    public StartPauseResumePanel() {
        this.initialize();
    }

    private void initialize()
    {
        this.setLayout(new MigLayout("fill , align center"));

        this.add(new SimulationControlButton("START SIMULATION"));
        this.add(new SimulationControlButton("TOGGLE PAUSE/RESUME"));
    }
}
