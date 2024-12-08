public class Dish {

    String name;
    float price;
    String category;

    public Dish(String name, String category, float price){
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void displayInfo(){
        System.out.println("Dish info:");
        System.out.println("\tName: " + name);
        System.out.println("\tCategory: " + category);
        System.out.println("\tPrice: " + price);
    }
}
