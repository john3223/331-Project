/**
 * Enum for different square types. We haven't used enum types much.
 */
public enum SquareType {
    GREEN("Green"),
    YELLOW("Yellow"),
    RED("Red"),
    HAZARD("Hazard"),
    WALL("Wall"),
    JACKPOT("Jackpot");

    private final String text;

    SquareType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
