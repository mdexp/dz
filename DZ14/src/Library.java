import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Reader> readers = new ArrayList<Reader>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addNewReader(String name, int id) {
        Reader reader = new Reader(name, id);
        this.readers.add(reader);
    }

    public void takeBookToReader(Book book, Reader reader) {
        books.remove(book);
        reader.addBook(book);
    }

    public void getBookFromReader(Book book, Reader reader) {
        reader.returnBook(book);
        books.add(book);
    }

    public void getAllBooksInfo() {
        for (Book book : books) {
            book.getInfo();
        }
    }

    public ArrayList<Book> getBooksByGenre(String genre) {
        ArrayList<Book> booksByGenre = new ArrayList<Book>();
        for (Book book : books) {
            if ((book instanceof FictionBook)) {
                if (((FictionBook) book).genre.equals(genre)) {
                    booksByGenre.add(book);
                }
            }
        }
        return booksByGenre;
    }

    public ArrayList<Book> getBooksBySubject(String subject) {
        ArrayList<Book> booksBySubject = new ArrayList<Book>();
        for (Book book : books) {
            if ((book instanceof EducationalBook)) {
                if (((EducationalBook) book).subject.equals(subject)) {
                    booksBySubject.add(book);
                }
            }
        }
        return booksBySubject;
    }

}