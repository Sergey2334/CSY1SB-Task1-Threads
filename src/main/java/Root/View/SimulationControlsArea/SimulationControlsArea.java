package Root.View.SimulationControlsArea;

import Root.Controller.SimulationControls;
import Root.Controller.SupplyChainManager;
import Root.View.SimulationControlsArea.AddSubResetArea.AddSubResetPanel;
import Root.View.SimulationControlsArea.SlidersArea.SliderPanel;
import Root.View.SimulationControlsArea.StartPauseResumeArea.StartPauseResumePanel;
import Root.View.ViewUtills.ViewUtils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SimulationControlsArea extends JPanel {
    private SliderPanel sliderPanel;
    private AddSubResetPanel addSubResetPanel;
    private StartPauseResumePanel startPauseResumePanel;

    private SimulationControls simulationControls;

    public SimulationControlsArea(SupplyChainManager supplyChainManager) {
        this.initialize();
        this.initializeComponents(supplyChainManager);

        this.bindControls();
    }

    private void initialize() {
        // 1. "fill" stretches the whole grid vertically and horizontally
        String layoutConstraints = "fill, insets 0";

        // 2. Lock columns into exact proportions: 35%, 30%, 35%
        String columnConstraints = "[35%, align center, grow][30%, align center, grow][35%, align center, grow]";

        // 3. Stretches the row vertically to fill the full height
        String rowConstraints = "[align center]";

        this.setLayout(new MigLayout(layoutConstraints, columnConstraints, rowConstraints));
    }

    private void initializeComponents(SupplyChainManager supplyChainManager) {
        this.setBorder(ViewUtils.createCustomTitledBorder("SIMULATION CONTROLS", true));

        this.sliderPanel = new SliderPanel();
        this.addSubResetPanel = new AddSubResetPanel();
        this.startPauseResumePanel = new StartPauseResumePanel();

        this.add(this.sliderPanel);
        this.add(this.addSubResetPanel);
        this.add(this.startPauseResumePanel);

        this.simulationControls = new SimulationControls(supplyChainManager);
    }

    private void bindControls() {
        this.addSubResetPanel.addCapacity(this.simulationControls.getAddCapacityAction());
        this.addSubResetPanel.resetCapacity(this.simulationControls.getResetCapacityAction());
        this.addSubResetPanel.subCapacity(this.simulationControls.getSubResetAction());

        this.sliderPanel.onFarmerSpeedChanged(this.simulationControls.getFarmerSpeedAction());
        this.sliderPanel.addFarmer(this.simulationControls.getAddFarmerAction());
        this.sliderPanel.subFarmer(this.simulationControls.getSubFarmerAction());
        this.sliderPanel.onDriverSpeedChanged(this.simulationControls.getDriverSpeedAction());
        this.sliderPanel.addDriver(this.simulationControls.getAddDriverAction());
        this.sliderPanel.subDriver(this.simulationControls.getSubDriverAction());

        this.startPauseResumePanel.start(this.simulationControls.getStartAction());
        this.startPauseResumePanel.togglePause(this.simulationControls.getTogglePauseAction());
    }
}