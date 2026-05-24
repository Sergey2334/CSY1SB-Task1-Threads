package Root.View.SimulationArea.DriversPanel;

import Root.Model.Worker;
import Root.View.ViewUtills.ViewUtils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.LinkedList;

public class DriversPanel extends JPanel {
    private DriversVisuals driversVisuals;
    private DriversStats driversStats;

    public DriversPanel() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 1"));
        this.setBorder(ViewUtils.createCustomTitledBorder("Drivers Panel", true));
    }

    private void initializeComponents() {
        this.driversVisuals = new DriversVisuals();
        this.driversStats = new DriversStats();

        this.add(this.driversVisuals, "grow x, grow y, push x, push y");
        this.add(this.driversStats, "grow x, grow y, push x, push y");
    }

    public void setDriversVisuals(LinkedList<Worker> driversList) {
        this.driversVisuals.setDriversVisuals(driversList);
    }

    public void setDriversStats(int workersAmount, int workersFired, String bestWorker, String worstWorker) {
        this.driversStats.setStats(workersAmount, workersFired, bestWorker, worstWorker);
    }
}
