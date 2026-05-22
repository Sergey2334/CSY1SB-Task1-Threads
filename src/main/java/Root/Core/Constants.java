package Root.Core;

public final class Constants {
    private Constants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static final int WAREHOUSE_START_MAX_CAPACITY = 10;
    public static final int WORKERS_AMOUNT_START = 5;

    public static final int FARMER_MIN_PICKING_TIME = 1 * 1000;
    public static final int FARMER_MAX_PICKING_TIME = 3 * 1000;

    public static final int DRIVER_MIN_DRIVE_TIME = 2 * 1000;
    public static final int DRIVER_MAX_DRIVE_TIME = 3 * 1000;

    public static final int MAX_IDLE_TIME_BEFORE_FIRE = 2 * 1000;

    public static final String coolFont1 = "Trebuchet MS";
}
