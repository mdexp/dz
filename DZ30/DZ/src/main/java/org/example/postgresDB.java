package org.example;

import java.sql.*;
import java.util.ArrayList;

public class postgresDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";


    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Подключение успешно!");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        }
        return conn;
    }


    public static boolean addCar(String name, int age) {
        String sql = "INSERT INTO cars (name, age) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении автомобиля: " + e.getMessage());
            return false;
        }
    }


    public static ArrayList<Car> readCars() {
        ArrayList<Car> carsList = new ArrayList<Car>();
        String sql = "SELECT * FROM cars";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                carsList.add(new Car(id, name, age));
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при чтении данных: " + e.getMessage());
        }
        return carsList;
    }


    public static boolean updateCar(int id, String newName, int newAge) {
        String sql = "UPDATE cars SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, newAge);
            stmt.setInt(3, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error added a vehicle: " + e.getMessage());
            return false;
        }
    }

    // 4. Функция для удаления данных (по id)
    public static boolean deleteCar(int id) {
        String sql = "DELETE FROM cars WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error delete vehicle: " + e.getMessage());
            return false;
        }
    }
}
