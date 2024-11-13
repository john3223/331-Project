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
        ;
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


    //public void toHazard(int i, int j) {


    //public String toString() {
