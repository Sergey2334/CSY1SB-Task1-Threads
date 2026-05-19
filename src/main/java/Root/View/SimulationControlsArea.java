//package MainWindow;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class SimulationControlsArea extends JPanel {
//    private JButton addFarmerBtn;
//    private JButton fireFarmerBtn; // Optional/extra utility
//    private JButton addDriverBtn;
//    private JButton fireDriverBtn; // Optional/extra utility
//
//    public SimulationControlsArea() {
//        this.setLayout(new FlowLayout());
//        this.setBackground(Color.CYAN);
//
//        this.createUIComponents();
//    }
//
//    private void createUIComponents() {
//        addFarmerBtn = new JButton("Hire Farmer (+)");
//        addDriverBtn = new JButton("Hire Driver (+)");
//
//        this.add(addFarmerBtn);
//        this.add(addDriverBtn);
//    }
//
//    /**
//     * Exposes hook triggers so MainWindow can hook engine mutations to these clicks safely.
//     */
//    public JButton getAddFarmerBtn() { return addFarmerBtn; }
//    public JButton getAddDriverBtn() { return addDriverBtn; }
//}