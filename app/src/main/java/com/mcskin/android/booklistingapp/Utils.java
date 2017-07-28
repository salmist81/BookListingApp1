package com.mcskin.android.booklistingapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class Utils {

    /**
     * Method to check if user input text is null
     *
     * @return true/false
     */
    public static boolean checkEmptyString(String input) {
        if (input.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method to check if user input text is valid
     *
     * @return true/false
     */
    public static boolean checkValidString(String input) {
        String patternName = "[a-zA-z.]+([ '-][a-zA-Z.]+)*";
        Pattern pattern = Pattern.compile(patternName);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This constructor hold static variables and methods,
     * which can be accessed directly from the class name Utils
     */
    private void Utils() {
    }

}
