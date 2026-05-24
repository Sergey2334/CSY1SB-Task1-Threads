package Root.View.SimulationControlsArea.SlidersArea;

import Root.View.ViewUtills.ViewUtils;
import com.formdev.flatlaf.extras.components.FlatSlider;

import javax.swing.*;
import java.awt.*;

public class WorkerSpeedSlider extends JPanel {
    public WorkerSpeedSlider(String worker) {
        this.initialize(worker);
    }

    private void initialize(String worker) {
        String workerSpeed = worker + " Speed";

        FlatSlider f = new FlatSlider();
        f.setMinimum(0);
        f.setMaximum(100);
        f.setMajorTickSpacing(10);
        f.setMinorTickSpacing(5);
        f.setPaintTicks(true);
        f.setPaintLabels(true);
        f.setSnapToTicks(true);
        f.setCursor(new Cursor(Cursor.HAND_CURSOR));
        f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        f.setBorder(ViewUtils.createCustomTitledBorder(workerSpeed, false));

        this.add(f);
    }

}