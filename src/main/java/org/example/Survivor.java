package org.example;

import java.util.ArrayList;
import java.util.List;

public class Survivor {
    private int x;
    private int y;
    private Orientation orientation;
    private int health;
    private List<Resource> inventory;

    public Survivor(int x, int y, Orientation orientation, int health) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.health = health;
        this.inventory = new ArrayList<>();
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

    public List<Resource> getInventory() {
        return inventory;
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

    public void encounterWithZombie(Zombie zombie) {
        this.health -= 10;
    }

    public void addResourceToInventory(Resource resource) {
        inventory.add(resource);
    }
}
