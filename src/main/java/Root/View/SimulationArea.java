package Root.View;

import com.formdev.flatlaf.extras.components.FlatProgressBar;

import javax.swing.*;
import java.awt.*;

public class SimulationArea extends JPanel {
    public SimulationArea() {
        this.initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());
        FlatProgressBar progressBar = new FlatProgressBar();
        progressBar.setMaximum(100);
//        progressBar.setSquare(true);
        progressBar.setMinimum(0);
        progressBar.setStringPainted(true);
        progressBar.setVisible(true);

        this.add(progressBar, BorderLayout.CENTER);
    }
}