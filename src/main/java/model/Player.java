package model;

public class Player {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    public Player(){
        this.x = 0;
        this.y = 0;
    }
    public Player(int x, int y){
        this.x = x;
        this.y = y;
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
}
