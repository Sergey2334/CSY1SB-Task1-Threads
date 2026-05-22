package Root.View.SimulationArea.WarehousePanel;

import Root.Core.Constants;
import Root.Core.MyUtils;
import Root.View.ViewUtills.ViewUtills;
import com.formdev.flatlaf.extras.components.FlatProgressBar;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class WarehouseStorage extends JPanel {
    private int orangesAmount = 0;
    private FlatProgressBar storageProgressBar;

    public WarehouseStorage() {
        this.initialize();
        this.initComponents();
    }

    private void initialize() {
        this.setLayout(new MigLayout());
        this.setBorder(ViewUtills.createCustomTitledBorder("Warehouse Oranges", true));
    }

    private void initComponents() {
        this.storageProgressBar = new FlatProgressBar();
        this.storageProgressBar.setStringPainted(true);
        this.storageProgressBar.setMaximum(Constants.WAREHOUSE_START_MAX_CAPACITY);
        this.storageProgressBar.setValue(this.orangesAmount);
        this.storageProgressBar.setMinimum(0);
        this.storageProgressBar.setOrientation(FlatProgressBar.VERTICAL);
        this.storageProgressBar.setForeground(new Color(0, 0, 0, 0));
        this.storageProgressBar.setForeground(new Color(255, 137, 0, 157));
        this.storageProgressBar.setOpaque(false);
        this.add(this.storageProgressBar, "push x, push y, grow y, align right");
    }

    public void setOrangesAmount(int orangesAmount) {
        this.orangesAmount = orangesAmount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Setup layout constraints
        int orangeSize = 10;        // Diameter of each orange
        int spacing = 4;           // Space between oranges
        int leftMargin = 15;       // Push away from the left border
        int topMargin = 30;        // Push down past the title border text
        int rightMargin = 15;      // Stop before hitting the right border

        // 2. Calculate dynamic row capacity based on current panel width
        int availableWidth = this.getWidth() - leftMargin - rightMargin;
        int stepSize = orangeSize + spacing;
        int maxPerRow = availableWidth / stepSize;

        // Prevent division by zero if the panel is minimized very small
        if (maxPerRow <= 0) {
            maxPerRow = 1;
        }

//        g2d.setColor(Color.ORANGE);
        this.storageProgressBar.setValue(orangesAmount);

        // 3. Draw rows dynamically based on calculated maxPerRow
        for (int i = 0; i < this.orangesAmount; i++) {
            int column = i % maxPerRow;
            int row = i / maxPerRow;

            int x = leftMargin + (column * stepSize);
            int y = topMargin + (row * stepSize);

            Color haloColor = new Color(0, 0, 0, 69);
            g2d.setColor(haloColor);

            int haloSize = orangeSize + 4; // Makes the halo 4 pixels bigger than the orange
            g2d.fillOval(x - 2, y - 2, haloSize, haloSize);

            g2d.setColor(new Color(255, 232, 214, 200));
            g2d.drawOval(x, y, orangeSize, orangeSize);

            g2d.setColor(Color.ORANGE);
            g2d.fillOval(x, y, orangeSize, orangeSize);
        }
    }
}