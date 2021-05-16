package model;

import model.block.Block;
import model.block.Brick;

import java.util.Arrays;
import java.util.List;

public class Board {
    //====================================================
    private final static int ceiling = 0;
    private final static int floor =15;
    private final static int leftWall =0;
    private final static int rightWall = 10;

    public static int getCeiling() {
        return ceiling;
    }
    public static int getFloor(){
        return floor;
    }
    public static int getLeftWall() {
        return leftWall;
    }
    public static int getRightWall() {
        return rightWall;
    }


    public int[][] getArea() {
        return area;
    }

    //====================================================
    private int[][] area;


    //====================================================
    public Board() {
        this.area = new int[rightWall][floor];
    }


    //====================================================
    public void update(Player player, List<Block> blocks){
        clear();
        updatePlayer(player);
        updateBlocks(blocks);
    }

    private void clear() {
        Arrays.stream(area)
                .forEach(i -> Arrays.fill(i, 0));
    }

    private void updateBlocks(List<Block> blocks) {
        for (int i = 0; i < blocks.size(); i++) {
            for (Brick brick :
                    blocks.get(i).getBricks()) {
                int x = brick.getX();
                int y = brick.getY();

                if (!canAdd(x,y)){
                    return;
                }

                area[x][y] = i+1;
            }
        }
    }

    private boolean canAdd(int x, int y){
        if (x >= leftWall
        && x < rightWall
        && y >= ceiling
        && y < floor){
            return true;
        }
        return false;
    }

    private void updatePlayer(Player player) {
        int x = player.getX();
        int y = player.getY();

        area[x][y] = -1;
    }

}
