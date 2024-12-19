import com.sun.jdi.FloatValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {

    float current = 0f;
    float first = 0f;
    String lastOperation = "";
    String currentStr = "";

    UI() {
        JFrame frame = new JFrame("Калькулятор");
        frame.setSize(300, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(66, 66, 66, 100));
        frame.setLayout(null);

        JTextField mainField = new JTextField(currentStr);
        mainField.setBounds(0,0,280, 70);
        mainField.setFont(new Font("Dialog", Font.BOLD, 50));
        mainField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        mainField.setBackground(Color.DARK_GRAY);
        mainField.setForeground(Color.GREEN);
        frame.add(mainField);

        JPanel panel = new JPanel(new GridLayout(4,4,4,4));
        panel.setBackground(new Color(66, 66, 66));
        panel.setBounds(0, 70, 280, 310);
        frame.add(panel);

        JButton button1 = new JButton("1");
        button1.setForeground(Color.black);
        button1.setBackground(new Color(214, 255, 238));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "1";
                mainField.setText(currentStr);
            }
        });
        panel.add(button1);

        JButton button2 = new JButton("2");
        button2.setForeground(Color.black);
        button2.setBackground(new Color(214, 255, 238));
        button2.setBounds(80, 70, 60, 50);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "2";
                mainField.setText(currentStr);
            }
        });
        panel.add(button2);

        JButton button3 = new JButton("3");
        button3.setForeground(Color.black);
        button3.setBackground(new Color(214, 255, 238));
        button3.setBounds(150, 70, 60, 50);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "3";
                mainField.setText(currentStr);
            }
        });
        panel.add(button3);

        JButton button4 = new JButton("C");
        button4.setForeground(Color.black);
        button4.setBackground(new Color(255, 0, 0));
        button4.setBounds(10, 130, 60, 50);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = 0f;
                currentStr = "";
                mainField.setText(currentStr);
            }
        });
        panel.add(button4);

        JButton button5 = new JButton("4");
        button5.setForeground(Color.black);
        button5.setBackground(new Color(214, 255, 238));
        button5.setBounds(80, 130, 60, 50);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "4";
                mainField.setText(currentStr);
            }
        });
        panel.add(button5);

        JButton button6 = new JButton("5");
        button6.setForeground(Color.black);
        button6.setBackground(new Color(214, 255, 238));
        button6.setBounds(150, 130, 60, 50);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "5";
                mainField.setText(currentStr);
            }
        });
        panel.add(button6);

        JButton button7 = new JButton("6");
        button7.setForeground(Color.black);
        button7.setBackground(new Color(214, 255, 238));
        button7.setBounds(10, 190, 60, 50);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "6";
                mainField.setText(currentStr);
            }
        });
        panel.add(button7);

        JButton button8 = new JButton("*");
        button8.setForeground(Color.black);
        button8.setBackground(new Color(0, 255, 255));
        button8.setBounds(80, 190, 60, 50);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr = "";
                first = Float.valueOf(mainField.getText());
                lastOperation = "*";
                mainField.setText(currentStr);
            }
        });
        panel.add(button8);

        JButton button9 = new JButton("7");
        button9.setBackground(new Color(214, 255, 238));
        button9.setForeground(Color.black);
        button9.setBounds(150, 190, 60, 50);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "7";
                mainField.setText(currentStr);
            }
        });
        panel.add(button9);

        JButton button0 = new JButton("8");
        button0.setForeground(Color.black);
        button0.setBackground(new Color(214, 255, 238));
        button0.setBounds(10, 250, 60, 50);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "8";
                mainField.setText(currentStr);
            }
        });
        panel.add(button0);

        JButton button10 = new JButton("9");
        button10.setForeground(Color.black);
        button10.setBackground(new Color(214, 255, 238));
        button10.setBounds(80, 250, 130, 50);
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "9";
                mainField.setText(currentStr);
            }
        });
        panel.add(button10);

        JButton button11 = new JButton("/");
        button11.setForeground(Color.black);
        button11.setBackground(new Color(0, 255, 255));
        button11.setBounds(220, 70, 60, 50);
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr = "";
                first = Float.valueOf(mainField.getText());
                lastOperation = "/";
                mainField.setText(currentStr);
            }
        });
        panel.add(button11);

        JButton button12 = new JButton("0");
        button12.setForeground(Color.black);
        button12.setBackground(new Color(214, 255, 238));
        button12.setBounds(220, 130, 60, 50);
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr += "0";
                mainField.setText(currentStr);
            }
        });
        panel.add(button12);

        JButton button13 = new JButton("+");
        button13.setForeground(Color.black);
        button13.setBackground(new Color(0, 255, 255));
        button13.setBounds(220, 190, 60, 50);
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr = "";
                first = Float.valueOf(mainField.getText());
                lastOperation = "+";
                mainField.setText(currentStr);
            }
        });
        panel.add(button13);

        JButton button14 = new JButton("-");
        button14.setForeground(Color.black);
        button14.setBackground(new Color(0, 255, 255));
        button14.setBounds(220, 250, 60, 25);
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStr = "";
                first = Float.valueOf(mainField.getText());
                lastOperation = "-";
                mainField.setText(currentStr);
            }
        });
        panel.add(button14);

        JButton button15 = new JButton("=");
        button15.setForeground(Color.white);
        button15.setBackground(new Color(1, 50, 116));
        button15.setBounds(220, 275, 60, 25);
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float second = Float.valueOf(mainField.getText());
                if(lastOperation.equals("+")){
                    current = first + second;
                }
                if(lastOperation.equals("-")){
                    current = first - second;
                }
                if(lastOperation.equals("*")){
                    current = first * second;
                }
                if(lastOperation.equals("/")){
                    current = first / second;
                }
                currentStr = String.valueOf(current);
                mainField.setText(currentStr);
            }
        });
        panel.add(button15);

        frame.setVisible(true);

    }



}