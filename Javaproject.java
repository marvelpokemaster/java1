package com.mycompany.javaproject;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Javaproject {

    double sus(String username) {
        
    double calculatedFee = 0.0;
    
        ResultSet resultSet = null;
        try {
            resultSet = DatabaseHelper.selectRow(username);
            if (resultSet != null && resultSet.next()) {
            String roll_no = resultSet.getString("roll_no");
            String password = resultSet.getString("password");
            String school = resultSet.getString("school");
            String branch = resultSet.getString("branch");
            double sgpa1 = resultSet.getDouble("sgpa1");
            double sgpa2 = resultSet.getDouble("sgpa2");
            double beforefee = resultSet.getDouble("beforefee");
            double afterfee = resultSet.getDouble("afterfee");

            // Process the retrieved data as needed
            System.out.println("User Details:");
            System.out.println("Roll Number: " + roll_no);
            System.out.println("Password: " + password);
            System.out.println("School: " + school);
            System.out.println("Branch: " + branch);
            System.out.println("SGPA1: " + sgpa1);
            System.out.println("SGPA2: " + sgpa2);
            System.out.println("Before Fee: " + beforefee);
            System.out.println("After Fee: " + afterfee);
            
            if (school.equalsIgnoreCase("CSE") || school.equalsIgnoreCase("CSEAI") ||
                    school.equalsIgnoreCase("CSECS") || school.equalsIgnoreCase("CSEDA")) {
                Amrita student = null;
                switch (school.toUpperCase()) {
                    case "CSE":
                        student = new CSE(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, beforefee);
                        break;
                    case "CSEAI":
                        student = new CSEAI(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, beforefee);
                        break;
                    case "CSECS":
                        student = new CSECS(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, beforefee);
                        break;
                    case "CSEDA":
                        student = new CSEDA(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, beforefee);
                        break;
                }
                if (student != null) {
                calculatedFee = student.calculateFee();
            }
            } else if (school.equalsIgnoreCase("ELC") || school.equalsIgnoreCase("EEE") ||
                    school.equalsIgnoreCase("RA") || school.equalsIgnoreCase("RAI")) {
                Amrita student = null;
                switch (school.toUpperCase()) {
                    case "ELC":
                        student = new ELC(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, beforefee);
                        break;
                    case "EEE":
                        student = new EEE(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, beforefee);
                        break;
                    case "RA":
                        student = new RA(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, beforefee);
                        break;
                    case "RAI":
                        student = new RAI(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, beforefee);
                        break;
                }
                if (student != null) {
                calculatedFee = student.calculateFee();
            }
            }//engineer
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
    
    return calculatedFee;
}


    public static void main(String[] args) {
        GUI_linker gui = new GUI_linker();
        gui.loginMethod();
    }
}
