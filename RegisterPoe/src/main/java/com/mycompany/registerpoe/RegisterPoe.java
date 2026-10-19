/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registerpoe;


import java.util.Scanner;

/**
 *
 * @author letha
 */
public class RegisterPoe {
       public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Creating an object for the Login class
        // The main class uses account to call Login methods
        Login account = new Login();

        // Create a new account
        // First name
        System.out.println("Register a new account");
        System.out.print("Enter your First Name: ");
        String firstName = input.nextLine();

        // Last name
        System.out.print("Enter your Last Name: ");
        String lastName = input.nextLine();

        // Username
        System.out.print("Enter your Username (must contain an underscore and be 5 or less in characters): ");
        String username = input.nextLine();

        // Cell phone number
        System.out.print("Enter your Cell Phone Number (should start with +27 and have 9 digits after it): ");
        String cellPhone = input.nextLine();

        // Password
        System.out.print("Enter your Password (must include uppercase, lowercase, special character, and a number): ");
        String password = input.nextLine();

        // Send registration details to the Login class
        // Store the returned registration message
        String registrationMessage =
                account.registerUser(username, password, cellPhone, firstName, lastName);

        // Display the registration result
        System.out.println(registrationMessage);

        // Only continue if registration was successful
        if (registrationMessage.equals("Account successfully registered")) {

            // Login to the registered account
            System.out.println("Login to your account");

            // Ask for the login username
            System.out.print("Enter your Username: ");
            String loginUsername = input.nextLine();

            // Ask for the login password
            System.out.print("Enter your Password: ");
            String loginPassword = input.nextLine();

            // Display the login result
           // System.out.println(account.returnLoginStatus());
            boolean status = account.loginUser(loginUsername, loginPassword);
            
            if(status){
            
                
                System.out.println("\nWELCOME TO QUICKCHAT");
                System.out.println("Choose one option below");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                                   
                                  
                System.out.println("Select Option: ");
                
                int selection = input.nextInt();
                input.nextLine();
                
                switch (selection) {
                    
                    case 1:
                        System.out.println("How many messages do you want to send");
                        
                        int total = input.nextInt();
                        input.nextLine();
                        
                        for (int i = 1; i <= total; i++) {
                            
                            System.out.println("\n MESSAGE " + i);
                            System.out.print("Enter recipient number: ");
                            String recipient = input.nextLine();
                            
                            System.out.print("Enter Message: ");
                            String messageText = input.nextLine();
                            
                            if (messageText.length() > 250) {
                                System.out.println("ENter message less than 250 characters: ");
                                i--;
                                continue;
                            }
                            Message msg = new Message(i, recipient, messageText);
                            
                            if (msg.checkMessageID()) {
                                System.out.println("Message ID created successfully");
                            }
                            
                            System.out.println(msg.checkRecipientCell());
                            System.out.println("Message Hash: " + msg.createMessageHash());
                            System.out.println(msg.sentMessage());
                            System.out.println(msg.printMessages());  
                        }
                        
                        System.out.println("\n Total number of messages sent: " + Message.returnTotalMessages());
                        break;
                        
                    case 2: 
                        
                        System.out.println("STORED MESSAGE OPTIONS");
                        System.out.println("a) Display Sender and Recipient");
                        System.out.println("b) Display Longest Message");
                        System.out.println("c) Search Message ID");
                        System.out.println("d) Search Recipient");
                        System.out.println("e) Delete Message using Hash");
                        
                        System.out.println("Select option: ");
                        
                        String choiceSelection = input.nextLine().toLowerCase();
                        
                        switch (choiceSelection) {
                            
                            case "a":
                                //MessageReport.displaySenderRecipient();
                                System.out.println("Coming Soon");
                                break;
                                
                            case "b":
                                //MessageReport.displayLongestMessage();
                                System.out.println("Coming Soon");
                                break;
                                
                            case "c":
                                System.out.println("Enter Meaaage ID: ");
                                String id = input.nextLine();
                                //letMessageReport.searchRecipient(recipientSearch);
                            
                        }
                        
                }
            }
        }

        // Close the scanner after all input is finished
        input.close();
    }
}