package Root.View;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import Root.Controller.SupplyChainManager;
import Root.Model.Warehouse;
import Root.Model.Farmer;
import Root.Model.Driver;

public class MainWindow extends JFrame {
    private SimulationArea simulationArea;
    private SimulationControlsArea controlsArea;
    private SupplyChainManager engine;
    private javax.swing.Timer uiRefreshTimer;

    public MainWindow(SupplyChainManager engine) {
        this.engine = engine;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Custom Graphics Engine Simulator");
        this.setSize(1200, 600);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.controlsArea = new SimulationControlsArea();
        this.simulationArea = new SimulationArea();

        this.add(this.controlsArea, BorderLayout.SOUTH);
        this.add(this.simulationArea, BorderLayout.CENTER);

        this.setupControlActions();
        this.startLiveRefreshClock();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setupControlActions() {
        this.controlsArea.getAddFarmerBtn().addActionListener(e -> {
            this.engine.getFarmersManager().addWorker();
        });

        this.controlsArea.getAddDriverBtn().addActionListener(e -> {
            this.engine.getDriversManager().addWorker();
        });
    }

    private void startLiveRefreshClock() {
        this.uiRefreshTimer = new javax.swing.Timer(50, e -> { // Spun up to 50ms for hyper-smooth renders
            Warehouse wh = this.engine.getWarehouse();
            LinkedList<Farmer> farmers = this.engine.getFarmersManager().getWorkers();
            LinkedList<Driver> drivers = this.engine.getDriversManager().getWorkers();

            // Fire data down into our custom Java2D engine repainter
            this.simulationArea.updateEngineSnapshot(wh, farmers, drivers);
        });
        this.uiRefreshTimer.start();
    }
}