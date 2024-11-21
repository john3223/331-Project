import java.util.Random;

public class RandomGrid {
    private int width;
    private int height;
    private double greenWeight;
    private double yellowWeight;
    private double redWeight;
    private double hazardWeight;
    private double wallWeight;
    private int jackpots;
    private Square[][] grid;

    // Constructor to initialize the grid with the specified parameters
    public RandomGrid(int width, int height, double greenWeight, double yellowWeight, double redWeight, double hazardWeight, double wallWeight, int jackpots) {
        this.width = width;
        this.height = height;
        this.greenWeight = greenWeight;
        this.yellowWeight = yellowWeight;
        this.redWeight = redWeight;
        this.hazardWeight = hazardWeight;
        this.wallWeight = wallWeight;
        this.jackpots = jackpots;
        this.grid = new Square[height][width];
    }

    // Getters for the grid properties
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getGreenWeight() {
        return greenWeight;
    }

    public double getYellowWeight() {
        return yellowWeight;
    }

    public double getRedWeight() {
        return redWeight;
    }

    public double getHazardWeight() {
        return hazardWeight;
    }

    public double getWallWeight() {
        return wallWeight;
    }

    public int getJackpots() {
        return jackpots;
    }

    // Method to adjust difficulty and change square weights accordingly
    public void adjustDifficulty(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                greenWeight = 0.5;
                yellowWeight = 0.3;
                redWeight = 0.1;
                hazardWeight = 0.05;
                wallWeight = 0.05;
                break;
            case "medium":
                greenWeight = 0.3;
                yellowWeight = 0.3;
                redWeight = 0.2;
                hazardWeight = 0.1;
                wallWeight = 0.1;
                break;
            case "hard":
                greenWeight = 0.2;
                yellowWeight = 0.2;
                redWeight = 0.3;
                hazardWeight = 0.15;
                wallWeight = 0.15;
                break;
            case "volcanic":
                greenWeight = 0.1;
                yellowWeight = 0.1;
                redWeight = 0.3;
                hazardWeight = 0.2;
                wallWeight = 0.3;
                break;
            default:
                // Default to medium if no valid difficulty is provided
                greenWeight = 0.3;
                yellowWeight = 0.3;
                redWeight = 0.2;
                hazardWeight = 0.1;
                wallWeight = 0.1;
                break;
        }
    }

    // Function to initialize the grid based on adjusted weights
    public void initializeGrid() {
        Random random = new Random();

        // Calculate total weight for non-jackpot squares
        double totalWeight = greenWeight + yellowWeight + redWeight + hazardWeight + wallWeight;

        // Jackpot squares
        for (int k = 0; k < jackpots; k++) {
            int i, j;
            do {
                i = random.nextInt(height);
                j = random.nextInt(width);
            } while (grid[i][j] != null);  // Skip if the square is already assigned
            grid[i][j] = new Square(0, SquareType.JACKPOT);  // Assign jackpot to the square
        }

        // Initializing the remaining grid
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == null) { // Skip if already assigned as a jackpot
                    double randValue = random.nextDouble() * totalWeight;

                    // Assign square types based on random value and weight distribution
                    if (randValue < greenWeight) {
                        grid[i][j] = new Square(random.nextInt(10) + 1, SquareType.GREEN); // Random number 1-10
                    } else if (randValue < greenWeight + yellowWeight) {
                        grid[i][j] = new Square(random.nextInt(10) + 1, SquareType.YELLOW);
                    } else if (randValue < greenWeight + yellowWeight + redWeight) {
                        grid[i][j] = new Square(random.nextInt(10) + 1, SquareType.RED);
                    } else if (randValue < greenWeight + yellowWeight + redWeight + hazardWeight) {
                        grid[i][j] = new Square(0, SquareType.HAZARD); // Number automatically set to 0
                    } else {
                        grid[i][j] = new Square(0, SquareType.WALL); // Number automatically set to 0
                    }
                }
            }
        }
    }

    // Method to convert a square to a hazard (useful when a player lands on a square)
    public void toHazard(int i, int j) {
        if (i >= 0 && i < height && j >= 0 && j < width) {
            if (grid[i][j] != null) {
                grid[i][j].setToHazard();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Grid Dimensions: %dx%d%nGreen Weight: %.2f%nYellow Weight: %.2f%nRed Weight: %.2f%nHazard Weight: %.2f%nWall Weight: %.2f%nJackpots: %d",
            width, height, greenWeight, yellowWeight, redWeight, hazardWeight, wallWeight, jackpots);
    }
}
