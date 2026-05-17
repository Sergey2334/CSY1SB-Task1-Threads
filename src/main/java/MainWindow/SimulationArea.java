package MainWindow;

import javax.swing.*;
import java.awt.*;

public class SimulationArea extends JPanel {
    public SimulationArea() {
        this.setLayout(new GridBagLayout());

        this.setBackground(Color.LIGHT_GRAY);
        this.setForeground(Color.WHITE);

        this.createUIComponents();
    }

    private void createUIComponents() {
        JPanel farmerPanel = new JPanel();
        farmerPanel.setBackground(Color.ORANGE);
        farmerPanel.add(new JLabel("Farmer"));

        JPanel warehousePanel = new JPanel();
        warehousePanel.setBackground(Color.GREEN);
        warehousePanel.add(new JLabel("Warehouse"));

        JPanel driverPanel = new JPanel();
        driverPanel.setBackground(Color.BLUE);
        driverPanel.add(new JLabel("Driver"));

        this.add(farmerPanel);
        this.add(warehousePanel);
        this.add(driverPanel);
    }
}
