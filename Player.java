package com.example.gamedemo;

import javafx.scene.shape.Sphere;

public class Player {
    private int xPosition;
    private int yPosition;
    private Direction direction;
    private Sphere player;

    public Player(int xPosition, int yPosition, Sphere player) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.player = player;
    }
    public void Move(Direction direction, Square square) {
        int distance = square.getNumber();
        switch (direction) {
            case RIGHT:
                this.yPosition += distance;
                break;
            case LEFT:
                this.yPosition -= distance;
                break;
            case UP:
                this.xPosition += distance;
                break;
            case DOWN:
                this.xPosition -= distance;
                break;
        }
    }
    public int getxPosition() {return xPosition;}
    public int getyPosition() {return yPosition;}
    public Sphere getPlayer() {return player;}

    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
    public void setPlayer(Sphere player) {this.player = player;}
}
