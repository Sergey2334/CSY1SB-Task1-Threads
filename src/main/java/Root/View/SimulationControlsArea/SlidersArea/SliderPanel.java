package Root.View.SimulationControlsArea.SlidersArea;

import Root.View.SimulationControlsArea.ControlsUtills.SimulationControlButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SliderPanel extends JPanel {
    public SliderPanel() {
        this.initialize();
    }

    private void initialize() {
        // "wrap 1" forces a new row after every single component (vertical stacking)
        // "gap 10 10" sets a 10px horizontal gap and 10px vertical gap between elements
        // "insets 0" removes external margins around the panel (adjust if you want padding)
        this.setLayout(new MigLayout("wrap 3, gap 5 5, insets 0 0 0 5"));
        this.add(new WorkerSpeedSlider("Framer"), "grow x, push x");
        this.add(new SimulationControlButton("ADD Farmer"), "grow x, push x");
        this.add(new SimulationControlButton("SUB Farmer"), "grow x, push x");
        this.add(new WorkerSpeedSlider("Driver"), "grow x, push x");
        this.add(new SimulationControlButton("ADD Farmer"), "grow x, push x");
        this.add(new SimulationControlButton("SUB Farmer"), "grow x, push x");
    }
}
