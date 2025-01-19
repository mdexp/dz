class MoveThread extends Thread {
    private Hero hero;

    public MoveThread(Hero hero) {
        this.hero = hero;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000 / 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 3) {
                hero.setBounds(hero.getX() + 30, hero.getY() - 30, hero.getWidth(), hero.getHeight());
            }
            if (i == 4) {
                hero.setBounds(hero.getX() + 75, hero.getY() - 10, hero.getWidth(), hero.getHeight());
            }
            if (i == 5) {
                hero.setBounds(hero.getX() + 45, hero.getY() + 40, hero.getWidth(), hero.getHeight());
            }
        }
    }
}
