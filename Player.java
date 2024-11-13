.public class Player{

    private int xPosition;
    private int yPosition;


    //constructor
    Player(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    //method calling Move to make move
    public void makeMove(Move move){
        if(Move.getDirection.equals(direction.RIGHT)){
            this.yPosition + Move.getDistance() = move;
        }
        if(Move.getDirection.equals(direction.LEFT)){
            this.yPosition + Move.getDistance() = move;
        }
        if(Move.getDirection.equals(direction.UP)){
            this.xPosition + Move.getDistance() = move;
        }
        if(Move.getDirection.equals(direction.DOWN)){
            this.xPosition + Move.getDistance() = move;
        }
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
        return String.format("%s%d%s%d%n","Position: ", xPosition, ", " yPosition);
    }
}
