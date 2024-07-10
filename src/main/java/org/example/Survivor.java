package org.example;

public class Survivor {
    private int x;
    private int y;
    private Orientation orientation;
    private int health;

    public Survivor(int x, int y, Orientation orientation, int health) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getHealth() {
        return health;
    }

    public void move(Direction direction) {
        switch (direction) {
            case FORWARD:
                moveForward();
                break;
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
        }
    }

    private void moveForward() {
        switch (orientation) {
            case NORTH:
                y--;
                break;
            case SOUTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }
    }

    private void turnLeft() {
        orientation = orientation.turnLeft();
    }

    private void turnRight() {
        orientation = orientation.turnRight();
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }
}

