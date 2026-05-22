package Root.View.SimulationControlsArea;

import Root.Core.Constants;
import Root.View.SimulationControlsArea.AddSubResetArea.AddSubResetPanel;
import Root.View.SimulationControlsArea.SlidersArea.SliderPanel;
import Root.View.SimulationControlsArea.StartPauseResumeArea.StartPauseResumePanel;
import Root.View.ViewUtills.ViewUtills;
import com.formdev.flatlaf.ui.FlatLineBorder;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class SimulationControlsArea extends JPanel {
    private SliderPanel sliderPanel;
    private AddSubResetPanel addSubResetPanel;
    private StartPauseResumePanel startPauseResumePanel;

    public SimulationControlsArea() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        // 1. "fill" stretches the whole grid vertically and horizontally
        String layoutConstraints = "fill, insets 0";

        // 2. Lock columns into exact proportions: 35%, 30%, 35%
        String columnConstraints = "[35%, align center, grow][30%, align center, grow][35%, align center, grow]";

        // 3. Stretches the row vertically to fill the full height
        String rowConstraints    = "[align center]";

        this.setLayout(new MigLayout(layoutConstraints, columnConstraints, rowConstraints));
    }

    private void initializeComponents() {
        this.setBorder(ViewUtills.createCustomTitledBorder("SIMULATION CONTROLS", true));

        this.sliderPanel = new SliderPanel();
        this.addSubResetPanel = new AddSubResetPanel();
        this.startPauseResumePanel = new StartPauseResumePanel();

        this.add(this.sliderPanel);
        this.add(this.addSubResetPanel);
        this.add(this.startPauseResumePanel);
    }
}