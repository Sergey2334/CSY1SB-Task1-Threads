package MainWindow;

import javax.swing.*;
import java.awt.*;

public class SimulationControlsArea extends JPanel {
    public SimulationControlsArea() {
        this.setLayout(new FlowLayout());
        this.setOpaque(true);
        this.setBackground(Color.CYAN);
        this.setForeground(Color.WHITE);

        this.createUIComponents();
    }

    private void createUIComponents() {
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
    }
}
