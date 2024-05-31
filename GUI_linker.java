package com.mycompany.javaproject;

import javax.swing.*;
import java.sql.*;

public class GUI_linker {
    
    void loginMethod(){
        login login = new login();
        login.setVisible(true); 
        JTextField userField = login.getJuser();
        JPasswordField passwordField = login.getJpassword();
        login.getBlogin().addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());
            System.out.println("Entered username: " + username);
            System.out.println("Entered password: " + password);
            if (isAdmin(username, password)) {
                login.dispose();
                registerMethod();
            }
            else if(isUser(username,password)){
                Javaproject ob=new Javaproject();
                System.out.println(ob.sus(username));
            }
            else {
                JOptionPane.showMessageDialog(login, "Invalid credentials. Please try again.");
            }
        });
    }
    
    public void registerMethod() {
        register registerForm = new register();
        registerForm.setVisible(true);

        JButton submitButton = registerForm.getBsubmit();
        JButton backButton = registerForm.getBback();
        submitButton.addActionListener(e -> {
            String username = registerForm.getJuser1();
            String password = registerForm.getJpassword1();
            String sgpa1Str = registerForm.getSgpa1();
            String sgpa2Str = registerForm.getSgpa2();
            String beforeFeeStr = registerForm.getBeforeFee();
            String school = registerForm.getSchool();
            String branch = registerForm.getBranch();

            if (username.isEmpty() || password.isEmpty() || sgpa1Str.isEmpty() || sgpa2Str.isEmpty() || beforeFeeStr.isEmpty() || school.isEmpty() || branch.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required.");
            } 
            else {
                try {
                    double sgpa1 = Double.parseDouble(sgpa1Str);
                    double sgpa2 = Double.parseDouble(sgpa2Str);
                    double beforeFee = Double.parseDouble(beforeFeeStr);
                    double afterfee = 0.0; // Dummy value for afterfee

                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                    System.out.println("SGPA1: " + sgpa1);
                    System.out.println("SGPA2: " + sgpa2);
                    System.out.println("Before Fee: " + beforeFee);
                    System.out.println("School: " + school);
                    System.out.println("Branch: " + branch);

                    DatabaseHelper db = new DatabaseHelper();
                    db.insertRow(username, password, school, branch, sgpa1, sgpa2, beforeFee, afterfee);
                    } 
                catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "SGPA1, SGPA2, and Before Fee must be valid numbers.");
                    }
                }
            });
            backButton.addActionListener(e1 -> {
                registerForm.dispose();
                loginMethod();
            });
    }

    private static boolean isAdmin(String username, String password) {
    if (username.equals("admin")) {
        

  ResultSet resultSet = null; // Declare resultSet outside the try block and initialize it to null
    
    try {
        resultSet = DatabaseHelper.selectRow("admin"); // Assign the result of selectRow inside the try block
        // Check if the ResultSet is not null and move the cursor to the first row
        if (resultSet != null && resultSet.next()) {
            // Retrieve data from the ResultSet
            String roll_no1 = resultSet.getString("roll_no");
            String password1 = resultSet.getString("password");
            String school = resultSet.getString("school");
            String branch = resultSet.getString("branch");
            double sgpa1 = resultSet.getDouble("sgpa1");
            double sgpa2 = resultSet.getDouble("sgpa2");
            double beforefee = resultSet.getDouble("beforefee");
            double afterfee = resultSet.getDouble("afterfee");
            
            // Process the retrieved data as needed
            System.out.println("Admin User Details:");
            System.out.println("Roll Number: " + roll_no1);
            System.out.println("Password: " + password1);
            System.out.println("School: " + school);
            System.out.println("Branch: " + branch);
            System.out.println("SGPA1: " + sgpa1);
            System.out.println("SGPA2: " + sgpa2);
            System.out.println("Before Fee: " + beforefee);
            System.out.println("After Fee: " + afterfee);
            if(password1.equals(password))
                return true;
        } else {
            System.out.println("Admin user not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close the result set to release database resources
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    }
    return false;
}
private static boolean isUser(String username, String password) {
    if (DatabaseHelper.rollNoExists(username)) {
    
        

  ResultSet resultSet = null; // Declare resultSet outside the try block and initialize it to null
    
    try {
        resultSet = DatabaseHelper.selectRow(username); // Assign the result of selectRow inside the try block
        // Check if the ResultSet is not null and move the cursor to the first row
        if (resultSet != null && resultSet.next()) {
            // Retrieve data from the ResultSet
            String roll_no1 = resultSet.getString("roll_no");
            String password1 = resultSet.getString("password");
            String school = resultSet.getString("school");
            String branch = resultSet.getString("branch");
            double sgpa1 = resultSet.getDouble("sgpa1");
            double sgpa2 = resultSet.getDouble("sgpa2");
            double beforefee = resultSet.getDouble("beforefee");
            double afterfee = resultSet.getDouble("afterfee");
            
            // Process the retrieved data as needed
            System.out.println(" User Details:");
            System.out.println("Roll Number: " + roll_no1);
            System.out.println("Password: " + password1);
            System.out.println("School: " + school);
            System.out.println("Branch: " + branch);
            System.out.println("SGPA1: " + sgpa1);
            System.out.println("SGPA2: " + sgpa2);
            System.out.println("Before Fee: " + beforefee);
            System.out.println("After Fee: " + afterfee);
            if(password1.equals(password)){
                return true;
            }
        } else {
            System.out.println(" user not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close the result set to release database resources
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    }
    return false;
}


}
