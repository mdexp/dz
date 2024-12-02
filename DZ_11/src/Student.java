import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int groupNumber;
    float averageGrade;
    List<Book> bookList;

    public Student(String name, int groupNumber, float averageGrade){
        this.name = name;
        this.groupNumber = groupNumber;
        this.averageGrade = averageGrade;
        bookList = new ArrayList<>();
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void updateGrade(float averageGrade){
        this.averageGrade = averageGrade;
    }

    public void printInfo(){
        System.out.println("Student name: " + name + ", group name: " +  groupNumber + " , averageGrade: " +  averageGrade);
        System.out.println("Books: ");
        for(Book book : bookList){
            System.out.println("\t - " + book.title + ", " + book.author + ", " + book.price);
        }
    }
}
