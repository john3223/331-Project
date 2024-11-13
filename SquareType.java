/**
 * Enum for different square types. We haven't used enum types much.
 */
public enum SquareType {
    GREEN("G"),
    YELLOW("Y"),
    RED("R"),
    HAZARD("H"),
    WALL("W"),
    JACKPOT("J");

    private final String text;

    SquareType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
