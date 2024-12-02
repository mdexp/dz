public class Circle {
    int radius;
    static float PI = 3.14159f;

    public Circle(int radius){
        System.out.println("Constructor Circle with radius: " + radius);
        this.radius = radius;
    }

    public void calculateArea(){
      double S = Math.sqrt(PI * radius);
      System.out.println("Area of circle with radius: " + radius + " are " + S);

    }

    public void calculateCircumference(){
      float L = PI * radius * 2f;
      System.out.println("Circumference of circle with radius: " + radius + " are " + L);

    }
}
