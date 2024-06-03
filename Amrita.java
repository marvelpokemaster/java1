package com.mycompany.javaproject;
import java.util.*;

interface FeeCalculable {
    double calculateFee();
}

abstract class Amrita implements FeeCalculable {
    private String roll_no;
    private String school;
    private String branch;
    private double sgpa1;
    private double sgpa2;
    private String password;
    private double beforeFee;
    private double afterFee;

    public Amrita(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        this.roll_no = roll_no;
        this.password = password;
        this.school = school;
        this.branch = branch;
        this.sgpa1 = sgpa1;
        this.sgpa2 = sgpa2;
        this.beforeFee = beforeFee;
    }

    public String getRollNo() {
        return roll_no;
    }

    public void setRollNo(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getSgpa1() {
        return sgpa1;
    }

    public void setSgpa1(double sgpa1) {
        this.sgpa1 = sgpa1;
    }

    public double getSgpa2() {
        return sgpa2;
    }

    public void setSgpa2(double sgpa2) {
        this.sgpa2 = sgpa2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBeforeFee() {
        return beforeFee;
    }

    public void setBeforeFee(double beforeFee) {
        this.beforeFee = beforeFee;
    }

    public double getAfterFee() {
        return afterFee;
    }

    public void setAfterFee(double afterFee) {
        this.afterFee = afterFee;
    }

    protected double calculateCGPA() {
        return (sgpa1 + sgpa2) / 2;
    }

    protected void printBeforeFee() {
        System.out.println("YOUR BEFORE FEE IS " + this.beforeFee);
    }

    protected void printCGPA(double cgpa) {
        System.out.println("YOUR CGPA IS " + cgpa);
    }
}

class ASC extends Amrita {
    public ASC(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }

    @Override
    public double calculateFee() {
        double cgpa = calculateCGPA();
        printBeforeFee();
        printCGPA(cgpa);
        if (getBeforeFee() <= 250000) {
            if (cgpa < 10 && cgpa > 0) {
                if (cgpa >= 8.5) {
                    System.out.println("CONGRATS! YOU ARE ELIGIBLE FOR SCHOLARSHIP");
                    System.out.print("YOUR CURRENT FEE SLAB IS ");
                    if (cgpa >= 8) {
                        System.out.println("SLAB 1");
                        setAfterFee(150000);
                    } else if (cgpa >= 7.5) {
                        System.out.println("SLAB 2");
                        setAfterFee(250000);
                    }
                } else {
                    System.out.println("YOU ARE MOVED TO SLAB 3");
                    setAfterFee(400000);
                }
            }
        } else {
            System.out.println("YOURS IS NON-SCHOLARSHIP FEE");
            System.out.println("SO YOUR FEE IS " + getBeforeFee());
            setAfterFee(600000);
        }
        return getAfterFee();
    }
}

class CSE extends ASC {
    public CSE(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }
}

class CSEAI extends ASC {
    public CSEAI(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }
}

class CSECS extends ASC {
    public CSECS(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }
}

class CSEDA extends ASC {
    public CSEDA(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }
}

class ASE extends Amrita {
    public ASE(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }

    @Override
    public double calculateFee() {
        double cgpa = calculateCGPA();
        printBeforeFee();
        printCGPA(cgpa);
        if (getBeforeFee() <= 250000) {
            if (cgpa < 10 && cgpa > 0) {
                if (cgpa >= 8.5) {
                    System.out.println("CONGRATS! YOU ARE ELIGIBLE FOR SCHOLARSHIP");
                    System.out.print("YOUR CURRENT FEE SLAB IS ");
                    if (cgpa >= 8) {
                        System.out.println("SLAB 1");
                        setAfterFee(150000);
                    } else if (cgpa >= 7.5) {
                        System.out.println("SLAB 2");
                        setAfterFee(250000);
                    }
                } else {
                    System.out.println("YOU ARE MOVED TO SLAB 3");
                    setAfterFee(400000);
                }
            }
        } else {
            System.out.println("YOURS IS NON-SCHOLARSHIP FEE");
            System.out.println("SO YOUR FEE IS : " + getBeforeFee());
            setAfterFee(600000);
        }
        return getAfterFee();
    }
}

class ELC extends ASE {
    public ELC(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }
}

class EEE extends ASE {
    public EEE(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }
}

class RA extends ASE {
    public RA(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }
}

class RAI extends ASE {
    public RAI(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        super(roll_no, password, school, branch, sgpa1, sgpa2, beforeFee);
    }
}
