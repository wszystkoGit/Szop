package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    //=======MoveUp======//
    @Test
    void testMoveUpChangesYPlusOne() {
        Player player = new Player();
        int y = player.getY();
        player.moveUp();
        assertEquals(y+1,player.getY());
    }
    @Test
    void testMoveUpCannotMovePastCeiling(){
        Player player = new Player();
        for (int i = 0; i < Board.getCeiling() + 5; i++) {
            player.moveUp();
        }
        assertEquals(Board.getCeiling(), player.getY(),"Player is above ceiling.");
    }

    //=======MoveDown======//

    @Test
    void testMoveDownChangesYMinusOne(){
        Player player = new Player(0, 5);
        player.moveDown();
        assertEquals(4, player.getY());
    }
    @Test
    void testMoveDownCannotMovePastFloor(){
        Player player = new Player(0, 5);
        for (int i = 0; i < 20; i++) {
            player.moveDown();
        }
        assertEquals(Board.getFloor(), player.getY());
    }

    //=======MoveLeft======//

    @Test
    void testMoveLeftChangesXMinusOne(){
        Player player = new Player(5, 0);
        player.moveLeft();
        assertEquals(4, player.getX());
    }
    @Test
    void testMoveLeftCannotMovePastLeftWall(){
        Player player = new Player(5, 0);
        for (int i = 0; i < 20; i++) {
            player.moveLeft();
        }
        assertEquals(Board.getLeftWall(),player.getX());
    }

    //=======MoveRight======//

    @Test
    void testMoveRightChangesXPlusOne(){
        Player player = new Player();
        player.moveRight();
        assertEquals(1,player.getX());
    }
    @Test
    void testMoveRightCannotMovePastRightWall(){
        Player player = new Player();
        for (int i = 0; i < Board.getRightWall() + 5; i++) {
            player.moveRight();
        }
        assertEquals(Board.getRightWall(), player.getX());
    }

}