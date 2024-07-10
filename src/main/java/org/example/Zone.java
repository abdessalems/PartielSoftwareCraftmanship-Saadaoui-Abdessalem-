package org.example;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private int width;
    private int height;
    private List<Resource> resources;
    private List<Zombie> zombies;

    public Zone(int width, int height) {
        this.width = width;
        this.height = height;
        this.resources = new ArrayList<>();
        this.zombies = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void addZombie(Zombie zombie) {
        zombies.add(zombie);
    }

    public List<Resource> getResources() {
        return resources;
    }

    public List<Zombie> getZombies() {
        return zombies;
    }
}
