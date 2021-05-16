package model;

import model.block.Block;

import java.util.List;

public class Player {
    private int x;
    private int y;





    public Player(){
        this(Board.getRightWall()-1,Board.getFloor()-1);
    }
    public Player(int x, int y){
        this.x = x;
        this.y = y;

    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void moveUp(){
        if (y > Board.getCeiling()){
            y--;
        }
    }

    public void moveDown() {
        if (y < Board.getFloor()){
            y++;
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



}
