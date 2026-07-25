import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {

    TextField t1, t2;
    Label result;
    Button add, sub, mul, div, clear;

    SimpleCalculator() {
        setTitle("Simple Calculator");
        setLayout(new FlowLayout());

        t1 = new TextField(10);
        t2 = new TextField(10);

        add = new Button("Add");
        sub = new Button("Subtract");
        mul = new Button("Multiply");
        div = new Button("Divide");
        clear = new Button("Clear");

        result = new Label("Result : ");

        add(new Label("First Number"));
        add(t1);
        add(new Label("Second Number"));
        add(t2);

        add(add);
        add(sub);
        add(mul);
        add(div);
        add(clear);

        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(300, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {
            t1.setText("");
            t2.setText("");
            result.setText("Result : ");
            return;
        }

        try {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            double r = 0;

            if (e.getSource() == add)
                r = a + b;
            else if (e.getSource() == sub)
                r = a - b;
            else if (e.getSource() == mul)
                r = a * b;
            else if (e.getSource() == div) {
                if (b == 0) {
                    result.setText("Result : Cannot divide by zero");
                    return;
                }
                r = a / b;
            }

            result.setText("Result : " + r);

        } catch (NumberFormatException ex) {
            result.setText("Result : Invalid Input");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
