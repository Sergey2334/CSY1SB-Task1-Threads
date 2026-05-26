package Root.View.SimulationControlsArea.AddSubResetArea;

import Root.View.SimulationControlsArea.ControlsUtills.SimulationControlButton;
import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AddSubResetPanel extends JPanel {
    private SimulationControlButton capSub;
    private SimulationControlButton capAdd;
    private SimulationControlButton resetCap;

    public AddSubResetPanel() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("fill , align center"));
    }

    private void initializeComponents() {
        this.capSub = new SimulationControlButton("SUB CAP");
        this.capSub.putClientProperty(FlatClientProperties.STYLE_CLASS, "remove");
        this.resetCap = new SimulationControlButton("RESET");
        this.resetCap.putClientProperty(FlatClientProperties.STYLE_CLASS, "reset");
        this.capAdd = new SimulationControlButton("ADD CAP");
        this.capAdd.putClientProperty(FlatClientProperties.STYLE_CLASS, "add");

        this.add(this.capSub, "grow, push");
        this.add(this.resetCap, "grow, push");
        this.add(this.capAdd, "grow, push");
    }

    public void addCapacity(ActionListener actionListener) {
        this.capAdd.addActionListener(actionListener);
    }

    public void resetCapacity(ActionListener actionListener) {
        this.resetCap.addActionListener(actionListener);
    }

    public void subCapacity(ActionListener actionListener) {
        this.capSub.addActionListener(actionListener);
    }
}
