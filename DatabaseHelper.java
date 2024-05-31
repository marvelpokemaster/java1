package com.mycompany.javaproject;

import java.sql.*;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/AmritaDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void insertRow(String roll_no, String password, String school, String branch, 
                                 double sgpa1, double sgpa2, double beforefee) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO students (roll_no, password, school, branch, sgpa1, sgpa2, beforefee) " +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, roll_no);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, school);
            preparedStatement.setString(4, branch);
            preparedStatement.setDouble(5, sgpa1);
            preparedStatement.setDouble(6, sgpa2);
            preparedStatement.setDouble(7, beforefee);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectRow(String roll_no) {
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM students WHERE roll_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, roll_no);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void updateRow(String roll_no, String newPassword, String newSchool, String newBranch, 
                                 double newSGPA1, double newSGPA2, double newBeforeFee) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String updateQuery = "UPDATE students SET password = ?, school = ?, branch = ?, sgpa1 = ?, sgpa2 = ?, " +
                                 "beforefee = ? WHERE roll_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, newSchool);
            preparedStatement.setString(3, newBranch);
            preparedStatement.setDouble(4, newSGPA1);
            preparedStatement.setDouble(5, newSGPA2);
            preparedStatement.setDouble(6, newBeforeFee);
            preparedStatement.setString(7, roll_no);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean rollNoExists(String roll_no) {
        boolean exists = false;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT COUNT(*) AS count FROM students WHERE roll_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, roll_no);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
