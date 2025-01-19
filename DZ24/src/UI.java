import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class UI extends JFrame implements KeyListener {

    private Hero hero;
    private Color[] colors = {Color.BLACK, Color.LIGHT_GRAY, Color.BLUE, Color.CYAN, Color.YELLOW,
            Color.GREEN, Color.RED, Color.MAGENTA, Color.PINK, Color.ORANGE};

    UI() {
        setSize(1000, 700);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

        hero = new Hero("src/sd.png");
        hero.setBounds(100, 200, 100, 120);
        add(hero);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(140, 10, 120, 30);
        settingsButton.addActionListener(e -> openSettingsWindow());
        add(settingsButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(10, 10, 120, 30);
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
        setVisible(true);
    }

    private void openSettingsWindow() {
        JFrame settingsFrame = new JFrame("Settings");
        settingsFrame.setSize(400, 80);
        setLayout(null);

        JLabel label = new JLabel("settings");
        label.setBounds(400, 620, 100, 50);
        label.setBackground(Color.LIGHT_GRAY);
        settingsFrame.add(label);

        JPanel panel = new JPanel();
        GridLayout collorPalette = new GridLayout(1, 10, 0, 0);
        panel.setLayout(collorPalette);
        panel.setBounds(0, 0, 300, 30);
        for (int i = 0; i < 10; i++) {
            final int colorId = i;
            JButton butt = new JButton();
            butt.setBackground(colors[i]);
            panel.add(butt);
            butt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getContentPane().setBackground(colors[colorId]);
                }
            });
        }

        settingsFrame.add(panel);

        settingsFrame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(String.valueOf(e.getKeyCode()));
        switch (e.getKeyCode()) {
            case 68:
                hero.stepRight();
                break;
            case 65:
                hero.stepLeft();
                break;
            case 32:
                break;
            case 83:
                hero.stepDown();
                break;
            case 87:
                hero.stepUp();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

