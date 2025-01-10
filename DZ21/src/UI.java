import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {

    private JButton startBt = new JButton("Start");
    private JButton resetBt = new JButton("Reset");
    private JTextField display = new JTextField("0.000");
    boolean timerRunning = false;
    private long startTime = 0l;
    private long previousTime = 0l;
    private long timer = 0l;
    Task startThread = new Task();

    ActionListener startAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            startThread = new Task();
            startThread.start();
            if(timerRunning == true){
                timerRunning = false;
                try {
                    startThread.join();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                previousTime = timer;
                display.setText(String.valueOf(previousTime / 1000f));
            } else {
                startTime = System.currentTimeMillis();
                timerRunning = true;
            }
            if(timerRunning == true) {
                startBt.setText("Stop");
            } else {
                startBt.setText("Start");
            }
        }
    };
    ActionListener resetAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timerRunning = false;
            try {
                startThread.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            previousTime = 0l;
            display.setText(String.valueOf("0.000"));
            startBt.setText("Start");
        }
    };

    UI() {
        setLayout(null);
        setSize(320, 320);

        display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
        display.setHorizontalAlignment(JTextField.CENTER);
        add(display);
        display.setBackground(new Color(166, 245, 230, 255));
        display.setBounds(0, 0, 300, 200);

        add(startBt);
        startBt.setBounds(0, 200, 150, 80);
        startBt.addActionListener(startAL);

        add(resetBt);
        resetBt.setBounds(150, 200, 150, 80);
        resetBt.addActionListener(resetAL);

        setVisible(true);
    }


    class Task extends Thread {
        @Override
        public void run() {
            while (timerRunning) {
                timer = previousTime + System.currentTimeMillis() - startTime;
                display.setText(String.valueOf(timer / 1000f));
            }
        }
    }

}
