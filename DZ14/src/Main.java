public class Main {
    public static void main(String[] args) {

        FictionBook fictionBook_1 = new FictionBook("Title_1", "Author_1", "Genre_1", 1999, 94586934, true);
        FictionBook fictionBook_2 = new FictionBook("Title_2", "Author_2", "Genre_2", 2001, 94586935, true);
        EducationalBook educationalBook_1 = new EducationalBook("Title_3", "Author_3", "Math", "School", 2005, 94586938, true);
        EducationalBook educationalBook_2 = new EducationalBook("Title_4", "Author_4", "History", "University", 2006, 94586939, true);

        Library library = new Library();
        library.addBook(fictionBook_1);
        library.addBook(fictionBook_2);
        library.addBook(educationalBook_1);
        library.addBook(educationalBook_2);

        Reader reader_1 = new Reader("Reader_1", 100);
        Reader reader_2 = new Reader("Reader_2", 101);

        library.getAllBooksInfo();

        System.out.println("Found " + library.getBooksByGenre("Genre_1").size() + " with genre \"Genre_1\"");
        System.out.println("Found " + library.getBooksBySubject("Math").size() + " with subject \"Math\"");

        library.takeBookToReader(fictionBook_1, reader_1);
        library.takeBookToReader(educationalBook_2, reader_2);

    }
}