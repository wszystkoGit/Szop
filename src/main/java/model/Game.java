package model;

import model.block.Block;
import model.block.BlockCreator;
import model.block.Brick;

import java.util.ArrayList;

public class Game {

    private Board board;
    private Player player;
    private ArrayList<Block> blocksStorage;
    private BlockCreator blockCreator;

    private final int blocksAmount;

    public Game() {
        board = new Board();
        player = new Player();
        blocksStorage = new ArrayList<>();
        blockCreator = new BlockCreator();
        blocksAmount = 100;
    }

    public int[][] getBoard() {
        return board.getArea();
    }


    //=====================================================
    public void start() {
        addBlocks(blocksAmount);
        board.update(player, blocksStorage);
    }


    //=====================================================
    public void update() {
        blocksFall();
        board.update(player, blocksStorage);
    }


    //=====================================================
    private void addBlocks(int amount) {
        for (int i = 0; i < amount; i++) {
            addBlock();
            blocksFall(8);
        }
    }
    private void addBlock() {
        Block toAdd = blockCreator.create();
        if(canAdd(toAdd)){
            blocksStorage.add(toAdd);
        }

    }

    private boolean canAdd(Block toAdd){
        for (Block block :
                blocksStorage) {
            for (Brick brick :
                    block.getBricks()) {
                for (Brick brickToAdd :
                        toAdd.getBricks()) {
                 if (brick.getY() == brickToAdd.getY()
                 && brick.getX() == brickToAdd.getX()){
                     return false;
                 }
                }
            }
        }
        return true;
    }


    //=====================================================
    private void blocksFall() {

        for (Block block :
                blocksStorage) {
            if (canFall(block))
                block.fall();
        }
    }

    private void blocksFall(int times){
        for (int i = 0; i < times; i++) {
            blocksFall();
        }
    }

    private boolean canFall(Block block) {
        if (onFloor(block)) {
            return false;
        }

        for (Block storedBlock :
                blocksStorage) {
            if (onAnother(block, storedBlock)) {
                return false;
            }
        }

        return true;
    }

    private boolean onFloor(Block block) {
        int maxY = 0;
        for (Brick brick :
                block.getBricks()) {
            if (brick.getY() > maxY) {
                maxY = brick.getY();
            }
        }
        return maxY == Board.getFloor() - 1;
    }

    private boolean onAnother(Block upper, Block lower) {
        if (upper == lower){
            return false;
        }
        for (Brick upperBrick :
                upper.getBricks()) {
            for (Brick lowerBrick
                    : lower.getBricks()) {
                if (upperBrick.getX() == lowerBrick.getX() && upperBrick.getY() == lowerBrick.getY() - 1) {
                    return true;
                }

            }
        }
        return false;
    }


    //=====================================================
    private void eat(Block block){

    }

}
