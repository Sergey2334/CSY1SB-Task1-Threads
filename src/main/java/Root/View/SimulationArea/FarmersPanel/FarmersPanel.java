package Root.View.SimulationArea.FarmersPanel;

import Root.View.ViewUtills.ViewUtills;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class FarmersPanel extends JPanel {
    private FarmersVisuals farmersVisuals;
    private FarmersStats farmersStats;

    public FarmersPanel() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 1"));
        this.setBorder(ViewUtills.createCustomTitledBorder("Faarmers Panel", true));
    }

    private void initializeComponents() {
        this.farmersVisuals = new FarmersVisuals();
        this.farmersStats = new FarmersStats();

        this.add(this.farmersVisuals, "grow x, grow y, push x, push y");
        this.add(this.farmersStats, "grow x, grow y, push x, push y");
    }
}
