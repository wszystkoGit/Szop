package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Direction;
import model.Game;
import model.Player;

public class MovePlayer {

    Game game;

    public MovePlayer(Game game){
        this.game = game;
    }

    private EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode() == KeyCode.UP) {
                game.movePlayer(Direction.UP);
            }
            if(event.getCode() == KeyCode.DOWN) {
                game.movePlayer(Direction.DOWN);
            }
            if(event.getCode() == KeyCode.LEFT) {
                game.movePlayer(Direction.LEFT);
            }
            if(event.getCode() == KeyCode.RIGHT) {
                game.movePlayer(Direction.RIGHT);
            }

            event.consume();
        }
    };

    public EventHandler<KeyEvent> getKeyListener() {
        return keyListener;
    }
}
