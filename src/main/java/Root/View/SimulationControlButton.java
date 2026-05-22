package Root.View;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;

public class SimulationControlButton extends JButton {
    public SimulationControlButton(String text) {
        this.initialize(text);
    }

    private void initialize(String text) {
        // FlatLaf
        this.putClientProperty(FlatClientProperties.STYLE_CLASS, "neutral");

        this.setText(text);
    }
}
