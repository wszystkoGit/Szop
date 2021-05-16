package view;

import model.Game;
import model.block.Block;
import model.Board;
import model.Player;
import model.block.BlockCreator;
import model.block.blockShapes.*;

import java.util.ArrayList;

public class TextUI {
    private Game testGame = new Game();


    public void test() {
        testGame.start();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());
        testGame.update();
        printBoard(testGame.getBoard());


        //Game.
    }

    void printBoard(int[][] input) {
        int [][] forPrint = reverseForPrint(input);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < forPrint.length; i++) {
            for (int j = 0; j < forPrint[i].length; j++) {
                int field = forPrint[i][j];
                builder.append(formatField(field));
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    private int[][] reverseForPrint(int[][] input){
        int[][] reversed = new int[Board.getFloor()][Board.getRightWall()];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                reversed[j][i] = input[i][j];
            }
        }
        return reversed;
    }

    private String formatField(int field){
        char s = '*';
        if (field >= 0 && field < 10){
            return "" + s + s + field;
        }
        return "" + s + field;

    }
}
