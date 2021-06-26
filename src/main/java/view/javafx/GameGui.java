package view.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Board;
import model.Game;
import model.block.Block;
import model.block.Brick;

public class GameGui {
    private Game game;
    private final int brickSize = 30;

    public Pane getGamePane() {
        return gamePane;
    }

    private Pane gamePane;

    public GameGui(Game game){
        this.game = game;
        gamePaneInit();
    }

    private void gamePaneInit(){
        String color = "white";
        int width = brickSize * Board.getRightWall();
        int height = brickSize * Board.getFloor();
        gamePane = new Pane();
        gamePane.setStyle("-fx-background-color: " + color + "; -fx-border-style: solid; -fx-border-width: 2; -fx-border-color: black; -fx-min-width: " + width + "; -fx-min-height:" + height + "; -fx-max-width:" + width + "; -fx-max-height: " + height + ";");
    }


    public void update(){
        drawGame();
    }

    public void drawGame(){
        gamePane.getChildren().clear();
        drawBlocks();
        drawPlayer();
    }
    private void drawBlocks(){
        for (Block block :
                game.getBlocksStorage()) {
            for (Brick brickToPaint:
                    block.getBricks()) {
                int x = brickToPaint.getX();
                int y = brickToPaint.getY();
                String color = block.getColor();

                drawRectangle(x,y, color);
            }
        }
    }

    private void drawPlayer(){
        int x = game.getPlayerX();
        int y = game.getPlayerY();
        String color = "blue";

        drawRectangle(x,y, color);
    }

    private void drawRectangle(int x, int y, String color){
        x = x* brickSize;
        y = y* brickSize;

        Region rectangle = new Region();

        rectangle.setLayoutX(x);
        rectangle.setLayoutY(y);

        rectangle.setStyle("-fx-background-color: " + color + "; -fx-border-style: solid; -fx-border-width: 2; -fx-border-color: black; -fx-min-width: " + brickSize + "; -fx-min-height:" + brickSize + "; -fx-max-width:" + brickSize + "; -fx-max-height: " + brickSize + ";");

        gamePane.getChildren().add(rectangle);
    }

    public void gameOver(){

    }
}
