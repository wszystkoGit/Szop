package controller;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class gameLoop {
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            frameUpdate();
        }
    };


    private void frameUpdate() {

    }
}
