package org.example;

import java.util.Random;

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

    public void move() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                x++;
                break;
            case 1:
                x--;
                break;
            case 2:
                y++;
                break;
            case 3:
                y--;
                break;
        }
    }
}


