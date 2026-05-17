import MainWindow.MainWindow;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World :D");
        Random random = new Random();

//        MainWindow window = new MainWindow();

        Warehouse warehouse = new Warehouse();
        WarehouseManager warehouseManager = new WarehouseManager(warehouse);

        FarmersManager farmersManager = new FarmersManager(warehouseManager);
        DriversManager driversManager = new DriversManager(warehouseManager);

        Thread warehouseManagerThread = new Thread(warehouseManager);
        Thread farmersManagerThread = new Thread(farmersManager);
        Thread driversManagerThread = new Thread(driversManager);
        warehouseManagerThread.start();
        farmersManagerThread.start();
        driversManagerThread.start();
    }
}
