package model;

import java.util.ArrayList;

public class Player {
    private int x;
    private int y;



    private boolean alive;

    public Player(){
        this(0,0);
    }
    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.alive = true;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean isAlive() {
        return alive;
    }

    public void moveUp(){
        if (y < Board.getCeiling()){
            y++;
        }
    }

    public void moveDown() {
        if (y > Board.getFloor()){
            y--;
        }
    }

    public void moveLeft(){
        if (x > Board.getLeftWall()){
            x--;
        }
    }

    public void moveRight(){
        if (x < Board.getRightWall()){
            x++;
        }
    }

    public void die(){
        this.alive = false;
    }
    public void eat(ArrayList<Block> blocks, Block block){
        blocks.remove(block);
    }

}
