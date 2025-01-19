class ImgThread extends Thread {
    private Hero hero;
    private int imgStep = 91;
    private int countFrame = 3;
    private int index = 0;

    ImgThread(Hero hero) {
        this.hero = hero;
    }

    public void run() {
        animates();
    }

    private void animates() {
        for (index = 0; true; index++) {
            if (index == countFrame) {
                index = 0;
                baseAnimation();
            }
            hero.backgroungX -= imgStep;
            hero.repaint();
            try {
                Thread.sleep(1000 / 5);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void baseAnimation() {
        hero.backgroungX = 0;
        countFrame = 3;
    }

    public void moveDown() {
        index = 0;
        countFrame = 5;
        hero.backgroungX = -90;
    }

    public void moveUp() {
        index = 0;
        countFrame = 3;
        hero.backgroungX = -540;
    }

    public void move() {
        index = 0;
        countFrame = 5;
        hero.backgroungX = -375;
    }
}