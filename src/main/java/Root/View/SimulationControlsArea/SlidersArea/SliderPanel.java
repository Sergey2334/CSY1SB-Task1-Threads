package Root.View.SimulationControlsArea.SlidersArea;

import Root.View.SimulationControlsArea.ControlsUtills.SimulationControlButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class SliderPanel extends JPanel {
    private WorkerSpeedSlider farmerSpeedSlider;
    private WorkerSpeedSlider driverSpeedSlider;
    private SimulationControlButton addFarmerButton;
    private SimulationControlButton subFarmerButton;
    private SimulationControlButton addDriverButton;
    private SimulationControlButton subDriverButton;

    public SliderPanel() {
        this.initialize();
        this.initializeComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout("wrap 3, fill , align center"));
    }

    private void initializeComponents() {
        this.farmerSpeedSlider = new WorkerSpeedSlider("Framer");
        this.addFarmerButton = new SimulationControlButton("ADD Farmer");
        this.subFarmerButton = new SimulationControlButton("SUB Farmer");

        this.driverSpeedSlider = new WorkerSpeedSlider("Driver");
        this.addDriverButton = new SimulationControlButton("ADD Driver");
        this.subDriverButton = new SimulationControlButton("SUB Driver");

        this.add(this.farmerSpeedSlider);
        this.add(this.addFarmerButton);
        this.add(this.subFarmerButton);

        this.add(this.driverSpeedSlider);
        this.add(this.addDriverButton);
        this.add(this.subDriverButton);
    }

    public void addFarmer(ActionListener actionListener) {
        this.addFarmerButton.addActionListener(actionListener);
    }

    public void subFarmer(ActionListener actionListener) {
        this.subFarmerButton.addActionListener(actionListener);
    }

    public void addDriver(ActionListener actionListener) {
        this.addDriverButton.addActionListener(actionListener);
    }

    public void subDriver(ActionListener actionListener) {
        this.subDriverButton.addActionListener(actionListener);
    }

    public void onFarmerSpeedChanged(ChangeListener changeListener) {
        this.farmerSpeedSlider.getWorkerSpeedSlider().addChangeListener(changeListener);
    }

    public void onDriverSpeedChanged(ChangeListener changeListener) {
        this.driverSpeedSlider.getWorkerSpeedSlider().addChangeListener(changeListener);
    }
}
