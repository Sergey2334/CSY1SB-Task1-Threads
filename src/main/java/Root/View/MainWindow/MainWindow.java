package Root.View.MainWindow;

import Root.View.SimulationArea.SimulationArea;
import Root.View.SimulationControlsArea.SimulationControlsArea;
import com.formdev.flatlaf.extras.components.FlatSeparator;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private SimulationArea simulationArea;
    private SimulationControlsArea simulationControlsArea;

    public MainWindow() {
        this.initialize();
        this.initializeComponents();

        this.setVisible(true);
    }

    private void initialize() {
        this.setTitle("Producer Consumer Simulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);

//        this.getRootPane().putClientProperty("JRootPane.titleBarHeight", 35);
//        this.setResizable(false);
        this.setLayout(new BorderLayout());

//        this.pack();
        this.setLocationRelativeTo(null);
    }

    // --- Load and Set Window Icon Image ---
    private void initializeImageIcon() {
        try {
            java.net.URL iconURL = getClass().getResource("/orange-icon.png");
            if (iconURL != null) {
                ImageIcon icon = new ImageIcon(iconURL);
                this.setIconImage(icon.getImage());
            } else {
                System.err.println("Could not find orange-icon.png resource file!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeComponents() {
        this.simulationArea = new SimulationArea();
        this.simulationControlsArea = new SimulationControlsArea();

        this.initializeImageIcon();
        this.add(new JSeparator(), BorderLayout.NORTH);
        this.add(simulationArea, BorderLayout.CENTER);
        this.add(simulationControlsArea, BorderLayout.SOUTH);
    }
}