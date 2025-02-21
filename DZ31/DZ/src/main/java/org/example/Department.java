package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Student> students;
    private int departmentId;
    private int universityId;

    public Department(String name, int universityId) {
        this.name = name;
        this.students = new ArrayList<>();
        this.universityId = universityId;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printDepartmentInfo() {
        System.out.println("  Department: " + name);
        for (Student student : students) {
            student.printStudentInfo();
        }
    }

    public void saveDepartment(Connection connection) throws SQLException {
        String query = "INSERT INTO department (name, university_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setInt(2, universityId);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    setDepartmentId(rs.getInt(1));
                }
            }
        }
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
