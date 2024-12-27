import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.GridLayout;


public class UI extends JFrame implements MouseMotionListener {

    private Label label = new Label();
    private Color color = Color.black;
    private Color[] colors = {Color.BLACK, Color.LIGHT_GRAY, Color.BLUE, Color.CYAN, Color.YELLOW,
                              Color.GREEN, Color.RED, Color.MAGENTA, Color.PINK, Color.ORANGE};
    private int x = 0;
    private int y = 0;

    UI() {
        setSize(500, 700);
        addMouseMotionListener(this);
        setLayout(null);
        label.setBounds(400, 620, 100, 50);
        label.setBackground(Color.LIGHT_GRAY);
        add(label);

        JButton button = new JButton("Clean");
        button.setBounds(0, 610, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, 500, 700);
                button.setVisible(true);
            }
        });
        add(button);
        
        JPanel panel = new JPanel();
        GridLayout collorPalette = new GridLayout(10, 1, 0, 0);
        panel.setLayout(collorPalette);
        panel.setBounds(0, 0, 30, 300);
        for (int i = 0; i < 10; i++) {
            final int colorId = i;
            JButton butt = new JButton();
            butt.setBackground(colors[i]);
            panel.add(butt);
            butt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    color = colors[colorId];
                }
            });
        }
        add(panel);

        JPanel panel1 = new JPanel();
        GridLayout collorPalette1 = new GridLayout(10, 1, 0, 0);
        panel1.setLayout(collorPalette);
        panel1.setBounds(450, 0, 30, 300);
        for (int i = 0; i < 10; i++) {
            final int colorId = i;
            JButton butt = new JButton();
            butt.setBackground(colors[i]);
            panel1.add(butt);
            butt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Graphics g = getGraphics();
                    g.setColor(colors[colorId]);
                    g.fillRect(0, 0, 500, 700);
                }
            });
        }
        add(panel1);

        setVisible(true);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText("X: " + e.getX() + " Y: " + e.getY());
        Graphics g = getGraphics();
        g.setColor(color);


        if (x == 0 && y == 0) {
            x = e.getX();
            y = e.getY();
            return;
        }
        g.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = 0;
        y = 0;
    }

}
