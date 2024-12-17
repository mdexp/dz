public class Rectangle extends Shape {

    private int A;
    private int B;

    public Rectangle(int A, int B){
        this.A = A;
        this.B = B;
    }

    public double calculateArea(){
        float area = (A * B);
        return area;
    }
}
