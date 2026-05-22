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
        this.setLayout(new MigLayout("gap 10 10, insets 5 5 5 5"));

        this.add(new SimulationControlButton("START SIMULATION"), "grow x, push x");
        this.add(new SimulationControlButton("TOGGLE PAUSE/RESUME"), "grow x, push x");
    }
}
