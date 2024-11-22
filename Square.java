package com.example.gamedemo;

import javafx.scene.shape.Rectangle;
import java.util.Random;

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
        this.squareType = getRandomColor.getRandomValue(SquareType.class);
        this.square = square;

        //if the square type is HAZARD or WALL, the number should automatically be 0
        Random random = new Random();

        if (this.squareType == SquareType.HAZARD || this.squareType == SquareType.WALL){
            this.number = 0;
        }

        //otherwise, the number should be at least 1
        else if (this.squareType == SquareType.YELLOW || this.squareType == SquareType.RED ||
        this.squareType == SquareType.GREEN){
            this.number = random.nextInt(1, 5);
        }
        else {
            this.number = random.nextInt(5, 8);
        }
    }

    /**
     * Accessor for number.
     * @return int
     */
    public int getNumber() {
        return number;
    }
    public Rectangle getSquare() {
        return square;
    }

    /**
     * Accessor for squareType.
     * @return SquareType
     */
    public SquareType getSquareType() {
        return squareType;
    }

    public void setNumber(int number) {this.number=number;}
    public void setSquare(Rectangle square) {this.square = square;}
    public void setSquareType(SquareType squareType) {this.squareType = squareType;}
    /**
     * This will be used when the player moves to change the square they were on to a hazard square.
     */
    public void toHazard () {
        squareType = SquareType.HAZARD;
        number = 0;
    }

    /**
     * Overridden toString.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Type: %s%nNumber: %d%n", squareType, number);
    }

    public void ToHazard() {
        squareType = SquareType.HAZARD;
        number = 0;
    }

}
