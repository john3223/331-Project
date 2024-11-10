/**
 * Square class.
 * IMPORTANT NOTE: I have decided that inheritance doesn't make much sense for different square types, so instead I'm
 * using an enum class for the different types.
 */
public class Square {
    private int number;
    private SquareType squareType;

    /**
     * Constructor.
     * @param number int
     * @param squareType GREEN, YELLOW, RED, HAZARD, WALL, or JACKPOT
     */
    public Square (int number, SquareType squareType) {
        this.squareType = squareType;

        //if the square type is HAZARD or WALL, the number should automatically be 0
        if (this.squareType == SquareType.HAZARD || this.squareType == SquareType.WALL){
            this.number = 0;
        }

        //otherwise, the number should be at least 1
        else {
            this.number = Math.max(1, number);
        }
    }

    /**
     * Accessor for number.
     * @return int
     */
    public int getNumber() {
        return number;
    }

    /**
     * Accessor for squareType.
     * @return SquareType
     */
    public SquareType getSquareType() {
        return squareType;
    }

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
}
