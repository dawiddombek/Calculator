import javax.swing.*;
import java.awt.*;

public class CalculatorButtons extends JButton {

    CalculatorButtons(String buttonName) {
        this.setText(buttonName);
        this.setFocusable(false);
        this.setFont(new Font("", Font.PLAIN, 25));
    }
}
