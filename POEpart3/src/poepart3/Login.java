/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart3;

/**
 *
 * @author Student
 */
class Login {

   
    private String registeredUser;
    private String registeredPassword;

    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean upper = false;
        boolean digit = false;
        boolean special = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                special = true;
            }
        }
        return upper && digit && special;
    }

    public boolean checkCellPhoneNumber(String cellphone) {
        return cellphone != null && cellphone.matches("^\\+27\\d{9}$");
    }

    /** True when username, password and cellphone are all valid. */
    public boolean registerStatus(String username, String password, String cellphone) {
        return checkUserName(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(cellphone);
    }

    /** Returns the message to show the user and remembers the details when valid. */
    public String registerUser(String username, String password, String cellphone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an "
                    + "underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least "
                    + "eight characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(cellphone)) {
            return "Cell phone number incorrectly formatted or does not contain international code "
                    + "(e.g. +27831234567).";
        }
        registeredUser = username;
        registeredPassword = password;
        return "Username successfully captured.\nPassword successfully captured.\n"
                + "Cell phone number successfully added.\nUser registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        return registeredUser != null && registeredUser.equals(username)
                && registeredPassword != null && registeredPassword.equals(password);
    }

    public String returnLoginStatus(boolean loggedIn) {
        return loggedIn ? "Welcome, it is great to see you again."
                : "Username or password incorrect, please try again.";
    }
}

