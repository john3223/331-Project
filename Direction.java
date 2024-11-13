public enum Direction {
    DOWN("D"), LEFT("L"), RIGHT("R"), UP("U");

    private String string;

    Direction(String string) {
        this.string = string;
    }
    @Override
    public String toString() {
        return this.string;
    }
}
