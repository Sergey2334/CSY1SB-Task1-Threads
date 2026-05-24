package Root.View.SimulationArea.FarmersPanel;

import Root.Core.Constants;
import Root.Model.Worker;
import Root.View.ViewUtills.ViewUtils;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class FarmersVisuals extends JPanel {
    private LinkedList<Worker> farmersList = new LinkedList<Worker>();

    public FarmersVisuals() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtils.createCustomTitledBorder("Farmers Visuals", true));
    }

    public void setFarmersVisuals(LinkedList<Worker> farmersList) {
        this.farmersList = farmersList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ViewUtils.drawWorker(g, this, this.farmersList, Constants.FARMER_COLOR);
    }
}
