package com.mycompany.javaproject;

import javax.swing.*;

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
        submitButton.addActionListener(e -> {
            String username = registerForm.getJuser1();
            String password = registerForm.getJpassword1();
            String sgpa1 = registerForm.getSgpa1();
            String sgpa2 = registerForm.getSgpa2();
            String beforeFee = registerForm.getBeforeFee();
            String school = registerForm.getSchool();
            String branch = registerForm.getBranch();

            if (username.isEmpty() || password.isEmpty() || sgpa1.isEmpty() || sgpa2.isEmpty() || beforeFee.isEmpty() || school.isEmpty() || branch.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required.");
            } else {
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("SGPA1: " + sgpa1);
                System.out.println("SGPA2: " + sgpa2);
                System.out.println("Before Fee: " + beforeFee);
                System.out.println("School: " + school);
                System.out.println("Branch: " + branch);
            }
        });
    }

    private static boolean isUser(String username, String password) {
        return "am.sc.u4cse23203".equals(username) && "password".equals(password);
    }
    private static boolean isAdmin(String username, String password) {
        return "admin".equals(username) && "adminpassword".equals(password);
    }
}
