/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart3;

import java.nio.file.Path;
import javax.swing.JOptionPane;

/**
 * Screen-driven message features: sending messages, message management and
 * the arrays/manager used by the Stored Messages menu.
 */
public class Message {

    public MessageManager getManager() {
        return null;
    }

    /** Main menu option 1 - capture and send / store / disregard messages. */
    public void sendingMessages() {
        String countInput = JOptionPane.showInputDialog(null, "How many messages do you want to enter?");
        if (countInput == null) {
            return;
        }
        int count;
        try {
            count = Integer.parseInt(countInput.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number", "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (int i = 1; i <= count; i++) {
            String recipient = JOptionPane.showInputDialog(null, "Message " + i + " - enter the recipient's cell number:");
            if (recipient == null) {
                return;
            }
            recipient = recipient.trim();
            if (!recipient.matches("^(\\+27|0)\\d{9}$")) {
                JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                i--;
                continue;
            }

            String text = JOptionPane.showInputDialog(null, "Enter your message (max 250 characters):");
            if (text == null) {
                return;
            }
            text = text.trim();
            if (text.isEmpty() || text.length() > 250) {
                JOptionPane.showMessageDialog(null,
                        "Message must be between 1 and 250 characters.", "Error", JOptionPane.ERROR_MESSAGE);
                i--;
                continue;
            }

            String[] choices = {"Send", "Store", "Disregard"};
            int pick = JOptionPane.showOptionDialog(null, "What would you like to do with this message?",
                    "Message " + i, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
            String flag;
            if (pick == 1) {
                flag = MessageManager.STORED;
            } else if (pick == 2) {
                flag = MessageManager.DISREGARD;
            } else {
                flag = MessageManager.SENT;
            }

            MessageRecord m = manager.addMessage(recipient, text, flag);
            JOptionPane.showMessageDialog(null,
                    "Message " + flag.toLowerCase() + "\nMessage ID: " + m.getId()
                    + "\nMessage Hash: " + m.getHash()
                    + "\nRecipient: " + m.getRecipient()
                    + "\nMessage: " + m.getText());
        }
    }

    /** Main menu option 2 - message management. */
    public void messageManagementMenu() {
        boolean back = false;
        while (!back) {
            String menu = "===== Message Management ====="
                    + "\n1. Display sent messages report"
                    + "\n2. Total messages sent"
                    + "\n3. Load test data"
                    + "\n4. Back";
            String input = JOptionPane.showInputDialog(null, menu, "Message Management",
                    JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                return;
            }
            switch (input.trim()) {
                case "1" -> JOptionPane.showMessageDialog(null, manager.displayReport(), "Report",
                        JOptionPane.INFORMATION_MESSAGE);
                case "2" -> JOptionPane.showMessageDialog(null,
                        "Total messages sent: " + manager.getSentMessages().size());
                case "3" -> {
                    manager.loadTestData();
                    JOptionPane.showMessageDialog(null, "Test data loaded into the arrays.");
                }
                case "4" -> back = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option!!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /** Main menu option 4 - Stored Messages. */
    public void storedMessagesMenu(String senderName) {
        MessageManager manager = null;
        StoredMessagesMenu.run(manager, senderName);
    }

    private static class StoredMessagesMenu {

        private static void run(MessageManager manager, String senderName) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public StoredMessagesMenu() {
        }
    }
}