public class Car {

    String model;
    int year;
    String manufacturer;
    static int totalCarsProduced;

    public Car(String model, int year, String manufacturer){
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        totalCarsProduced++;
    }

    public void displayInfo(){
        System.out.println("Car info:");
        System.out.println("\tModel: " + model);
        System.out.println("\tYear: " + year);
        System.out.println("\tManufacturer: " + manufacturer);
    }
}
