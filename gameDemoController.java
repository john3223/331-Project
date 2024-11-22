package com.example.gamedemo;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

public class gameDemoController {

    @FXML
    TextField scoreTextField, statusTextField;

    @FXML
    ToggleGroup difficulty;

    @FXML
    ToggleButton easyToggleButton, mediumToggleButton, hardToggleButton, volcanicToggleButton;

    @FXML
    GridPane squareGrid;

    @FXML
    Sphere player;

    Random random = new Random();

    private void fillGrid(GridPane squareGrid) {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 12; col++) {
                Square square = new Square(0, getRandomColor.getRandomValue(SquareType.class), new Rectangle(row, col, 50, 50));
                square.getSquare().setFill(Color.web(String.valueOf(square.getSquareType())));
                square.getSquare().setOnMouseClicked(event -> handleClick(event, square.getSquare()));

                TextField squareNum = new TextField(String.valueOf(square.getNumber()));
                squareNum.setEditable(false);
                squareNum.setMaxWidth(25);
                GridPane.setHalignment(squareNum, HPos.CENTER);
                //squareNum.setOnMouseClicked(event -> handleClick(event, squareNum));

                squareGrid.add(square.getSquare(), col, row);
                squareGrid.add(squareNum, col, row);
            }
        }

    }

    private void handleClick(MouseEvent event, Rectangle square) {

    }
    Node n ;
    private Node getLocation(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            int nCol = GridPane.getColumnIndex(node);
            int nRow = GridPane.getRowIndex(node);

            if (nCol == col && nRow == row) {
                n = node;
            }
        }
        return n;
    }


    @FXML
    public void initialize() {
        fillGrid(squareGrid);
        //Player display = new Player(random.nextInt(12), random.nextInt(7), player);


    }


    @FXML
    private void newGame(ActionEvent event) {
        initialize();
    }
}
/*
Player display = new Player(random.nextInt(12), random.nextInt(7), player);
        if (Integer.toString(0).equals(((TextField) getLocation(squareGrid, display.getxPosition(), display.getyPosition())).getText())) {
            initialize();
        } else {
            squareGrid.add(display.getPlayer(), display.getxPosition(), display.getyPosition());
        }
 */

