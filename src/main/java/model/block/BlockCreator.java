package model.block;

import model.Board;
import model.block.blockShapes.*;

import java.util.Random;

public class BlockCreator {


    public Block create(){
        Random random = new Random();
        Block newBlock;
        int randomInt = random.nextInt(7);

        switch (randomInt){
            case 0:
                newBlock = new BlockZ();
                break;
            case 1:
                newBlock = new BlockI();
                break;
            case 2:
                newBlock = new BlockJ();
                break;
            case 3:
                newBlock = new BlockL();
                break;
            case 4:
                newBlock = new BlockO();
                break;
            case 5:
                newBlock = new BlockS();
                break;
            case 6:
                newBlock = new BlockT();
                break;
            default:
                throw new IllegalArgumentException();
        }
        randomInt = random.nextInt(4);
        rotate(newBlock, randomInt);

        randomInt = random.nextInt(howFar(newBlock));
        newBlock.move(randomInt);

        return newBlock;
    }

    private void rotate(Block block, int times) {
        for (int i = 0; i < times; i++) {
            block.rotate();
        }
    }

    //Returns distance of block from right wall.
    private int howFar(Block block){
        int maxX = 0;
        for (Brick brick :
                block.getBricks()) {
         if (brick.getX() > maxX){
             maxX = brick.getX();
         }
        }
        return Board.getRightWall()-maxX;
    }
}
