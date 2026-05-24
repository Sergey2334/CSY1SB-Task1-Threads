package Root.View.SimulationControlsArea.SlidersArea;

import Root.View.ViewUtills.ViewUtils;
import com.formdev.flatlaf.extras.components.FlatSlider;

import javax.swing.*;
import java.awt.*;

public class WorkerSpeedSlider extends JPanel {
    private FlatSlider workerSpeedSlider;

    public WorkerSpeedSlider(String worker) {
        this.initialize(worker);
    }

    private void initialize(String worker) {
        String workerSpeed = worker + " Speed";

        this.workerSpeedSlider = new FlatSlider();
        this.workerSpeedSlider.setMinimum(1);
        this.workerSpeedSlider.setMaximum(5);
        this.workerSpeedSlider.setMajorTickSpacing(2);
        this.workerSpeedSlider.setMinorTickSpacing(1);
        this.workerSpeedSlider.setValue(1);
        this.workerSpeedSlider.setPaintTicks(true);
        this.workerSpeedSlider.setPaintLabels(true);
        this.workerSpeedSlider.setSnapToTicks(true);
        this.workerSpeedSlider.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.workerSpeedSlider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.workerSpeedSlider.setBorder(ViewUtils.createCustomTitledBorder(workerSpeed, false));

        this.add(this.workerSpeedSlider);
    }

    public FlatSlider getWorkerSpeedSlider() {
        return this.workerSpeedSlider;
    }
}