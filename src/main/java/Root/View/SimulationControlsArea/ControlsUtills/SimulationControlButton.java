package Root.View.SimulationControlsArea.ControlsUtills;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;
import java.awt.*;

public class SimulationControlButton extends JButton {
    public SimulationControlButton(String text) {
        this.initialize(text);
    }

    private void initialize(String text) {
        // FlatLaf
        this.putClientProperty(FlatClientProperties.STYLE_CLASS, "neutral");
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.setText(text);
    }
}
