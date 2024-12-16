import java.util.ArrayList;

public class Reader {
    private String name;
    private int id;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public Reader(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public int countBook() {
        return borrowedBooks.size();
    }

}
