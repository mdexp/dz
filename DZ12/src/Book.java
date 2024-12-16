class Book {
    String author;
    String nameBook;
    int year;

    public void setBookInfo(String author, String nameBook, int year) {
        this.author = author;
        this.nameBook = nameBook;
        this.year = year;
    }

    public String getBookAuthor() {
        return this.author;
    }

    public String getBookName() {
        return this.nameBook;
    }

    public int getBookYear() {
        return this.year;
    }
}
