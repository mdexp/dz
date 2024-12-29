import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI2 extends JFrame {
    public UI2() {
        setTitle("UI2");
        setSize(900, 990);
        setLayout(null);

        Slider slider = new Slider(300, 100, 5);
        slider.setBounds(100, 200, 300, 100);
        add(slider);
        Slider slider1 = new Slider(600, 400, 9);
        slider1.setBounds(100, 350, slider1.getWidth(), slider1.getHeight());
        add(slider1);

        JButton button = new JButton("Reset slider_1");
        button.setBounds(100, 100, 200, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slider.resetSlider();
            }
        });
        add(button);
        slider.setButton(button);

        JButton button1 = new JButton("Reset slider_2");
        button1.setBounds(300, 100, 200, 50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slider1.resetSlider();
            }
        });
        add(button1);
        slider1.setButton(button1);




        setVisible(true);

    }
}
