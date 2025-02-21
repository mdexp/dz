package org.example;

import java.sql.*;

public class Student {
    private String name;
    private int studentId;
    private int departmentId;

    public Student(String name, int departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public void printStudentInfo() {
        System.out.println("    Student: " + name + ", ID: " + studentId);
    }

    public void saveStudent(Connection connection) throws SQLException {
        String query = "INSERT INTO student (name, department_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setInt(2, departmentId);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    setStudentId(rs.getInt(1));
                }
            }
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
