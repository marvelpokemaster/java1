package com.mycompany.javaproject;

import java.sql.*;
import java.util.Scanner;

abstract class Amrita {
    private String rollNo;
    private String password;
    private String school;
    private String branch;
    private double sgpa1;
    private double sgpa2;
    private double cgpa;
    private double fee;

    public Amrita(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        this.rollNo = rollNo;
        this.password = password;
        this.school = school;
        this.branch = branch;
        this.sgpa1 = sgpa1;
        this.sgpa2 = sgpa2;
        this.cgpa = cgpa;
        this.fee = 0.0;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getPassword() {
        return password;
    }

    public String getSchool() {
        return school;
    }

    public String getBranch() {
        return branch;
    }

    public double getSgpa1() {
        return sgpa1;
    }

    public double getSgpa2() {
        return sgpa2;
    }

    public double getCgpa() {
        return cgpa;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    abstract void calculateFee();
}

class CSE extends Amrita {
    public CSE(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        super(rollNo, password, school, branch, sgpa1, sgpa2, cgpa);
    }

    @Override
    void calculateFee() {
        double fee = 10000; // Example fee calculation
        setFee(fee);
    }
}

class CSEAI extends Amrita {
    public CSEAI(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        super(rollNo, password, school, branch, sgpa1, sgpa2, cgpa);
    }

    @Override
    void calculateFee() {
        double fee = 12000; // Example fee calculation
        setFee(fee);
    }
}

class CSECS extends Amrita {
    public CSECS(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        super(rollNo, password, school, branch, sgpa1, sgpa2, cgpa);
    }

    @Override
    void calculateFee() {
        double fee = 11000; // Example fee calculation
        setFee(fee);
    }
}

class CSEDA extends Amrita {
    public CSEDA(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        super(rollNo, password, school, branch, sgpa1, sgpa2, cgpa);
    }

    @Override
    void calculateFee() {
        double fee = 13000; // Example fee calculation
        setFee(fee);
    }
}

class ELC extends Amrita {
    public ELC(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        super(rollNo, password, school, branch, sgpa1, sgpa2, cgpa);
    }

    @Override
    void calculateFee() {
        double fee = 14000; // Example fee calculation
        setFee(fee);
    }
}

class EEE extends Amrita {
    public EEE(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        super(rollNo, password, school, branch, sgpa1, sgpa2, cgpa);
    }

    @Override
    void calculateFee() {
        double fee = 15000; // Example fee calculation
        setFee(fee);
    }
}

class RA extends Amrita {
    public RA(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        super(rollNo, password, school, branch, sgpa1, sgpa2, cgpa);
    }

    @Override
    void calculateFee() {
        double fee = 16000; // Example fee calculation
        setFee(fee);
    }
}

class RAI extends Amrita {
    public RAI(String rollNo, String password, String school, String branch, double sgpa1, double sgpa2, double cgpa) {
        super(rollNo, password, school, branch, sgpa1, sgpa2, cgpa);
    }

    @Override
    void calculateFee() {
        double fee = 17000; // Example fee calculation
        setFee(fee);
    }
}
