package model;

import model.block.Block;
import model.block.BlockCreator;
import model.block.Brick;

import java.util.ArrayList;

public class Game {
    private final int blocksAmount;

    private Board board;
    private Player player;
    private ArrayList<Block> blocksStorage;
    private BlockCreator blockCreator;

    private boolean over;

    public Game() {
        blockCreator = new BlockCreator();
        blocksAmount = 100;
        over = false;
    }

    public int[][] getBoard() {
        return board.getArea();
    }


    //=====================================================
    public void start() {
        board = new Board();
        player = new Player();
        blocksStorage = new ArrayList<>();
        over = false;

        addBlocks(blocksAmount);
        board.update(player, blocksStorage);

        if (over){
            start();
        }

    }


    //=====================================================
    public void update() {
        if(over){
            return;
        }

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
        if (over){
            return;
        }
        for (Block block :
                blocksStorage) {
            if (canFall(block))
                block.fall();
                tryToCrush(block);
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

    private void tryToCrush(Block block){

        for (Brick brick :
                block.getBricks()) {
         if (brick.getX() == player.getX()
         && brick.getY() == player.getY()){
             gameOver();
             return;
         }
        }
    }

    private void gameOver() {
        System.out.println("Game over.");
        over = true;
    }


    //=====================================================
    private void tryToEat(){
        Block eaten = null;
        for (Block toEat:
                blocksStorage) {
            for (Brick brick :
                    toEat.getBricks()) {
             if (player.getX() == brick.getX()
             && player.getY() == brick.getY()){
                 eaten = toEat;
             }
            }
        }
        try{
            blocksStorage.remove(eaten);
        } catch (Exception e){

        }
    }
    private void movePlayer(Direction direction){
        switch (direction){
            case UP:
                player.moveUp();
                break;
            case DOWN:
                player.moveDown();
                break;
            case LEFT:
                player.moveLeft();
                break;
            case RIGHT:
                player.moveRight();
                break;
        }
        tryToEat();
    }

}
