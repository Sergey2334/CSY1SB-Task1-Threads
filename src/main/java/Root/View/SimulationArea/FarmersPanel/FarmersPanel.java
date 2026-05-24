package Root.View.SimulationArea.FarmersPanel;

import Root.Model.Worker;
import Root.View.ViewUtills.ViewUtils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.LinkedList;

public class FarmersPanel extends JPanel {
    private FarmersVisuals farmersVisuals;
    private FarmersStats farmersStats;

    public FarmersPanel() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 1"));
        this.setBorder(ViewUtils.createCustomTitledBorder("Faarmers Panel", true));
    }

    private void initializeComponents() {
        this.farmersVisuals = new FarmersVisuals();
        this.farmersStats = new FarmersStats();

        this.add(this.farmersVisuals, "grow x, grow y, push x, push y");
        this.add(this.farmersStats, "grow x, grow y, push x, push y");
    }

    public void setFarmersVisuals(LinkedList<Worker> farmersList) {
        this.farmersVisuals.setFarmersVisuals(farmersList);
    }

    public void setFarmersStats(int workersAmount, int workersFired, String bestWorker, String worstWorker) {
        this.farmersStats.setStats(workersAmount, workersFired, bestWorker, worstWorker);
    }
}
