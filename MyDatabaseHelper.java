package com.mycompany.javaproject;

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

    static void saveStudentToDatabase(Amrita student) throws SQLException {
        Connection connection = null;
        PreparedStatement selectStmt = null;
        PreparedStatement insertStmt = null;
        PreparedStatement updateStmt = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);

            String selectQuery = "SELECT * FROM students WHERE roll_no = ?";
            selectStmt = connection.prepareStatement(selectQuery);
            selectStmt.setString(1, student.getRollNo());
            resultSet = selectStmt.executeQuery();

            if (resultSet.next()) {
                String updateQuery = "UPDATE students SET password = ?, school = ?, branch = ?, sgpa1 = ?, sgpa2 = ?, cgpa = ?, fee = ? WHERE roll_no = ?";
                updateStmt = connection.prepareStatement(updateQuery);
                updateStmt.setString(1, student.getPassword());
                updateStmt.setString(2, student.getSchool());
                updateStmt.setString(3, student.getBranch());
                updateStmt.setDouble(4, student.getSgpa1());
                updateStmt.setDouble(5, student.getSgpa2());
                updateStmt.setDouble(6, student.getCgpa());
                updateStmt.setDouble(7, student.getFee());
                updateStmt.setString(8, student.getRollNo());
                updateStmt.executeUpdate();
            } else {
                String insertQuery = "INSERT INTO students (roll_no, password, school, branch, sgpa1, sgpa2, cgpa, fee) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                insertStmt = connection.prepareStatement(insertQuery);
                insertStmt.setString(1, student.getRollNo());
                insertStmt.setString(2, student.getPassword());
                insertStmt.setString(3, student.getSchool());
                insertStmt.setString(4, student.getBranch());
                insertStmt.setDouble(5, student.getSgpa1());
                insertStmt.setDouble(6, student.getSgpa2());
                insertStmt.setDouble(7, student.getCgpa());
                insertStmt.setDouble(8, student.getFee());
                insertStmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (resultSet != null) resultSet.close();
            if (selectStmt != null) selectStmt.close();
            if (insertStmt != null) insertStmt.close();
            if (updateStmt != null) updateStmt.close();
            if (connection != null) connection.close();
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

    static void updateRow(String rollNo, double newSgpa1, double newSgpa2, double newCgpa, double newFee) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String updateQuery = "UPDATE students SET sgpa1 = ?, sgpa2 = ?, cgpa = ?, fee = ? WHERE roll_no = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, newSgpa1);
            preparedStatement.setDouble(2, newSgpa2);
            preparedStatement.setDouble(3, newCgpa);
            preparedStatement.setDouble(4, newFee);
            preparedStatement.setString(5, rollNo);
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
    
    static void updateFee(String rollNo, double newFee) throws SQLException {
        updateRow(rollNo, 0, 0, 0, newFee);
    }
}
