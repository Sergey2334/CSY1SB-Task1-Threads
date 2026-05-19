package Root;

import Root.Controller.SupplyChainManager;
import Root.View.MainWindow;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World :D");


        SupplyChainManager supplyChainManager = new SupplyChainManager();
        Thread supplyChainThread = new Thread(supplyChainManager);
        supplyChainThread.start();
        MainWindow window = new MainWindow(supplyChainManager);
    }
}