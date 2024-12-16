public class Book {
    public String title;
    public String author;
    public int year;
    public int isbn;
    public boolean isAvailable;

    public Book(String title, String author, int year, int isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public void getInfo() {
        System.out.println("Це звичана книга \"" + author + "\" автора " + author + ". Читайте більше!");
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}