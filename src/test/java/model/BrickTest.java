package model;

import model.block.Brick;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrickTest {

    @Test
    void testSetBrick(){
        int tryX = 4;
        int tryY = 7;
        Brick brick = new Brick();
        brick.setBrick(tryX, tryY);

        assertEquals(tryX, brick.getX(),"X expected " + tryX + ", but was: " + brick.getX() );
        assertEquals(tryY, brick.getY(),"Y expected " + tryY + ", but was: " + brick.getY() );
    }


//    @Test
//    void testSetBrickCannotBeOutsideBoard(){
//        int initX = 2;
//        int initY = 8;
//        Brick brick = new Brick(initX,initY);
//        int tryX = -3;
//        int tryY = 30;
//        brick.setBrick(tryX,tryY);
//
//        assertEquals(initX, brick.getX(),"X expected " + initX + ", but was: " + brick.getX());
//        assertEquals(initY, brick.getY(),"Y expected " + initY + ", but was: " + brick.getY());
//    }
}