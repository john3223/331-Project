/**
 * ==============================================================================================
 * PROGRAM PURPOSE: Create game controller.
 * ===============================================================================================
 */
package com.example.gamedemo;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;

// import static methods from other classes
import static com.example.gamedemo.Square.toHazard;
import static com.example.gamedemo.SquareType.getHex;


public class gameDemoController {

    // create FXML fields
    @FXML
    TextField scoreTextField, statusTextField;


    @FXML
    GridPane squareGrid;

    @FXML
    TextField player;


    Random random = new Random();

    // create fillGrid method to add a square to each grid position
    private void fillGrid(GridPane squareGrid) {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 12; col++) {
                // create new Square instance.
                Square square = new Square(0, getRandomColor.getRandomValue(SquareType.class), new Rectangle(row, col, 50, 50));
                // set the rectangle fill to the random color assigned to the square.
                square.getSquare().setFill(Color.web(String.valueOf(square.getSquareType())));

                // set TextField to the number assigned to the Square and adjust layout and properties.
                TextField squareNum = new TextField(String.valueOf(square.getNumber()));
                squareNum.setEditable(false);
                squareNum.setMaxWidth(25);
                GridPane.setHalignment(squareNum, HPos.CENTER);

                // add rectangle and TextField to the grid
                squareGrid.add(square.getSquare(), col, row);
                squareGrid.add(squareNum, col, row);
            }
        }
    }

    // make method to get Rectangle from the location of the Player
    Rectangle R ;
    private Rectangle getLocation(GridPane gridPane, int col, int row) {
        // parse through nodes in the GridPane.
        for (Node node : gridPane.getChildren()) {
            // get the index and column for the node
            int nCol = GridPane.getColumnIndex(node);
            int nRow = GridPane.getRowIndex(node);

            // set Rectangle to R if the columns and integers are equal.
            if (nCol == col && nRow == row && node instanceof Rectangle) {
                R = (Rectangle) node;
            }
        }
        return R;
    }
    // create method to get the TextField from the Player location.
    static TextField T;
    public static TextField getLocText(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            int nCol = GridPane.getColumnIndex(node);
            int nRow = GridPane.getRowIndex(node);

            if (nCol == col && nRow == row && node instanceof TextField) {
                T = (TextField) node;
            }
        }
        return T;
    }

    Player player1;
    int score;

    // initialize the game.
    @FXML
    public void initialize() {
        //fill grid
        fillGrid(squareGrid);

        // add player to grid location that doesn't have 0 as a number
        do {
            player1 = new Player(random.nextInt(12), random.nextInt(7), player);
        } while (getHex(((getLocation(squareGrid, player1.getxPosition(), player1.getyPosition())).getFill()).toString()).equals("#f5a638") ||
                getHex(((getLocation(squareGrid, player1.getxPosition(), player1.getyPosition())).getFill()).toString()).equals("#805b37"));

        // turn the square where the player landed into a hazard.
        toHazard(getLocation(squareGrid, player1.getxPosition(), player1.getyPosition()));

        // set the Rectangle color to black.
        Rectangle glowR = getLocation(squareGrid, player1.getxPosition(), player1.getyPosition());
        glowR.setFill(Color.BLACK);

        // set score to 0 and display score in the TextField.
        score = 0;
        scoreTextField.setText(String.valueOf(score));
    }
    // if newGame button is pressed, initialize the game.
    @FXML
    private void newGame(ActionEvent event) {
        initialize();
    }

    // if left button is pressed, move the player to the left depending on the number the square has.
    @FXML
    private void leftButtonClicked(ActionEvent event) {

        // get the TextBox location of player1, and find the assigned number (distance)
        String player1Loc = getLocText(squareGrid, player1.getxPosition(), player1.getyPosition()).getText();
        int distance = Integer.parseInt(player1Loc);

        // get the target location by subtracting the distance from the x-coordinate of the player.
        int playerTarget = player1.getxPosition() - distance;

        // get location of target's TextBox
        String toSquare = getLocText(squareGrid, playerTarget, player1.getyPosition()).getText();

        // if the target's coordinate is > 0, and the number is not 0, move the player.
        if (playerTarget >= 0 && Integer.parseInt(toSquare) != 0) {

            //set the player location's text to 0
            getLocText(squareGrid, player1.getxPosition(), player1.getyPosition()).setText(String.valueOf(0));
            // set the new location of the player
            player1.setPosition(playerTarget, player1.getyPosition());
            // set new location's rectangle to black
            getLocation(squareGrid, playerTarget, player1.getyPosition()).setFill(Color.BLACK);

            // increase the score and display the new score
            score += distance;
            scoreTextField.setText(String.valueOf(score));
        }
    }

    /**
     * Use logic from leftButtonClicked to create the other ActionEvent methods.
     * Change the coordinates and playerTarget equation based on the directions
     */

    @FXML
    private void rightButtonClicked(ActionEvent event) {
        String player1Loc = getLocText(squareGrid, player1.getxPosition(), player1.getyPosition()).getText();
        int distance = Integer.parseInt(player1Loc);

        // add distance to x-coordinate
        int playerTarget = player1.getxPosition() + distance;
        String toSquare = getLocText(squareGrid, playerTarget, player1.getyPosition()).getText();

        if (playerTarget >= 0 && Integer.parseInt(toSquare) != 0) {

            getLocText(squareGrid, player1.getxPosition(), player1.getyPosition()).setText(String.valueOf(0));

            player1.setPosition(playerTarget, player1.getyPosition());

            getLocation(squareGrid, playerTarget, player1.getyPosition()).setFill(Color.BLACK);

            score += distance;
            scoreTextField.setText(String.valueOf(score));
        }

    }
    @FXML
    private void upButtonClicked(ActionEvent event) {
        String player1Loc = getLocText(squareGrid, player1.getxPosition(), player1.getyPosition()).getText();
        int distance = Integer.parseInt(player1Loc);

        // subtract distance from y-coordinates
        int playerTarget = player1.getyPosition() - distance;
        String toSquare = getLocText(squareGrid, player1.getxPosition(), playerTarget).getText();

        if (playerTarget >= 0 && Integer.parseInt(toSquare) != 0) {

            getLocText(squareGrid, player1.getxPosition(), player1.getyPosition()).setText(String.valueOf(0));

            // set position, and replace the player's y-coordinate with playerTarget
            player1.setPosition(player1.getxPosition(), playerTarget);

            getLocation(squareGrid, player1.getxPosition(), playerTarget).setFill(Color.BLACK);

            score += distance;
            scoreTextField.setText(String.valueOf(score));
        }

    }
    @FXML
    private void downButtonClicked(ActionEvent event) {
        String player1Loc = getLocText(squareGrid, player1.getxPosition(), player1.getyPosition()).getText();
        int distance = Integer.parseInt(player1Loc);

        // add distance to player's y-coordinate.
        int playerTarget = player1.getyPosition() + distance;
        String toSquare = getLocText(squareGrid, player1.getxPosition(), playerTarget).getText();

        if (playerTarget >= 0 && Integer.parseInt(toSquare) != 0) {

            getLocText(squareGrid, player1.getxPosition(), player1.getyPosition()).setText(String.valueOf(0));

            player1.setPosition(player1.getxPosition(), playerTarget);

            getLocation(squareGrid, player1.getxPosition(), playerTarget).setFill(Color.BLACK);

            score += distance;
            scoreTextField.setText(String.valueOf(score));
        }

    }
}


