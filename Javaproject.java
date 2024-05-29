package com.mycompany.javaproject;

import java.util.*;

public class Javaproject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO AMRITA SCHOOL OF COMPUTING");
        System.out.print("ENTER YOUR SCHOOL: ");
        String school = sc.nextLine();

        if (school.equalsIgnoreCase("CSE") || school.equalsIgnoreCase("CSEAI") ||
            school.equalsIgnoreCase("CSECS") || school.equalsIgnoreCase("CSEDA")) {
            System.out.print("ENTER YOUR ROLL NUMBER: ");
            String roll_no = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            System.out.print("Enter SGPA1: ");
            double sgpa1 = sc.nextDouble();
            System.out.print("Enter SGPA2: ");
            double sgpa2 = sc.nextDouble();
            System.out.print("Enter beforeFee: ");
            double beforeFee = sc.nextDouble();
            sc.nextLine();

            Amrita student = null;
            switch (school.toUpperCase()) {
                case "CSE":
                    student = new CSE(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, beforeFee);
                    break;
                case "CSEAI":
                    student = new CSEAI(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, beforeFee);
                    break;
                case "CSECS":
                    student = new CSECS(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, beforeFee);
                    break;
                case "CSEDA":
                    student = new CSEDA(roll_no, password, "Amrita School of Computing", school, sgpa1, sgpa2, beforeFee);
                    break;
            }
            student.calculateFee();
        } else if (school.equalsIgnoreCase("ELC") || school.equalsIgnoreCase("EEE") ||
            school.equalsIgnoreCase("RA") || school.equalsIgnoreCase("RAI")) {
            System.out.println("WELCOME TO AMRITA SCHOOL OF ENGINEERING");
            System.out.print("ENTER YOUR ROLL NUMBER: ");
            String roll_no = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            System.out.print("Enter SGPA1: ");
            double sgpa1 = sc.nextDouble();
            System.out.print("Enter SGPA2: ");
            double sgpa2 = sc.nextDouble();
            System.out.print("Enter beforeFee: ");
            double beforeFee = sc.nextDouble();
            sc.nextLine();

            Amrita student = null;
            switch (school.toUpperCase()) {
                case "ELC":
                    student = new ELC(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, beforeFee);
                    break;
                case "EEE":
                    student = new EEE(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, beforeFee);
                    break;
                case "RA":
                    student = new RA(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, beforeFee);
                    break;
                case "RAI":
                    student = new RAI(roll_no, password, "Amrita School of Engineering", school, sgpa1, sgpa2, beforeFee);
                    break;
            }
            student.calculateFee();
        } else {
            System.out.println("YOU ARE NOT A STUDENT OF AMRITA SCHOOL");
        }
        sc.close();
    }
}
