import javax.swing.*;

public class UI extends JFrame {
    public UI() {
        setSize(1000, 700);
        setLayout(null);


        JButton button1 = new MyImage("src/sd.png");
        button1.setBounds(100, 200, 100, 120);
        add(button1);


        JButton button2 = new MyImage("src/sd2.png");
        button2.setBounds(300, 200, 100, 120);
        add(button2);

        JButton button3 = new MyImage("src/sd3.png");
        button3.setBounds(500, 200, 100, 120);
        add(button3);

        JButton button4 = new MyImage("src/sd4.png");
        button4.setBounds(700, 200, 100, 120);
        add(button4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

