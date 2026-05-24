package Root.View.SimulationArea.FarmersPanel;

import Root.Core.Constants;
import Root.View.ViewUtills.ViewUtills;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class FarmersVisuals extends JPanel {
    private int farmersAmount = 0;

    public FarmersVisuals() {
        this.initialize();
    }

    private void initialize() {
        this.setBorder(ViewUtills.createCustomTitledBorder("Farmers Visuals", true));
    }

    public void setFarmersAmountVisuals(int farmersAmount) {
        this.farmersAmount = farmersAmount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ViewUtills.drawWorker(g, this, this.farmersAmount, Constants.FARMER_COLOR);
    }
}
