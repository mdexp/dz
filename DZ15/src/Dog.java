public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Wof wof wof");
    }

    @Override
    public void eat() {
        System.out.println("Eat meat");
    }
}
