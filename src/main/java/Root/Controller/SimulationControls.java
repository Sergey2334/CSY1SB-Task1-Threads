package Root.Controller;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class SimulationControls {
    private SupplyChainManager supplyChainManager;

    public SimulationControls(SupplyChainManager supplyChainManager) {
        this.supplyChainManager = supplyChainManager;
    }


    // ADD_RESET_SUB Panel
    public ActionListener getAddCapacityAction() {
        return (e) -> {
            this.supplyChainManager.addMaxCapacity();
        };
    }

    public ActionListener getResetCapacityAction() {
        return (e) -> {
            this.supplyChainManager.resetCapacity();
        };
    }

    public ActionListener getSubResetAction() {
        return (e) -> {
            this.supplyChainManager.subMaxCapacity();
        };
    }

    // SLIDER Panel
    public ActionListener getAddFarmerAction() {
        return (e) -> {
            this.supplyChainManager.addFarmer();
        };
    }

    public ActionListener getAddDriverAction() {
        return (e) -> {
            this.supplyChainManager.addDriver();
        };
    }

    public ActionListener getSubFarmerAction() {
        return (e) -> {
            this.supplyChainManager.subFarmer();
        };
    }

    public ActionListener getSubDriverAction() {
        return (e) -> {
            this.supplyChainManager.subDriver();
        };
    }

    public ChangeListener getFarmerSpeedAction() {
        return e -> {
            // Cast the event source to get the current integer value of the slider
            JSlider source = (JSlider) e.getSource();

            // Prevent calculation spam while the user is actively dragging the knob
            if (!source.getValueIsAdjusting()) {
                int value = source.getValue();
                this.supplyChainManager.setFarmerSpeedMultiplier(value);
            }
        };
    }

    public ChangeListener getDriverSpeedAction() {
        return e -> {
            // Cast the event source to get the current integer value of the slider
            JSlider source = (JSlider) e.getSource();

            // Prevent calculation spam while the user is actively dragging the knob
            if (!source.getValueIsAdjusting()) {
                int value = source.getValue();
                this.supplyChainManager.setDriverSpeedMultiplier(value);
            }
        };
    }

    // STRAT_PAUSE/RESUME Panel
    public ActionListener getStartAction() {
        return (e) -> {
            this.supplyChainManager.setStarted();
        };
    }

    public ActionListener getTogglePauseAction() {
        return (e) -> {
            this.supplyChainManager.togglePaused();
        };
    }
}