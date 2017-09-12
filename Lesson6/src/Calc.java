import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.lang.reflect.Proxy;
import java.lang.*;


public class Calc extends JFrame {

    public Calc() {
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();

        add(panel);
        pack();

    }
}


class CalculatorPanel extends JPanel{


    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
    private ICalculator calc1;



    public CalculatorPanel() {


        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start=true;

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);

        Cl calc = new Cl();

        InHandler inHandler = new InHandler(calc);
        calc1 = (ICalculator) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{ICalculator.class},
                inHandler);

    }
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }
    private class InsertAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if(start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }
    private class CommandAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            Double previousValue;
            String command = event.getActionCommand();
            if(start)
            {
                if(command.equals("-"))
                {
                    display.setText(command);
                    start = false;
                }
                else lastCommand = command;
            }
            else
            {

                previousValue = result;
                result = calc1.calculate(Double.parseDouble(display.getText()), lastCommand, previousValue);
                display.setText("" + result);
                lastCommand = command;
                start=true;
            }
        }
    }
}


class Cl implements ICalculator{

    public Double calculate(double x, String lastCommand, double result)
    {
        if(lastCommand.equals("+")) {
            result += x;
        }
        else if(lastCommand.equals("-")) {
            result -= x;
        }
        else if(lastCommand.equals("*")) {
            result *= x;
        }
        else if(lastCommand.equals("/")) {

            result /= x;
        }
        else if(lastCommand.equals("=")) {
            result = x;
        }

        return result;
    }

}

