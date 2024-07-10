package org.example;

import java.util.List;

public class Game {
    private Zone zone;
    private Survivor survivor;

    public Game(Zone zone, Survivor survivor) {
        this.zone = zone;
        this.survivor = survivor;
    }

    public Zombie getZombiesAt(int x, int y) {
        for (Zombie zombie : zone.getZombies()) {
            if (zombie.getX() == x && zombie.getY() == y) {
                return zombie;
            }
        }
        return null; // Return null if no zombie found at the specified position
    }

    public Resource getResourcesAt(int x, int y) {
        for (Resource resource : zone.getResources()) {
            if (resource.getX() == x && resource.getY() == y) {
                return resource;
            }
        }
        return null; // Return null if no resource found at the specified position
    }
}
