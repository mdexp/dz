public class Circle extends Shape {

    private final float PI = 3.14f;
    private int R;

    public Circle(int radius){
        this.R = radius;
    }

    public double calculateArea(){
        float area = PI * (R * R);
        return area;
    }
}
