import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {

    JTextField display;

    JPanel panel;

    CalculatorButtons[] numberButtons = new CalculatorButtons[10];

    CalculatorButtons addButton, subButton, mulButton, divButton, equalsButton, decButton, delButton, clrButton;

    CalculatorFrame() {

        //Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(315, 500);

        //display - Textfield
        display = new JTextField();
        display.setBounds(25,25,250, 50);
        display.setPreferredSize(new Dimension(250, 50));
        display.setEditable(false);
        this.add(display);

        //Buttons panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setBounds(25, 100, 250, 250);

        //initialization of buttons + adding buttons to panel
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new CalculatorButtons(String.valueOf(i));
        }

        addButton = new CalculatorButtons("+");
        subButton = new CalculatorButtons("-");
        mulButton = new CalculatorButtons("*");
        divButton = new CalculatorButtons("/");
        equalsButton = new CalculatorButtons("=");
        decButton = new CalculatorButtons(".");
        delButton = new CalculatorButtons("Del");
        clrButton = new CalculatorButtons("Clr");

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divButton);

        delButton.setBounds(25, 375, 125, 50);
        clrButton.setBounds(150, 375, 125, 50);
        this.add(delButton);
        this.add(clrButton);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO implement logic to all buttons
    }
}
