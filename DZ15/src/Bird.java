public class Bird implements Animal {
    @Override
    public void sound() {
        System.out.println("Chirik chirik");
    }

    @Override
    public void eat() {
        System.out.println("Eat worms");
    }
}
