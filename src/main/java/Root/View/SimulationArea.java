//package MainWindow;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.List;
//
//public class SimulationArea extends JPanel {
//    private JTextArea warehouseDisplay;
//    private JTextArea farmersDisplay;
//    private JTextArea driversDisplay;
//
//    public SimulationArea() {
//        this.setLayout(new GridBagLayout());
//        this.setBackground(Color.LIGHT_GRAY);
//
//        this.createUIComponents();
//    }
//
//    private void createUIComponents() {
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.weighty = 1.0;
//        gbc.insets = new Insets(10, 10, 10, 10);
//
//        // 1. Warehouse Column
//        gbc.weightx = 0.4;
//        gbc.gridx = 0;
//        warehouseDisplay = createDisplayArea("Warehouse Status", Color.GREEN);
//        this.add(new JScrollPane(warehouseDisplay), gbc);
//
//        // 2. Farmers Column
//        gbc.weightx = 0.3;
//        gbc.gridx = 1;
//        farmersDisplay = createDisplayArea("Active Farmers", Color.ORANGE);
//        this.add(new JScrollPane(farmersDisplay), gbc);
//
//        // 3. Drivers Column
//        gbc.weightx = 0.3;
//        gbc.gridx = 2;
//        driversDisplay = createDisplayArea("Active Drivers", Color.BLUE);
//        this.add(new JScrollPane(driversDisplay), gbc);
//    }
//
//    private JTextArea createDisplayArea(String title, Color bg) {
//        JTextArea area = new JTextArea();
//        area.setEditable(false);
//        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
//        area.setBackground(bg);
//        area.setForeground(Color.BLACK);
//        area.setBorder(BorderFactory.createTitledBorder(title));
//        return area;
//    }
//
//    /**
//     * This method will be safely called by our Swing Timer on the EDT thread
//     * to update the text views with live engine data.
//     */
//    public void updateView(Warehouse warehouse, List<?> farmers, List<?> drivers) {
//        // Update Warehouse
//        warehouseDisplay.setText(warehouse.toString());
//
//        // Update Farmers List
//        StringBuilder farmersText = new StringBuilder();
//        for (Object farmer : farmers) {
//            farmersText.append(farmer.toString()).append("\n");
//        }
//        farmersDisplay.setText(farmersText.toString());
//
//        // Update Drivers List
//        StringBuilder driversText = new StringBuilder();
//        for (Object driver : drivers) {
//            driversText.append(driver.toString()).append("\n");
//        }
//        driversDisplay.setText(driversText.toString());
//    }
//}