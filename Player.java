public class Player{

    private int xPosition;
    private int yPosition;


    //constructor
    Player(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    //method calling Move to make move
    public void makeMove(Move move){
        Move move = new Move();
    }

    //accessors
    public int getXPosition() {
        return xPosition;
    }
    public int getYPosition() {
        return yPosition;
    }

    //mutator
    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    @Override
    public String toString() {
        return super.toString() + "Position: " + xPosition + ", " + yPosition;
    }
}
