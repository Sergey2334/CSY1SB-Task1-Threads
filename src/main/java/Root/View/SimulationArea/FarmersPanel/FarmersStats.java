package Root.View.SimulationArea.FarmersPanel;

import Root.Core.Constants;
import Root.View.ViewUtills.ViewUtils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class FarmersStats extends JPanel {
    private JLabel workersAmount;
    private JLabel workersFired;
    private JLabel bestWorker;
    private JLabel worstWorker;

    public FarmersStats() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 1, fill"));
        this.setBorder(ViewUtils.createCustomTitledBorder("Farmers Stats", true));
    }

    private void initializeComponents() {
        this.workersAmount = new JLabel("Workers Amount: ");
        this.workersFired = new JLabel("Workers Fired: ");
        this.bestWorker = new JLabel("Best Worker: ");
        this.worstWorker = new JLabel("Worst Worker: ");

        Font textFont = Constants.COOL_FONT1;
        this.workersAmount.setFont(textFont);
        this.workersFired.setFont(textFont);
        this.bestWorker.setFont(textFont);
        this.worstWorker.setFont(textFont);

        this.add(this.workersAmount, "grow x, push x");
        this.add(this.workersFired, "grow x, push x");
        this.add(this.bestWorker, "grow x, push x");
        this.add(this.worstWorker, "grow x, push x");
    }

    public void setStats(int workersAmount, int workersFired, String bestWorker, String worstWorker) {
        this.workersAmount.setText("Workers Amount: " + workersAmount);
        this.workersFired.setText("Workers Fired: " + workersFired);
        this.bestWorker.setText("Best Worker: " + bestWorker);
        this.worstWorker.setText("Worst Worker: " + worstWorker);
    }
}
