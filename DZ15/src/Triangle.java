public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateArea(){
        double pp = (a + b + c) / 2.0;  // полупериметр
        double res = Math.sqrt((pp * (pp - a) * (pp - b) * (pp - c)));
        System.out.println(pp + "  " + res);
        return res;
    }
}
