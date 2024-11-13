public class Move {
    private Direction direction;
    private int distance;

    public Move(Direction direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }
    public void setDirection(Direction direction) {this.direction = direction;}
    public void setDistance(int distance) {this.distance = distance;}

    public Direction getDirection() {return direction;}
    public int getDistance() {return distance;}

    @Override
    public String toString() {
        return String.format("%s%s%n%s%s%n", "Direction: ", getDirection(), "Distance: ", getDistance());
    }
}
