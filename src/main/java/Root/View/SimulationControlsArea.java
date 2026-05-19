package Root.View;

import javax.swing.*;
import java.awt.*;

public class SimulationControlsArea extends JPanel {
    private JButton addFarmerBtn;
    private JButton addDriverBtn;

    public SimulationControlsArea() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 15));
        this.setBackground(new Color(52, 58, 64)); // Darker matte gray dashboard panel
        this.createUIComponents();
    }

    private void createUIComponents() {
        this.addFarmerBtn = new JButton("Hire New Farmer (+)");
        this.addDriverBtn = new JButton("Hire New Driver (+)");

        // Add minimalist look adjustments
        configureButtonStyles(this.addFarmerBtn, new Color(40, 167, 69));
        configureButtonStyles(this.addDriverBtn, new Color(0, 123, 255));

        this.add(this.addFarmerBtn);
        this.add(this.addDriverBtn);
    }

    private void configureButtonStyles(JButton btn, Color bg) {
        btn.setPreferredSize(new Dimension(200, 40));
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
    }

    public JButton getAddFarmerBtn() { return this.addFarmerBtn; }
    public JButton getAddDriverBtn() { return this.addDriverBtn; }
}