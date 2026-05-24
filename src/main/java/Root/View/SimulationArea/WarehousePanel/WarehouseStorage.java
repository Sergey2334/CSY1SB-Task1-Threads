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
//        this.storageProgressBar.setForeground(Constants.ORANGE_COLOR.darker());
        this.storageProgressBar.setOpaque(false);
        this.add(this.storageProgressBar, "push x, push y, grow y, align right");
    }

    public void setOrangesAmount(int orangesAmount) {
        this.orangesAmount = orangesAmount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ViewUtills.drawOranges(g, this, this.orangesAmount, Constants.ORANGE_COLOR);
        this.storageProgressBar.setValue(orangesAmount);
    }
}