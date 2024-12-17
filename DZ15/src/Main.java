public class Main {

    public static void main(String[] args) {

    // 1 Задача про геометричні фігури:

    Shape circle = new Circle(2);
    Shape rectangle = new Rectangle(2,3);
    Shape triangle = new Triangle(13, 14, 15);

    System.out.println("Circle area is: " + circle.calculateArea());
    System.out.println("Rectangle area is: " + rectangle.calculateArea());
    System.out.println("Triangle area is: " + triangle.calculateArea());

    // 2 Задача про тварин:
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal bird = new Bird();

        System.out.print("I'm Dog. I say: ");
        dog.sound();
        System.out.print("I like ");
        dog.eat();

        System.out.print("I'm Cat. I say: ");
        cat.sound();
        System.out.print("I like ");
        cat.eat();

        System.out.print("I'm Bird. I say: ");
        bird.sound();
        System.out.print("I like ");
        bird.eat();

    }

}
