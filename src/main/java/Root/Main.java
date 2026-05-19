package Root;

import Root.Controller.SupplyChainManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World :D");

//        MainWindow window = new MainWindow();

        SupplyChainManager supplyChainManager = new SupplyChainManager();
        Thread supplyChainThread = new Thread(supplyChainManager);
        supplyChainThread.start();
    }
}