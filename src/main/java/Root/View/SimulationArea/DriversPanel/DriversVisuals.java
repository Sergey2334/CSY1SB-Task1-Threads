package Root.View.SimulationArea.DriversPanel;

import Root.Core.Constants;
import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;
import java.awt.*;

public class DriversVisuals extends JPanel {
    private int driversAmount = 0;

    public DriversVisuals() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Drivers Visuals", true));
    }

    public void setDriversAmountVisuals(int driversAmount) {
        this.driversAmount = driversAmount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ViewUtills.drawWorker(g, this, this.driversAmount, Constants.DRIVER_COLOR);
    }
}
