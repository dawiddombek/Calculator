import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {

    JTextField display;

    JPanel panel;

    CalculatorButtons[] numberButtons = new CalculatorButtons[10];

    CalculatorButtons addButton, subButton, mulButton, divButton, equalsButton, decButton, delButton, clrButton;

    float firstNumber = 0, secondNumber = 0, result = 0;

    char sign = ' ';

    CalculatorFrame() {

        ImageIcon icon = new ImageIcon("src/resources/calculatorIcon.png");

        //Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(315, 500);
        this.getContentPane().setBackground(Color.lightGray);
        this.setIconImage(icon.getImage());

        //display - Textfield
        display = new JTextField("0");
        display.setBounds(25,25,250, 50);
        display.setPreferredSize(new Dimension(250, 50));
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("", Font.PLAIN, 32));
        this.add(display);

        //Buttons panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setBounds(25, 100, 250, 250);
        panel.setBackground(Color.lightGray);

        //initialization of buttons + adding buttons to panel
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new CalculatorButtons(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        addButton = new CalculatorButtons("+");
        subButton = new CalculatorButtons("-");
        mulButton = new CalculatorButtons("*");
        divButton = new CalculatorButtons("/");
        equalsButton = new CalculatorButtons("=");
        decButton = new CalculatorButtons(".");
        delButton = new CalculatorButtons("Del");
        clrButton = new CalculatorButtons("Clr");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalsButton.addActionListener(this);
        decButton.addActionListener(this);
        delButton.addActionListener(this);
        clrButton.addActionListener(this);

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

    public float mathOperations(float firstNumber, float secondNumber, char sign) {
        switch (sign) {
            case '+':
                this.sign = '+';
                return firstNumber + secondNumber;
            case '-':
                this.sign = '-';
                return firstNumber - secondNumber;
            case '*':
                this.sign = '*';
                return firstNumber * secondNumber;
            case '/':
                this.sign = '/';
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO implement logic to all buttons
        //numbers buttons
        if(e.getSource() == numberButtons[0] && !display.getText().equals("0")) {
                display.setText(display.getText() + "0");
        }
        for(int i = 1; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                if(sign == '=') {
                    result = 0;
                    display.setText(String.valueOf(i));
                    sign = ' ';
                }
                else if(display.getText().equals("0")) {
                    display.setText(String.valueOf(i));
                }
                else {
                    display.setText(display.getText() + String.valueOf(i));
                }
            }
        }
        //decimal button
        if(e.getSource() == decButton && !display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
        //clear button
        if(e.getSource() == clrButton) {
            display.setText("0");
        }
        //delete button
        if(e.getSource() == delButton) {
            if(display.getText().length() == 1) {
                display.setText("0");
            }
            else {
                display.setText(display.getText().substring(0, display.getText().length() - 1));
            }
        }
        //adding button
        if(e.getSource() == addButton) {
            if(sign == ' ') {
                result = mathOperations(result, Float.parseFloat(display.getText()), '+');
            }
            else {
                result = mathOperations(result, Float.parseFloat(display.getText()), sign);
            }
            display.setText("0");
            sign = '+';
        }
        //subtraction button
        if(e.getSource() == subButton) {
            if(sign == ' ') {
                result = mathOperations(result, Float.parseFloat(display.getText()), '+');
            }
            else {
                result = mathOperations(result, Float.parseFloat(display.getText()), sign);
            }
            display.setText("0");
            sign = '-';
        }
        //multiplication button
        if(e.getSource() == mulButton) {
            if(sign == ' ') {
                result = mathOperations(result, Float.parseFloat(display.getText()), '+');
            }
            else {
                result = mathOperations(result, Float.parseFloat(display.getText()), sign);
            }
            display.setText("0");
            sign = '*';
        }
        //division button
        if(e.getSource() == divButton) {
            if(sign == ' ') {
                result = mathOperations(result, Float.parseFloat(display.getText()), '+');
            }
            else {
                result = mathOperations(result, Float.parseFloat(display.getText()), sign);
            }
            display.setText("0");
            sign = '/';
        }
        //equals button
        if(e.getSource() == equalsButton) {
            result = mathOperations(result, Float.parseFloat(display.getText()), sign);
            display.setText(String.valueOf(result));
            sign = '=';
        }
    }
}
