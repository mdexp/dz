package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection connection = DatabaseManager.getConnection()) {
            University university = new University("Example University");

            university.saveUniversity(connection);
            int universityId = university.getUniversityId();

            Department department1 = new Department("Computer Science", universityId);
            Department department2 = new Department("Mathematics", universityId);

            university.addDepartment(department1);
            university.addDepartment(department2);
            department1.saveDepartment(connection);
            department2.saveDepartment(connection);

            department1.addStudent(new Student("Алиса Дубинина", department1.getDepartmentId()));
            department1.addStudent(new Student("Валерій Ковальчук", department1.getDepartmentId()));
            department2.addStudent(new Student("Саша Муравський", department2.getDepartmentId()));

            for (Student student : department1.getStudents()) {
                student.saveStudent(connection);
            }
            for (Student student : department2.getStudents()) {
                student.saveStudent(connection);
            }

            university.printUniversityInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
