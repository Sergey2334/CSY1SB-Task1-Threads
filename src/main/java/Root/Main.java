package Root;

import Root.Controller.SupplyChainManager;
import Root.View.MainWindow.MainWindow;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.extras.FlatInspector;
import com.formdev.flatlaf.extras.FlatUIDefaultsInspector;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World :D");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        FlatLaf.registerCustomDefaultsSource("themes");
        FlatDarkLaf.setup();

        // Install the inspector windows explicitly
        FlatInspector.install("ctrl shift alt X");
        FlatUIDefaultsInspector.install("ctrl shift alt Y");


//        FlatOneDarkIJTheme.setup();
//        FlatMTAtomOneDarkIJTheme.setup();
//        FlatMTMaterialPalenightIJTheme.setup();
//        FlatNordIJTheme.setup();
//        FlatSpacegrayIJTheme.setup();
//        FlatDarkPurpleIJTheme.setup();
//
        SwingUtilities.invokeLater(() -> {
            SupplyChainManager supplyChainManager = new SupplyChainManager();
            Thread supplyChainThread = new Thread(supplyChainManager);
//            supplyChainThread.start();
            MainWindow window = new MainWindow();
        });
    }
}