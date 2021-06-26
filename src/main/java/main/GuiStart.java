package main;

import controller.GameLoop;
import controller.MovePlayer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Game;
import view.javafx.GameGui;

import java.util.EventListener;

public class GuiStart extends Application {

    Game game = new Game();
    GameGui gameGui = new GameGui(game);
    GameLoop loop = new GameLoop(game, gameGui);
    MovePlayer movePlayer = new MovePlayer(game);

    @Override
    public void start(Stage stage) throws Exception {
        Pane gamePane = gameGui.getGamePane();

        Pane main = new Pane(gamePane);
        EventHandler<KeyEvent> handler = movePlayer.getKeyListener();

        startGame();
        Scene scene = new Scene(main);
        scene.setOnKeyPressed(handler);
        stage.setScene(scene);
        stage.show();
    }

    private void startGame(){

        loop.start();
    }
}
