package com.mycompany.javaproject;

import java.sql.*;
import java.util.*;
public class Javaproject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO AMRITA SCHOOL OF COMPUTING");
        System.out.print("ENTER YOUR SCHOOL: ");
        String school = sc.nextLine();

        Amrita student = null;

        if (school.equalsIgnoreCase("CSE") || school.equalsIgnoreCase("CSEAI") ||
                school.equalsIgnoreCase("CSECS") || school.equalsIgnoreCase("CSEDA") ||
                school.equalsIgnoreCase("ELC") || school.equalsIgnoreCase("EEE") ||
                school.equalsIgnoreCase("RA") || school.equalsIgnoreCase("RAI")) {

            System.out.print("ENTER YOUR ROLL NUMBER: ");
            String roll_no = sc.nextLine();
            System.out.print("ENTER YOUR PASSWORD: ");
            String password = sc.nextLine();
            System.out.print("Enter SGPA1: ");
            double sgpa1 = sc.nextDouble();
            System.out.print("Enter SGPA2: ");
            double sgpa2 = sc.nextDouble();
            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine();

            switch (school.toUpperCase()) {
                case "CSE":
                    student = new CSE(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, cgpa);
                    break;
                case "CSEAI":
                    student = new CSEAI(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, cgpa);
                    break;
                case "CSECS":
                    student = new CSECS(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, cgpa);
                    break;
                case "CSEDA":
                    student = new CSEDA(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, cgpa);
                    break;
                case "ELC":
                    student = new ELC(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, cgpa);
                    break;
                case "EEE":
                    student = new EEE(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, cgpa);
                    break;
                case "RA":
                    student = new RA(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, cgpa);
                    break;
                case "RAI":
                    student = new RAI(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, cgpa);
                    break;
                default:
                    System.out.println("Invalid school entered.");
                    return;
            }

            try {
                DatabaseHelper.saveStudentToDatabase(student);
                student.calculateFee();
                DatabaseHelper.updateFee(student.getRollNo(), student.getFee());
                display(roll_no);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("YOU ARE NOT A STUDENT OF AMRITA SCHOOL");
        }

        sc.close();
    }

    static void display(String roll_no) {
        try {
            ResultSet rs = DatabaseHelper.selectRow(roll_no);
            if (rs != null && rs.next()) {
                System.out.println("Roll No: " + rs.getString("roll_no"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("School: " + rs.getString("school"));
                System.out.println("Branch: " + rs.getString("branch"));
                System.out.println("SGPA1: " + rs.getDouble("sgpa1"));
                System.out.println("SGPA2: " + rs.getDouble("sgpa2"));
                System.out.println("CGPA: " + rs.getDouble("cgpa"));
                System.out.println("Fee: " + rs.getDouble("fee"));
            } else {
                System.out.println("No student found with roll number: " + roll_no);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
