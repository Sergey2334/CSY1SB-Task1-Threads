package Root.View.SimulationArea.DriversPanel;

import Root.Core.Constants;
import Root.Model.Worker;
import Root.View.ViewUtills.ViewUtils;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class DriversVisuals extends JPanel {
    private LinkedList<Worker> driversList =  new LinkedList<>();

    public DriversVisuals() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtils.createCustomTitledBorder("Drivers Visuals", true));
    }

    public void setDriversVisuals(LinkedList<Worker> driversList) {
        this.driversList = driversList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ViewUtils.drawWorker(g, this, this.driversList, Constants.DRIVER_COLOR);
    }
}
