public class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Meaw meaw");
    }

    @Override
    public void eat() {
        System.out.println("Eat mouse");
    }
}
