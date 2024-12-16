import java.util.ArrayList;

class Library {
    ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void dellBook(Book book) {
        books.remove(book);
    }

    public Book findBook(String nameBook) {
        Book res = new Book();
        for (Book book : books) {
            if (book.getBookName().equals(nameBook)) {
                res = book;
            }
        }
        return res;
    }

    public int countBooks() {
        return books.size();
    }
}
