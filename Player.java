/**
 * ==============================================================================================
 * PROGRAM PURPOSE: Create player class with xPosition, yPositions, and a textfield
 * ===============================================================================================
 */
package com.example.gamedemo;

import javafx.scene.control.TextField;

public class Player {
    private int xPosition;
    private int yPosition;
    private TextField player;

    // player constructor
    public Player(int xPosition, int yPosition, TextField player) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.player = player;
    }

    // create accessors.
    public int getxPosition() {return xPosition;}
    public int getyPosition() {return yPosition;}
    public TextField getPlayer() {return player;}

    // create modifier for position
    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
    public void setPlayer(TextField player) {this.player = player;}
}
