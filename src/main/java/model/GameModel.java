package model;


import javafx.scene.shape.Circle;

public class GameModel {

    private static final int BOARD_SIZE=6;



    public static boolean isOnBoard(Position position) {
        return 0 <= position.row() && position.row() < BOARD_SIZE
                && 0 <= position.col() && position.col() < BOARD_SIZE;
    }

    public static boolean isAWall(){
        return true;
    }











}
