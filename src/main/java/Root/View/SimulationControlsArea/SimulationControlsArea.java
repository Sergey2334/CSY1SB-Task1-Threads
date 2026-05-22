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
        // "fillx" makes the layout engine stretch across the full width of the parent container
        // "insets 15 10 10 10" gives breathing room below your titled border
        this.setLayout(new MigLayout("fillx"));
        FlatLineBorder flatLineBorder = new FlatLineBorder(new Insets(1, 1, 1, 1), Color.GRAY, 1, 16);
        this.setBorder(ViewUtills.createCustomTitledBorder("SIMULATION CONTROLS", true));

        this.sliderPanel = new SliderPanel();
        this.addSubResetPanel = new AddSubResetPanel();
        this.startPauseResumePanel = new StartPauseResumePanel();
    }

    private void initializeComponents() {
        this.add(this.sliderPanel, "grow x, push x 25");
        this.add(this.addSubResetPanel, "grow x, push x 50");
        this.add(this.startPauseResumePanel, "grow x, push x 25");
    }
}