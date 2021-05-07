package Game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import model.GameModel;

public class GameController  {
    private static final int BOARD_SIZE=7;

    @FXML
    private GridPane board;


    //private Circle circle=new Circle(40,Color.BLUE);



    private GameModel gameModel=new GameModel();
    @FXML
    private  void initialize(){
        createCircle(1,4);
        createLabel();



    }
    private Circle createCircle(int row,int col)  {
        var circle=new Circle(40);
        circle.setFill(Color.BLUE);

        circle.setOnMouseClicked(this::moveLeft);

        board.add(circle,col,row);

        return circle;

    }
    private void deleteCircle(Circle circle){


         board.getChildren().remove(circle);

    }






    private Label createLabel(){
        var label=new Label();
        label.setText("CÉL");
        label.getStyleClass().add("label");
        board.add(label,2,5);

        return label;
    }

    @FXML
    private void moveLeft(MouseEvent e)  {

        var circle = (Circle) e.getSource();
        var row = GridPane.getRowIndex(circle);
        var col = GridPane.getColumnIndex(circle);





            System.out.printf("Circle move to (%d,%d)\n", row, col-1);




    }











}
