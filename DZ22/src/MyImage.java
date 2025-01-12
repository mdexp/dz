import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyImage extends JButton implements ActionListener {
    Image image;
    int x;
    ImgThread imgThread;
    public MyImage(String path)  {
        setLayout(null);
        addActionListener(this);
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imgThread = new ImgThread(this);

    }
    @Override
    protected void paintComponent(Graphics g) {


        if (image != null) {



            g.drawImage(image, x, -40, 900, 400, this);



        } else {
            g.setColor(Color.RED);
            g.drawString("Не вдалося завантажити зображення!", 50, 50);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        imgThread.start();
    }
}

