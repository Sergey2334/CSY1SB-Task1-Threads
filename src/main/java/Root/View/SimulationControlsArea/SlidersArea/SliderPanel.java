package Root.View.SimulationControlsArea.SlidersArea;

import Root.View.SimulationControlsArea.ControlsUtills.SimulationControlButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SliderPanel extends JPanel {
    public SliderPanel() {
        this.initialize();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 3, fill , align center"));

        this.add(new WorkerSpeedSlider("Framer"));
        this.add(new SimulationControlButton("ADD Farmer"));
        this.add(new SimulationControlButton("SUB Farmer"));
        this.add(new WorkerSpeedSlider("Driver"));
        this.add(new SimulationControlButton("ADD Farmer"));
        this.add(new SimulationControlButton("SUB Farmer"));
    }
}
