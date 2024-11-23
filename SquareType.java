/**
 * ==============================================================================================
 * PROGRAM PURPOSE: Create enum of different colors in the GridPane.
 * ===============================================================================================
 */
package com.example.gamedemo;

public enum SquareType {
    GREEN("#3a942c"),
    YELLOW("#fcfc60"),
    RED("#d72a2a"),
    HAZARD("#f5a638"),
    WALL("#805b37"),
    JACKPOT("#528ec6");

    private final String text;

    SquareType(String text) {
        this.text = text;
    }

    public String getText() {return text;}

    // Create static method to return color web from hexadecimal.

    public static String getHex(String hex) {
        String answer = "#" + hex.substring(2, 8);
        return answer;
    }


    @Override
    public String toString() {
        return text;
    }
}
