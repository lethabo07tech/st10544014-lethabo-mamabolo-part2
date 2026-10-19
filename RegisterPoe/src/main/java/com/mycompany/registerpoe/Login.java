/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerpoe;

/**
 *
 * @author letha
 */
public class Login {
    // Store registered credentials
    private String registeredFirstName;
    private String registeredLastName;
    private String registeredUsername;
    private String registeredPassword;

    // Store login result
    private boolean loginSuccessful;

    // Username requirement validation
    public boolean checkUserName(String username) {
        return username.length() <= 5
                && username.contains("_");
    }

    // Password requirement validation
    public boolean checkPasswordComplexity(String password) {

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[^a-zA-Z0-9].*")
                && password.matches(".*[0-9].*");
    }

    // Cell phone requirement validation
    public boolean checkCellPhoneNumber(String cellPhone) {
        return cellPhone.matches("\\+27\\d{9}");
    }

    // Register user and display errors
    public String registerUser(
            String username, String password, String cellPhone, String firstName, String lastName) {

        // Username conditional errors
        if (username.length() > 5) {
            System.out.println("Username must be 5 characters or less");
        } else if (!username.contains("_")) {
            System.out.println("Username must contain an underscore");
        } else {
            System.out.println("Username successfully captured");
        }

        // Password conditional errors
        if (password.length() < 8) {
            return "Password must be at least 8 characters long";
        } else if (!password.matches(".*[A-Z].*")) {
            return "Password must contain an uppercase letter";
        } else if (!password.matches(".*[a-z].*")) {
            return "Password must contain a lowercase letter";
        } else if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return "Password must contain a special character";
        } else if (!password.matches(".*[0-9].*")) {
            return "Password must contain a number";
        } else {
            System.out.println("Password successfully captured");
        }

        // Cell phone number conditional errors
        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cellphone must start with +27 and have 9 digits after it";
        } else {
            System.out.println("Cell phone successfully captured");
        }

        // Save credentials after successful validation
        registeredUsername = username;
        registeredPassword = password;
        registeredFirstName = firstName;
        registeredLastName = lastName;

        return "Account successfully registered";

    }

    // Verify login credentials
    // Compare login details with registered details
    public boolean loginUser(String username, String password) {

        loginSuccessful = username.equals(registeredUsername)
                && password.equals(registeredPassword);

        return loginSuccessful;
    }

    // Return the necessary login message
    public String returnLoginStatus() {

        if (loginSuccessful) {
            return"Login successful. Welcome! "  + registeredFirstName + " " + registeredLastName + " it is great to see you!";
        } else {
            return "Login failed. Username or Password incorrect";
        }
    }
    
}
