import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JLabel label;
    private JButton button;


    public View() {

        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);


        label = new JLabel("PRICE");
        label.setBounds(60, 0, 300, 100);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.BOLD, 60));
        add(label);


        button = new JButton("GET");
        button.setBounds(50, 175, 200, 70);
        button.setForeground(Color.GREEN);
        button.setBackground(Color.WHITE);
        add(button);


        setVisible(true);
    }


    public void setActionListener(ActionListener listener) {

        button.addActionListener(listener);
    }
    public void setText(String text) {
        label.setText(text);
    }
}

