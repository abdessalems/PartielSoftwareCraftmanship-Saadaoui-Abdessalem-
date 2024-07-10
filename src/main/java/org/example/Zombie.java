package org.example;

public class Zombie {
    private int x;
    private int y;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveRandomly(Zone zone) {
        int newX = x + (int)(Math.random() * 3) - 1;
        int newY = y + (int)(Math.random() * 3) - 1;

        if (zone.isWithinBounds(newX, newY)) {
            x = newX;
            y = newY;
        }
    }
}

