import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Slider extends JPanel implements MouseMotionListener {
    private JButton button;
    private int button_height;
    private int stickCont = 5;
    private int stickX;

    public Slider(int w,int h,int stickCont) {
        setSize(w, h);
        this.stickCont = stickCont;
        stickX = getWidth()/2-10;
        addMouseMotionListener(this);
    }

    public void resetSlider() {
        stickX = getWidth() / 2 - 10;
        repaint();
    }

    public void setButton(JButton button){
        this.button = button;
        this.button_height = button.getHeight();
    }

    public void setStickCont(int stickCont) {
        this.stickCont = stickCont;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.drawLine(10, getHeight() / 2, getWidth()-10, getHeight()/2);

        for (int i = 0; i <= stickCont; i++) {
            g.drawLine(10 + (getWidth()-20)/stickCont*i, getHeight()/2-10, 10 + (getWidth()-20)/stickCont*i, getHeight()/2+10);
        }
        g.setColor(Color.RED);
        g.fillOval(stickX, getHeight()/2-10, 20, 20);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        stickX = e.getX();
        button.setSize(button.getWidth(), button_height + stickX);
        if (stickX<10) stickX = 10;
        if (stickX>getWidth()-10) stickX = getWidth()-10;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
