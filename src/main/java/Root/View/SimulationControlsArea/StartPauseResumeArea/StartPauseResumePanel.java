package Root.View.SimulationControlsArea.StartPauseResumeArea;

import Root.View.SimulationControlsArea.ControlsUtills.SimulationControlButton;
import Root.View.ViewUtills.ViewUtils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionListener;

public class StartPauseResumePanel extends JPanel {
    private SimulationControlButton startButton;
    private SimulationControlButton togglePauseButton;

    public StartPauseResumePanel() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("fill , align center"));
    }

    private void initializeComponents() {
        this.startButton = new SimulationControlButton("START SIMULATION");
        this.togglePauseButton = new SimulationControlButton("TOGGLE PAUSE/RESUME");

        this.add(this.startButton, "grow");
        this.add(this.togglePauseButton, "grow");
    }

    public void start(ActionListener actionListener) {
        this.startButton.addActionListener(actionListener);
    }

    public void togglePause(ActionListener actionListener) {
        this.togglePauseButton.addActionListener(actionListener);
    }
}
