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

    public void setHealth(int health) {
        this.health = health;
    }

    public void move(Direction direction) {
        switch (direction) {
            case FORWARD:
                switch (orientation) {
                    case NORTH:
                        y++;
                        break;
                    case SOUTH:
                        y--;
                        break;
                    case EAST:
                        x++;
                        break;
                    case WEST:
                        x--;
                        break;
                }
                break;
            case LEFT:
                orientation = orientation.turnLeft();
                break;
            case RIGHT:
                orientation = orientation.turnRight();
                break;
        }
    }
}


