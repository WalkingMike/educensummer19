import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class Calculator extends JPanel implements ActionListener{

    private JTextField display = new JTextField("0");
    private double result = 0;
    private char operator = '=';
    private boolean calculating = true;

    Calculator(){
        setLayout(new BorderLayout());
        display.setEditable(false);
        add(display, "North");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5));
        char[] buttons = {'7', '8', '9', '+', 'C', '4', '5', '6', '-', ' ',
                          '1', '2', '3', '*', ' ', '0', '.', '=', '/', ' '};
        for (int i = 0; i < buttons.length; i++) {
            JButton b = new JButton(String.valueOf(buttons[i]));
            panel.add(b);
            b.addActionListener(this);
        }
        add(panel, "Center");
    }

    public void actionPerformed(ActionEvent evt){
        String command = evt.getActionCommand();
        if (!command.equals(" ")) {
            if (command.equals("C")) {
                display.setText("0");
                calculating = true;
            } else if ('0' <= command.charAt(0) && command.charAt(0) <= '9'
                       || (command.equals(".") && !display.getText().contains("."))){
                if (calculating)
                    display.setText(command);
                else
                    display.setText(display.getText() + command);
                calculating = false;
            } else {
                if (calculating){
                    if (command.equals("-")) {
                        display.setText(command);
                        calculating = false;
                    } else
                        operator = command.charAt(0);
                } else {
                    double x = Double.parseDouble(display.getText());
                    calculate(x);
                    operator = command.charAt(0);
                    calculating = true;
                }
            }
        }
    }

    private void calculate(double n){
        switch(operator){
            case '+': result += n; break;
            case '-': result -= n; break;
            case '*': result *= n; break;
            case '/': result /= n; break;
            case '=': result = n;
        }
        display.setText("" + result);
    }

    public void run(){
        JFrame frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        Container contentPane = frame.getContentPane();
        contentPane.add(new Calculator());
        frame.setVisible(true);
    }
}
