package Root.View.ViewUtills;

import Root.Core.Constants;
import com.formdev.flatlaf.ui.FlatLineBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public final class ViewUtills {
    private ViewUtills() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Border createCustomTitledBorder(String title, boolean isBorderVisible) {
        int borderThickness = 0;
        if (isBorderVisible) {
            borderThickness = 1;
        }
        FlatLineBorder flatLineBorder = new FlatLineBorder(new Insets(1, 1, 1, 1), Color.GRAY, borderThickness, 16);
        Border result = BorderFactory.createTitledBorder(flatLineBorder,
                title,
                2,
                2,
                new Font(Constants.coolFont1, Font.BOLD, 16),
                Color.WHITE);

        return result;
    }
}
