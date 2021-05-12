package Game;


import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * Class for controlling the game and creating the ui design
 */
public class GameController {
    /**
     * Size of the game board
     */
    private final int BOARD_SIZE=6;

    @FXML
    private GridPane board;

    /**
     * Method that initialize the default state of the game
     */
    @FXML
    private void initialize() {
        createLabel();
        createCircle(1, 4);

        board.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT -> moveLeft();
                    case RIGHT -> moveRight();
                    case UP -> moveUp();
                    case DOWN -> moveDown();
                }
            }
        });
    }


    /**
     *
     * @param row The row index of the circle
     * @param col The column index of the circle
     * @return Creates a circle on the given position
     */
    private Circle createCircle(int row, int col) {
        var circle = new Circle(35);
        circle.setFill(Color.BLUE);
        board.add(circle, col, row);
        return circle;

    }

    /**
     * @return Creates a Label object on the given position
     */
    private Label createLabel() {
        var label = new Label();
        label.setText("CÉL");
        label.getStyleClass().add("label");
        board.add(label, 2, 5);

        return label;
    }

    /**
     * The ball move left until it meets a wall or the edge of the board
     */
    private void moveLeft() {

        var circle = board.getChildren().get(36);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);

        while (col>0) {
            if(getNodeFromGridPane(board,col,row).toString().equals("bal")||getNodeFromGridPane(board,col,row).toString().equals("jobbbal")) {
                break;
            }
            else if(isGoal()||!validMove()){
               break;
            }
            else {

                GridPane.setColumnIndex(circle, col - 1);
                col = GridPane.getColumnIndex(circle);
            }

        }


        System.out.printf("Circle moved to (%d,%d)\n", row, col);

    }
    /**
     * The ball move right until it meets a wall or the edge of the board
     */
    private void moveRight() {

        var circle = board.getChildren().get(36);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);

        while (col<6) {
            if(getNodeFromGridPane(board,col,row).toString().equals("jobb")||getNodeFromGridPane(board,col,row).toString().equals("lentjobb")|| getNodeFromGridPane(board,col,row).toString().equals("jobbbal")) {
               break;
            }
            else if(isGoal()||!validMove()){
                break;
            }
            else {

                GridPane.setColumnIndex(circle, col + 1);


                col = GridPane.getColumnIndex(circle);
            }


        }
        System.out.printf("Circle moved to (%d,%d)\n", row, col);

    }

    /**
     * The ball move up until it meets a wall or the edge of the board
     */
    private void moveUp() {

        var circle = board.getChildren().get(36);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);


        while (row>0) {

            if(getNodeFromGridPane(board,col,row).toString().equals("fent")){
                break;
                }
            else if(isGoal()||!validMove()){
                break;
            }


            else {

                GridPane.setRowIndex(circle, row - 1);

                row = GridPane.getRowIndex(circle);
            }

        }
        System.out.printf("Circle moved to (%d,%d)\n", row, col);

    }
    /**
     * The ball move down until it meets a wall or the edge of the board
     */
    private void moveDown() {

        var circle = board.getChildren().get(36);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);


        while (row<6) {

            if(getNodeFromGridPane(board,col,row).toString().equals("lent")|| getNodeFromGridPane(board,col,row).toString().equals("lentjobb")){
                break;
            }
            else if(isGoal()||!validMove()){
                break;
            }
            else {
                GridPane.setRowIndex(circle,row+1);


                row = GridPane.getRowIndex(circle);


            }
        }

        System.out.printf("Circle moved to (%d,%d)\n", row, col);

    }

    /**
     *
     * {@return whether the game is solved}
     */
    private boolean isGoal(){
        var circle = board.getChildren().get(36);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);
        if(getNodeFromGridPane(board,col,row).toString().equals("cel")){
            System.out.println("Nyertél");
            return true;
        }
        else
            return false;
    }


    /**
     * @return The node that is on the given indexes
     */
    private ObservableList<String> getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node.getStyleClass();
            }
        }
        return null;
    }

    /**
     * {@return Whether the circle is out of the board}
     */
    private boolean validMove(){
        var circle = board.getChildren().get(36);
        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);
        if(col==BOARD_SIZE||row==BOARD_SIZE){
            return false;
        }
        else
            return true;
    }


}
