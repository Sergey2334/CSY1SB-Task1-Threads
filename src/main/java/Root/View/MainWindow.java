//package MainWindow;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class MainWindow extends JFrame {
//    private SimulationArea simulationArea;
//    private SimulationControlsArea controlsArea;
//    private SupplyChainManager engine;
//    private javax.swing.Timer uiRefreshTimer; // Safe EDT ticker clock
//
//    public MainWindow(SupplyChainManager engine) {
//        this.engine = engine;
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setTitle("Threads Problem Simulation Engine");
//        this.setSize(1200, 800);
//        this.setResizable(false);
//        this.setLayout(new BorderLayout());
//
//        this.controlsArea = new SimulationControlsArea();
//        this.simulationArea = new SimulationArea();
//
//        this.add(controlsArea, BorderLayout.SOUTH);
//        this.add(simulationArea, BorderLayout.CENTER);
//
//        this.setupControlActions();
//        this.startLiveRefreshClock();
//
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//    }
//
//    private void setupControlActions() {
//        // Map Button 1 to dynamically add a Farmer worker thread live!
//        controlsArea.getAddFarmerBtn().addActionListener(e -> {
//            engine.getFarmersManager().addWorker();
//        });
//
//        // Map Button 2 to dynamically add a Driver worker thread live!
//        controlsArea.getAddDriverBtn().addActionListener(e -> {
//            engine.getDriversManager().addWorker();
//        });
//    }
//
//    private void startLiveRefreshClock() {
//        // Runs cleanly on the Event Dispatch Thread (EDT) every 100ms
//        this.uiRefreshTimer = new javax.swing.Timer(100, e -> {
//            // Read data safely across threads using public getters
//            Warehouse wh = engine.getWarehouse();
//            java.util.List<?> farmers = engine.getFarmersManager().getWorkers();
//            java.util.List<?> drivers = engine.getDriversManager().getWorkers();
//
//            // Push snapshots smoothly to text panels
//            simulationArea.updateView(wh, farmers, drivers);
//        });
//
//        this.uiRefreshTimer.start();
//    }
//}