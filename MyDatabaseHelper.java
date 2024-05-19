/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.javaproject;

/**
 *
 * @author marvelpokemaster
 */
import java.sql.*;

class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/AmritaDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    static ResultSet selectRow(String rollNo) throws SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String selectQuery = "SELECT * FROM students WHERE roll_no = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, rollNo);
            resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            throw e; // Re-throw the exception to handle it in the calling method
        }
    }

    static void saveStudentToDatabase(Amrita student) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO students (roll_no, school, branch, sgpa1, sgpa2, beforeFee) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, student.getRollNo());
                stmt.setString(2, student.getSchool());
                stmt.setString(3, student.getBranch());
                stmt.setDouble(4, student.getSgpa1());
                stmt.setDouble(5, student.getSgpa2());
                stmt.setDouble(6, student.getBeforeFee());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static boolean isRollNoExists(String rollNo) throws SQLException {
        boolean exists = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String selectQuery = "SELECT * FROM students WHERE roll_no = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, rollNo);
            resultSet = preparedStatement.executeQuery();

            exists = resultSet.next();
        } catch (SQLException e) {
            throw e; // Re-throw the exception to handle it in the calling method
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exists;
    }


    static void updateRow(String rollNo, double newSgpa1, double newSgpa2, double newBeforeFee) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String updateQuery = "UPDATE students SET sgpa1 = ?, sgpa2 = ?, beforeFee = ? WHERE roll_no = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, newSgpa1);
            preparedStatement.setDouble(2, newSgpa2);
            preparedStatement.setDouble(3, newBeforeFee);
            preparedStatement.setString(4, rollNo);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Row updated successfully.");
            } else {
                System.out.println("No rows were updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
