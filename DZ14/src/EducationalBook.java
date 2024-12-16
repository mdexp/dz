public class EducationalBook extends Book{

    public String subject;
    public String level;

    public EducationalBook(String title, String author, String subject, String level, int year, int isbn, boolean isAvailable) {
        super(title, author, year, isbn, isAvailable);
        this.subject = subject;
        this.level = level;
    }

    @Override
    public void getInfo() {
        System.out.println("Це навчальна  книга \"" + title + "\" автора " + author
                + ". Subject " + subject + ", level " + level);
    }

}
