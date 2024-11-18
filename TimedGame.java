/**
 * The TimedGame class represents a game with a time limit.
 * Extends the Game class to include time-based functionality.
 */
public class TimedGame extends Game {
    private double timeLimit; // Time limit for the game in seconds

    /**
     * Constructor for TimedGame.
     * @param gridWidth Width of the game grid
     * @param gridHeight Height of the game grid
     * @param playerStartingXPosition Starting X position of the player
     * @param playerStartingYPosition Starting Y position of the player
     * @param difficulty The difficulty level of the game
     * @param timeLimit The time limit for the game in seconds
     */
    public TimedGame(int gridWidth, int gridHeight, int playerStartingXPosition, int playerStartingYPosition, Difficulty difficulty, double timeLimit) {
        super(gridWidth, gridHeight, playerStartingXPosition, playerStartingYPosition, difficulty);
        this.timeLimit = timeLimit;
    }

    /**
     * Gets the remaining time for the game.
     * @return The remaining time in seconds
     */
    public double getTimeRemaining() {
        double timeElapsed = getTimeElapsed();
        return Math.max(0, timeLimit - timeElapsed); // Ensure remaining time is non-negative
    }

    /**
     * Overrides makeMove to include a time check before processing a move.
     * @param move The Move object representing the player's direction and distance
     */
    @Override
    public void makeMove(Move move) {
        if (getTimeRemaining() <= 0) { // Check if time has run out
            setGameOver(true);
            System.out.println("Time's up! Game over.");
        } else {
            super.makeMove(move); // Otherwise, process the move as usual
        }
    }

    @Override
    public String toString() {
        return String.format("%sTime Remaining: %.2f seconds%n", super.toString(), getTimeRemaining());
    }
}
