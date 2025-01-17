import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UI extends JFrame implements KeyListener {

    private Hero hero;
    UI (){
        setSize(1000, 700);
        setLayout( null);
        addKeyListener( this);
        // Встановлюємо, що JFrame має бути фокусованим
        setFocusable(true);
        requestFocusInWindow();

        hero = new Hero("src/sd.png");
        hero.setBounds(100, 200, 100, 120);

        add(hero);
        setVisible(true);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(String.valueOf(e.getKeyCode()));
        switch (e.getKeyCode()){
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
