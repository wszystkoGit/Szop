package model.block;

import java.util.ArrayList;

public abstract class Block {
    private ArrayList<Brick> bricks;
    protected String color;


    public Block(int x0, int y0,
                 int x1, int y1,
                 int x2, int y2,
                 int x3, int y3) {

        bricks = new ArrayList<>();
        addBrick(x0, y0);
        addBrick(x1, y1);
        addBrick(x2, y2);
        addBrick(x3, y3);

    }

    public String getColor() {
        return color;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void fall() {
        for (Brick brick :
                bricks) {
            brick.setBrick(brick.getX(), brick.getY() + 1);
        }
    }


    private void addBrick(int x, int y) {
        if (bricks.size() < 4) {
            bricks.add(new Brick(x, y));
        }
    }


    public void rotate() {
        for (Brick brick :
                bricks) {
            int x = brick.getY();
            int y = -brick.getX();
            brick.setBrick(x, y);
        }
        center();

    }

    private void center() {

        //Find lowest x value in bricks.
        int minX = bricks.get(0).getX();
        for (Brick brick :
                bricks) {
            if (minX > brick.getX()) {
                minX = brick.getX();
            }
        }

        //Move all bricks by absolute value of lowest brick.X value if it's negative.
        if (minX < 0) {
            for (Brick brick :
                    bricks) {
                brick.setBrick(brick.getX() - minX, brick.getY());
            }
        }

        //Find lowest y value in bricks.
        int minY = bricks.get(0).getY();
        for (Brick brick :
                bricks) {
            if (minY > brick.getY()) {
                minY = brick.getY();
            }
        }

        //Move all bricks by absolute value of lowest brick.Y value if it's negative.
        if (minY < 0) {
            for (Brick brick :
                    bricks) {
                brick.setBrick(brick.getX(), brick.getY() - minY);
            }
        }


    }

    void move(int distance) {
        for (Brick brick :
                bricks) {
            brick.setBrick(brick.getX() + distance, brick.getY());
        }
    }
}
