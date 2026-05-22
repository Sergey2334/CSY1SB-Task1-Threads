package Root.View;

import Root.Core.Constants;
import com.formdev.flatlaf.ui.FlatLineBorder;

import javax.swing.*;
import java.awt.*;

public class SimulationControlsArea extends JPanel {
    public SimulationControlsArea() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new FlowLayout());
        FlatLineBorder flatLineBorder = new FlatLineBorder(new Insets(1, 1, 1, 1), Color.GRAY, 1, 16);
        this.setBorder(BorderFactory.createTitledBorder(flatLineBorder,
                "SIMULATION CONTROLS",
                2,
                2,
                new Font(Constants.coolFont1, Font.BOLD, 16),
                Color.WHITE));
    }

    private void initializeComponents() {
        this.add(new SimulationControlButton("TEST1"));
        this.add(new SimulationControlButton("TEST2"));
        this.add(new SimulationControlButton("TEST3"));
    }
}