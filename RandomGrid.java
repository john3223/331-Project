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


    public void toHazard(int i, int j) {
        if (i >= 0) {
            if (i < height) {
                if (j >= 0) {
                    if (j < width) {
                        if (grid[i][j] != null) {
                            grid[i][j].setToHazard();
                        }
                    }
                }
            }
        }
    }

    // Function to initialize the grid
    public void initializeGrid() {
        Random random = new Random();

        // Calculate total weight for non-jackpot squares
        double totalWeight = greenWeight + yellowWeight + redWeight + hazardWeight + wallWeight;

        //Jackpot squares
        for (int k = 0; k < jackpots; k++) {
            int i, j;
            do {
                i = random.nextInt(height);
                j = random.nextInt(width);
            } while (grid[i][j] != null); 
            grid[i][j] = new Square(0, SquareType.JACKPOT); 
        }

        // Initializing the remaining grid
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == null) { // Skip if already assigned as a jackpot
                    double randValue = random.nextDouble() * totalWeight;
                    if (randValue < greenWeight) {
                        grid[i][j] = new Square(random.nextInt(10) + 1, SquareType.GREEN); 
                    } else if (randValue < greenWeight + yellowWeight) {
                        grid[i][j] = new Square(random.nextInt(10) + 1, SquareType.YELLOW);
                    } else if (randValue < greenWeight + yellowWeight + redWeight) {
                        grid[i][j] = new Square(random.nextInt(10) + 1, SquareType.RED);
                    } else if (randValue < greenWeight + yellowWeight + redWeight + hazardWeight) {
                        grid[i][j] = new Square(0, SquareType.HAZARD); 
                    } else {
                        grid[i][j] = new Square(0, SquareType.WALL); 
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Grid Dimensions: %dx%d%nGreen Weight: %.2f%nYellow Weight: %.2f%nRed Weight: %.2f%nHazard Weight: %.2f%nWall Weight: %.2f%nJackpots: %d",
            width, height, greenWeight, yellowWeight, redWeight, hazardWeight, wallWeight, jackpots);
    }

