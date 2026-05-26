package Root.Core;

import java.awt.*;

public final class Constants {
    private Constants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static final int WAREHOUSE_START_MAX_CAPACITY = 10;
    public static final int WORKERS_AMOUNT_START = 5; // BIG NUMBERS (1000+) MAY CAUSE CRASHES !!!

    public static final int FARMER_MIN_PICKING_TIME = 1 * 1000;
    public static final int FARMER_MAX_PICKING_TIME = 3 * 1000;

    public static final int DRIVER_MIN_DRIVE_TIME = 2 * 1000;
    public static final int DRIVER_MAX_DRIVE_TIME = 3 * 1000;

    public static final int MAX_IDLE_TIME_BEFORE_FIRE = 2 * 1000;

    public static final String COOL_FONT1_STRING = "Trebuchet MS";
    public static final Font COOL_FONT1 = new Font(COOL_FONT1_STRING, Font.BOLD, 20);
    public static final Font COOL_FONT1_WORKER = new Font(COOL_FONT1_STRING, Font.BOLD, 10);

    public static final Color FARMER_COLOR = new Color(31, 241, 66, 255);
    public static final Color DRIVER_COLOR = new Color(31, 130, 241, 255);
    public static final Color ORANGE_COLOR = Color.ORANGE;
    public static final Color HALO_COLOR = new Color(0, 0, 0, 69);
}