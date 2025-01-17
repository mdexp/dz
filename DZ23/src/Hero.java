import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hero extends JButton  {

    private Image image;
    int backgroungX;
    private ImgThread imgThread;
    private boolean isRightPos = true;

    public Hero(String path)  {
        setLayout(null);
        setOpaque(false);
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imgThread = new ImgThread(this);
        imgThread.start();

    }@Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            if (!isRightPos)
                g2d.scale(-1, 1);

            g2d.setColor( new Color(0, 0, 0, 0));
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setComposite(AlphaComposite.SrcOver);
            g2d.drawImage(image, backgroungX, -40, 900, 400, this);
            g2d.dispose();



        } else {
            g.setColor(Color.RED);
            g.drawString("Не вдалося завантажити зображення!", 50, 50);
        }
    }


    public void stepRight() {
        imgThread.move();
        isRightPos = true;
        MoveThread moveThread = new MoveThread(this);
        moveThread.start();
    }

    public void stepLeft() {
        setBounds(getX()-100, getY(), getWidth(), getHeight());
        imgThread.move();
        isRightPos = false;
    }

    public void stepDown() {
        setBounds(getX(), getY() + 30, getWidth(), getHeight());
        imgThread.moveDown();
    }

    public void stepUp() {
        setBounds(getX(), getY() - 30, getWidth(), getHeight());
        imgThread.moveUp();
    }


}

