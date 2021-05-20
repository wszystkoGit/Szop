package view.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Game;
import model.block.Block;
import model.block.Brick;

public class Gui extends Application {
    private final int brickSize = 20;

    Game game = new Game();
    Pane gamePane = new Pane();
    Pane scorePane = new Pane();

    @Override
    public void start(Stage stage) throws Exception {
        Pane main = new Pane();



        main.getChildren().addAll(gamePane);

        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.show();
        testGame();
        updateGame();
    }

    public void testGame(){
        game.start();

    }
    public void updateGame(){
        game.update();
        drawGame();
    }

    public void drawGame(){

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
        int x = game.getPlayer().getX();
        int y = game.getPlayer().getY();
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
}
