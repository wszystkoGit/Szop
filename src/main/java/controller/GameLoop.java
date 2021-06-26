package controller;

import javafx.animation.AnimationTimer;

import model.Game;
import view.javafx.GameGui;

public class GameLoop {
    private Game game;
    private GameGui gui;
    private int frame;
    private int frameLimit;

    public GameLoop(Game game, GameGui gui) {
        this.game = game;
        this.gui = gui;
        frame = 0;
        frameLimit = 50;
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            frameUpdate();
            try {
                Thread.sleep(5);
                frame++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public void start() {
        game.start();
        timer.start();
        gui.update();
    }

    int counter =0;
    private void frameUpdate() {
        gui.update();


        if (frame == frameLimit) {

            counter++;
            if (counter == 10){
                frameLimit--;
            }
            game.update();
            frame = 0;
        }

    }
}
