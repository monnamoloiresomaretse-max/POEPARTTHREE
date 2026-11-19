/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart3;

import javax.swing.JOptionPane;

/**
 *
 * @author Student
 */
public class POEpart3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Login register = new Login();
        Message msg = new Message();

        JOptionPane.showMessageDialog(null, "=====Register=====", "Registration",
                JOptionPane.INFORMATION_MESSAGE);

        String name = JOptionPane.showInputDialog(null, "Please enter the username: ");
        String password = JOptionPane.showInputDialog(null, "Please enter your password");
        String cellphone = JOptionPane.showInputDialog(null, "Please enter your phone number");
        String firstName = JOptionPane.showInputDialog(null, "Please enter your first name");
        String lastName = JOptionPane.showInputDialog(null, "Please enter your last name");

        JOptionPane.showMessageDialog(null, register.registerUser(name, password, cellphone));

        if (!register.registerStatus(name, password, cellphone)) {
            return;
        }
        JOptionPane.showMessageDialog(null, "=====Login=====", "Login",
                JOptionPane.INFORMATION_MESSAGE);

        String loginUserName = JOptionPane.showInputDialog(null, "Enter username to login");
        String loginPassword = JOptionPane.showInputDialog(null, "Enter password to login");

        boolean status = register.loginUser(loginUserName, loginPassword);

        JOptionPane.showMessageDialog(null, register.returnLoginStatus(status));

        if (status) {

            int option = 0;
            JOptionPane.showMessageDialog(null, "Welcome to quickchat " + firstName);

            do {
                String menu = "===== Select any of the option below ====="
                        + "\n1. Send message"
                        + "\n2. Message Management"
                        + "\n3. Exit"
                        + "\n4. Stored Messages"
                        + "\nSelect an option: ";

                String input = JOptionPane.showInputDialog(null,
                        menu,
                        "Main menu",
                        JOptionPane.QUESTION_MESSAGE);

                if (input == null) {
                    option = 3;
                } else {
                    try {
                        option = Integer.parseInt(input.trim());

                        switch (option) {
                            case 1 ->
                                msg.sendingMessages();

                            case 2 ->
                                msg.messageManagementMenu();

                            case 3 ->
                                JOptionPane.showMessageDialog(null, "Goodbye!!");

                            case 4 ->
                                msg.storedMessagesMenu(firstName + " " + lastName);

                            default ->
                                JOptionPane.showMessageDialog(null, "Invalid option!!", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException e) {
                        option = 0;
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid number",
                                "Input Error",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            } while (option != 3);
        }
    }
}


