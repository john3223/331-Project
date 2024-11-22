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

    public static SquareType getEnum(String text) {
        for (SquareType squareType : values()) {
            if (squareType.getText().equals(text)) {
                return squareType;
            }
        }
        throw new IllegalArgumentException("No enum constant");
    }

    @Override
    public String toString() {
        return text;
    }
}
