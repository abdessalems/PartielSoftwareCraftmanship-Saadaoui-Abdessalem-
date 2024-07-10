package org.example;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private final int width;
    private final int height;
    private List<Resource> resources;
    private List<Zombie> zombies;

    public Zone(int width, int height) {
        this.width = width;
        this.height = height;
        this.resources = new ArrayList<>();
        this.zombies = new ArrayList<>();
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void addZombie(Zombie zombie) {
        zombies.add(zombie);
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Resource getResourceAt(int x, int y) {
        for (Resource resource : resources) {
            if (resource.getX() == x && resource.getY() == y) {
                return resource;
            }
        }
        return null;
    }

    public List<Zombie> getZombiesAt(int x, int y) {
        List<Zombie> zombiesAtLocation = new ArrayList<>();
        for (Zombie zombie : zombies) {
            if (zombie.getX() == x && zombie.getY() == y) {
                zombiesAtLocation.add(zombie);
            }
        }
        return zombiesAtLocation;
    }
}

