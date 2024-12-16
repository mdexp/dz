
public class FictionBook extends Book {
    public String genre;

    public FictionBook(String title, String author, String genre, int year, int isbn, boolean isAvailable) {
        super(title, author, year, isbn, isAvailable);
        this.genre = genre;
    }

    @Override
    public void getInfo() {
        System.out.println("Це художня книга \"" + title + "\" автора " + author
                + ". Художня література — літературний жанр, що включає твори, створені за допомогою уяви, " +
                " і охоплює різноманітні літературні форми: романи, новели, повісті, поезія, драми тощо.");
    }
}