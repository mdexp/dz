package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Department> departments;
    private int universityId;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void printUniversityInfo() {
        System.out.println("University: " + name);
        for (Department department : departments) {
            department.printDepartmentInfo();
        }
    }

    public void saveUniversity(Connection connection) throws SQLException {
        String query = "INSERT INTO university (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    setUniversityId(rs.getInt(1));
                }
            }
        }
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
}



