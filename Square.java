/**
 * ==============================================================================================
 * PROGRAM PURPOSE: Create square class that has a number, squareType, and a rectangle.
 * ===============================================================================================
 */
package com.example.gamedemo;

import javafx.scene.shape.Rectangle;
import java.util.Random;
import javafx.scene.paint.Color;

public class Square {

    private int number;
    private SquareType squareType;
    private Rectangle square;

    /**
     * Constructor.
     * @param number int
     * @param squareType GREEN, YELLOW, RED, HAZARD, WALL, or JACKPOT
     */

    public Square (int number, SquareType squareType, Rectangle square) {
        // use getRandomColor to assign random squareType
        this.squareType = getRandomColor.getRandomValue(SquareType.class);
        this.square = square;

        Random random = new Random();

        //if the square type is WALL, the number should automatically be 0
        if (this.squareType == SquareType.WALL){
            this.number = 0;
        }

        //otherwise, the number should be at least 1
        else if (this.squareType == SquareType.YELLOW || this.squareType == SquareType.RED ||
        this.squareType == SquareType.GREEN || this.squareType == SquareType.HAZARD){
            this.number = random.nextInt(1, 5);
        }
        // Jackpots have larger numbers.
        else {
            this.number = random.nextInt(5, 8);
        }
    }

    /**
     * Accessor for number, square, and squareType.
     * @return int, @return square, @return SquareType
     */
    public int getNumber() {
        return number;
    }
    public Rectangle getSquare() {
        return square;
    }
    public SquareType getSquareType() {
        return squareType;
    }

    /**
     * set number, square, and squareType.
     */
    public void setNumber(int number) {this.number=number;}
    public void setSquare(Rectangle square) {this.square = square;}
    public void setSquareType(SquareType squareType) {this.squareType = squareType;}

    /**
     * This will be used when the player moves to change the square they were on to a hazard square.
     */
    public static void toHazard (Rectangle doneSquare) {
        doneSquare.setFill(Color.web("#f5a638"));
    }

    /**
     * Overridden toString.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Type: %s%nNumber: %d%n", squareType, number);
    }

}
