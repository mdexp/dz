public class Book {
    String title;
    String author;
    int price;

    public Book(String title, String author, int price){
        System.out.println("Constructor Book - title: " + title + " author: " + author + " price: " + price);
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int applyDiscount(int sale){
        int discount = 0;
        discount = price - (sale * (price / 100));
        return  discount;
    }

    public void printInfo(){
        System.out.println("Title: " + title + " author: " + author + " price: " + price);
    }
}