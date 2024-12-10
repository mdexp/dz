public class Main {

    public static void main(String[] args) {

//  Завдання 1
//#################################################################################################
        Library library = new Library();

        Book book1 = new Book();
        book1.setBookInfo("Author_1", "Book_1", 2000);
        Book book2 = new Book();
        book2.setBookInfo("Author_2", "Book_2", 2001);
        Book book3 = new Book();
        book3.setBookInfo("Author_3", "Book_3", 2002);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        System.out.println(library.countBooks() + " books in the library");

        library.dellBook(book3);
        System.out.println(library.countBooks() + " books in the library after deleting");

        Book find_book = library.findBook("Book_2");
        System.out.println("Book_2 found; author: " + find_book.getBookAuthor() + "; year:" + find_book.getBookYear());


//  Завдання 2
//#################################################################################################
        Bank bank = new Bank();
        int accountId_1 = bank.createAccount();
        int accountId_2 = bank.createAccount();
        int accountId_3 = bank.createAccount();

        bank.blockAccount(accountId_2);
        bank.unBlockAccount(accountId_2);

//  Завдання 3
//#################################################################################################
        Company company = new Company();

        company.addEngineer("Engineer_1", 1000, "Department_1" );
        company.addEngineer("Engineer_2", 2000, "Department_2" );
        company.addEngineer("Engineer_3", 3000, "Department_3" );
        company.addManager("Manager_1", 1000, "Department_1" );
        company.addManager("Manager_2", 2000, "Department_2" );
        company.addManager("Manager_3", 3000, "Department_3" );
        System.out.println("Employees in company: " + company.getEmployeesCount());

        company.removeEngineer("Engineer_1");
        company.removeManager("Manager_1");
        System.out.println("Employees in company after deleting: " + company.getEmployeesCount());

        System.out.println("Common salary in company: " + company.getCommomSalary());
        System.out.println("Average salary in company: " + company.getAvgSalary());
    }
}
