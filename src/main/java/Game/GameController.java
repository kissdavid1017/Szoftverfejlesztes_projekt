package Game;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import model.GameModel;
import model.Position;

public class GameController {
    private static final int BOARD_SIZE = 7;

    @FXML
    private GridPane board;


    //private Circle circle=new Circle(40,Color.BLUE);


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

    private Circle createCircle(int row, int col) {
        var circle = new Circle(40);
        circle.setFill(Color.BLUE);


        board.add(circle, col, row);

        return circle;

    }

    private void deleteCircle(Circle circle) {


        board.getChildren().remove(circle);

    }


    private Label createLabel() {
        var label = new Label();
        label.setText("CÉL");
        label.getStyleClass().add("label");
        board.add(label, 2, 5);

        return label;
    }

    //@FXML
    private void moveLeft() {

        var circle = board.getChildren().get(16);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);
        var position = new Position(row, col -1);
        while (col>0) {

            GridPane.setColumnIndex(circle, col - 1);

            col = GridPane.getColumnIndex(circle);



        }

        System.out.printf("Circle moved to (%d,%d)\n", row, col);


    }

    private void moveRight() {

        var circle = board.getChildren().get(16);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);
        var position = new Position(row, col + 1);
        while (col<6) {

            GridPane.setColumnIndex(circle, col + 1);
            col++;

            col = GridPane.getColumnIndex(circle);


        }
        System.out.printf("Circle moved to (%d,%d)\n", row, col);



    }

    private void moveUp() {

        var circle = board.getChildren().get(16);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);
        var position = new Position(row-1, col);
        while (col>0) {

            GridPane.setRowIndex(circle,row-1);
            col++;

            row=GridPane.getRowIndex(circle);


        }
        System.out.printf("Circle moved to (%d,%d)\n", row, col);



    }

    private void moveDown() {

        var circle = board.getChildren().get(16);

        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);
        var position = new Position(row+1, col);
        while (row<6) {

            GridPane.setRowIndex(circle,row+1);
            col++;

            row=GridPane.getRowIndex(circle);


        }
        System.out.printf("Circle moved to (%d,%d)\n", row, col);



    }
}
