package model.block.blockShapes;

import model.block.Block;
import model.block.Brick;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BlockITest {

    @Test
    void fall() {
        Block block = new BlockI();
        ArrayList<Brick> bricks = new ArrayList<>();

        //Setup bricks with value of block.bricks.Y +1.
        for (Brick brick :
                block.getBricks()) {
         bricks.add(new Brick(brick.getX(), brick.getY()+1));
        }

        //Make block fall once.
        block.fall();

        //Test if bricks.Y got incremented by one.
        int index = 0;
        for (Brick brick :
                block.getBricks()) {

         assertEquals(bricks.get(index).getY(), brick.getY() );
         index++;
        }

    }

    @Test
    void rotateOnce() {
        Block block = new BlockI();
        ArrayList<Brick> bricks = new ArrayList<>();

        //Setup bricks with value of rotated blockI.
        bricks.add(new Brick(0,0));
        bricks.add(new Brick(1,0));
        bricks.add(new Brick(2,0));
        bricks.add(new Brick(3,0));


        //Make block rotate once.
        block.rotate();

        //Test if block got rotated.
        int index = 0;
        for (Brick brick :
                block.getBricks()) {

            assertEquals(bricks.get(index), brick );
            index++;
        }
    }
    @Test
    void rotateTwice() {
        Block block = new BlockI();
        ArrayList<Brick> bricks = new ArrayList<>();

        //Setup bricks with value of rotated blockI.
        bricks.add(new Brick(0,3));
        bricks.add(new Brick(0,2));
        bricks.add(new Brick(0,1));
        bricks.add(new Brick(0,0));


        //Make block rotate twice.
        block.rotate();
        block.rotate();

        //Test if block got rotated.
        int index = 0;
        for (Brick brick :
                block.getBricks()) {

            assertEquals(bricks.get(index), brick );
            index++;
        }
    }
    @Test
    void rotateThrice() {
        Block block = new BlockI();
        ArrayList<Brick> bricks = new ArrayList<>();

        //Setup bricks with value of rotated blockI.
        bricks.add(new Brick(3,0));
        bricks.add(new Brick(2,0));
        bricks.add(new Brick(1,0));
        bricks.add(new Brick(0,0));


        //Make block rotate thrice.
        block.rotate();
        block.rotate();
        block.rotate();

        //Test if block got rotated.
        int index = 0;
        for (Brick brick :
                block.getBricks()) {

            assertEquals(bricks.get(index), brick );
            index++;
        }
    }

    /*@Test
    void move() {
        Block block = new BlockI();
        ArrayList<Brick> bricks = new ArrayList<>();
        int d = 5;

        //Setup bricks with value of block.bricks.X +d.
        for (Brick brick :
                block.getBricks()) {
            bricks.add(new Brick(brick.getX()+d, brick.getY()));
        }

        //Make block move by distance "d".
        block.move(d);

        //Test if bricks.X got incremented by d.
        int index = 0;
        for (Brick brick :
                block.getBricks()) {

            assertEquals(bricks.get(index).getX(), brick.getX() );
            index++;
        }

    }*/
}