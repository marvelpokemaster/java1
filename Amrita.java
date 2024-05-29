package com.mycompany.javaproject;
import java.util.*;

abstract class Amrita {
    private String roll_no;
    private String school;
    private String branch;
    private double sgpa1;
    private double sgpa2;
    double beforeFee;
    private String password;

    public Amrita(String roll_no, String password, String school, String branch, double sgpa1, double sgpa2, double beforeFee) {
        this.roll_no = roll_no;
        this.password = password;
        this.school = school;
        this.branch = branch;
        this.sgpa1 = sgpa1;
        this.sgpa2 = sgpa2;
        this.beforeFee = beforeFee;
    }

    public abstract void calculateFee();

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
    public void calculateFee() {
        double cgpa = calculateCGPA();
        printBeforeFee();
        printCGPA(cgpa);
        if (beforeFee <= 250000) {
            if (cgpa < 10 && cgpa > 0) {
                if (cgpa >= 8.5) {
                    System.out.println("CONGRATS! YOU ARE ELIGIBLE FOR SCHOLARSHIP");
                    System.out.print("YOUR CURRENT FEE SLAB IS ");
                    if (cgpa >= 8) {
                        System.out.println("SLAB 1");
                    } else if (cgpa >= 7.5) {
                        System.out.println("SLAB 2");
                    }
                } else {
                    System.out.println("YOU ARE MOVED TO SLAB 3");
                }
            }
        } else {
            System.out.println("YOURS IS NON-SCHOLARSHIP FEE");
            System.out.println("SO YOUR FEE IS " + beforeFee);
        }
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
    public void calculateFee() {
        double cgpa = calculateCGPA();
        printBeforeFee();
        printCGPA(cgpa);
        if (beforeFee <= 250000) {
            if (cgpa < 10 && cgpa > 0) {
                if (cgpa >= 7.5) {
                    System.out.println("CONGRATS! YOU ARE ELIGIBLE FOR SCHOLARSHIP");
                    System.out.print("YOUR CURRENT FEE SLAB IS ");
                    if (cgpa >= 8.5) {
                        System.out.println("SLAB 1");
                    } else if (cgpa >= 7.5) {
                        System.out.println("SLAB 2");
                    }
                } else {
                    System.out.println("YOU ARE MOVED TO SLAB 3");
                }
            }
        } else {
            System.out.println("YOURS IS NON-SCHOLARSHIP FEE");
            System.out.println("SO YOUR FEE IS " + beforeFee);
        }
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

