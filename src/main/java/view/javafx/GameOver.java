package view.javafx;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver {
    private Pane gameOver;

    public GameOver(){
        gameOver = new Pane();
    }

    public Pane getGameOver() {
        return gameOver;
    }

    private void addItemsToPane(){


        Label gameOverText = new Label("Game Over");
        Pane background = new Pane();
        background.getChildren().add(gameOverText);
        gameOverText.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        background.setStyle("-fx-background-color: #000000");

        gameOver.getChildren().add(background);
    }
}
