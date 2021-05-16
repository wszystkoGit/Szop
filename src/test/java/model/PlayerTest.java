package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    //=======MoveUp======//
    @Test
    void testMoveUpChangesYMinusOne() {
        Player player = new Player(5,5);
        int y = player.getY();
        player.moveUp();
        assertEquals(y-1,player.getY());
    }

    //=======MoveDown======//

    @Test
    void testMoveDownChangesYPlusOne(){
        Player player = new Player(0, 5);
        int y = player.getY();
        player.moveDown();
        assertEquals(y+1, player.getY());
    }

    //=======MoveLeft======//

    @Test
    void testMoveLeftChangesXMinusOne(){
        Player player = new Player(5, 0);
        int x = player.getX();
        player.moveLeft();
        assertEquals(x-1, player.getX());
    }

    @Test
    void testMoveRightChangesXPlusOne(){
        Player player = new Player();
        int x = player.getX();
        player.moveRight();
        assertEquals(x+1,player.getX());
    }

    //=================Die======//
/*    @Test
    void testPlayerDie(){
        Player player = new Player();
        player.die();
        assertFalse(player.isAlive());
    }*/


}