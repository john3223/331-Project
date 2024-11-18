import java.time.Instant;

/**
 * The Game class represents a basic game with a player, grid, score, and game state.
 */
public class Game {
    private RandomGrid grid; // The grid where the game takes place
    private Player player; // The player object
    private int score; // The player's current score
    private boolean rumbling; // Indicates if the game is "rumbling" (special event state)
    private Instant startTime; // The start time of the game for tracking elapsed time
    private boolean gameOver; // Indicates whether the game is over

    /**
     * Constructor for the Game class.
     * @param gridWidth Width of the game grid
     * @param gridHeight Height of the game grid
     * @param playerStartingXPosition Starting X position of the player
     * @param playerStartingYPosition Starting Y position of the player
     * @param difficulty The difficulty level of the game
     */
    public Game(int gridWidth, int gridHeight, int playerStartingXPosition, int playerStartingYPosition, Difficulty difficulty) {
        // Initialize the game components
        this.grid = new RandomGrid(gridWidth, gridHeight, 0.3, 0.2, 0.2, 0.15, 0.15, 5); // Example weights for grid
        this.player = new Player(playerStartingXPosition, playerStartingYPosition); // Create a new player at the starting position
        this.score = 0; // Initialize score to 0
        this.rumbling = false; // Default rumbling state
        this.startTime = Instant.now(); // Record the start time of the game
        this.gameOver = false; // Game starts in an active state
        this.grid.initializeGrid(); // Populate the grid with squares
    }

    /**
     * Getter for the game grid.
     * @return The RandomGrid object
     */
    public RandomGrid getGrid() {
        return grid;
    }

    /**
     * Getter for the player.
     * @return The Player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter for the current score.
     * @return The current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Checks if the game is rumbling (a special event).
     * @return true if rumbling, false otherwise
     */
    public boolean isRumbling() {
        return rumbling;
    }

    /**
     * Checks if the game is over.
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Sets the rumbling state of the game.
     * @param rumbling The new rumbling state
     */
    public void setRumbling(boolean rumbling) {
        this.rumbling = rumbling;
    }

    /**
     * Ends the game.
     * @param gameOver Set to true to indicate the game is over
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * Processes a player's move.
     * @param move The Move object representing the player's direction and distance
     */
    public void makeMove(Move move) {
        if (!gameOver) { // Only process moves if the game is not over
            player.makeMove(move);

            // Get the player's new position
            int x = player.getXPosition();
            int y = player.getYPosition();

            // Check if the move is out of bounds
            if (x < 0 || x >= grid.getHeight() || y < 0 || y >= grid.getWidth()) {
                System.out.println("Move out of bounds!");
                gameOver = true; // End the game if out of bounds
                return;
            }

            // Retrieve the square at the player's new position
            Square currentSquare = grid.grid[x][y];

            // Process the square type and update the game state
            if (currentSquare != null) {
                switch (currentSquare.getSquareType()) {
                    case GREEN -> increaseScore(currentSquare.getNumber()); // Green square adds score
                    case YELLOW -> increaseScore(currentSquare.getNumber() * 2); // Yellow square doubles score
                    case RED -> increaseScore(currentSquare.getNumber() * 3); // Red square triples score
                    case HAZARD -> setGameOver(true); // Hazard square ends the game
                    case WALL -> System.out.println("Wall encountered! Move invalid."); // Wall blocks movement
                }

                // Convert the square the player moved from into a hazard
                grid.toHazard(x, y);
            }
        }
    }

    /**
     * Increases the player's score.
     * @param points The number of points to add
     */
    public void increaseScore(int points) {
        this.score += points;
    }

    /**
     * Calculates the time elapsed since the game started.
     * @return The elapsed time in seconds
     */
    public double getTimeElapsed() {
        return (double) (Instant.now().toEpochMilli() - startTime.toEpochMilli()) / 1000;
    }

    /**
     * Resets the game's start time.
     */
    public void resetTime() {
        this.startTime = Instant.now();
    }

    @Override
    public String toString() {
        return String.format("Score: %d%nRumbling: %b%nGame Over: %b%n", score, rumbling, gameOver);
    }
}

