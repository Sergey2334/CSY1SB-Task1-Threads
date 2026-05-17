package MainWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Threads Problem");
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(new SimulationControlsArea(), BorderLayout.SOUTH);
        this.add(new SimulationArea(), BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
