public class Main {

    public static void main(String[] args) {

        Book book_1 = new Book("Title 1","Author 1",100);
        Book book_2 = new Book("Title 2","Author 2",200);
        Book book_3 = new Book("Title 3","Author 3",300);

        int discount = 10;
        System.out.println("For book with price " + book_1.price + " with discount " + discount +  "% is " + book_1.applyDiscount(discount));

        book_1.printInfo();
        book_2.printInfo();

        Circle circle = new Circle(4);
        circle.calculateArea();
        circle.calculateCircumference();

        Student student_1 = new Student("Maxim", 7, 4.9f);
        student_1.addBook(book_1);
        student_1.addBook(book_2);
        Student student_2 = new Student("Petro", 7, 4.5f);
        student_2.addBook(book_1);
        student_2.addBook(book_2);
        Student student_3 = new Student("Anton", 7, 4.2f);
        student_3.addBook(book_1);
        student_3.addBook(book_2);
        student_3.addBook(book_3);

        student_2.updateGrade(4.0f);

        student_1.printInfo();
        student_2.printInfo();
        student_3.printInfo();
    }

}
