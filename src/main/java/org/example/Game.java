package org.example;

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
        return null;
    }

    public Resource getResourcesAt(int x, int y) {
        for (Resource resource : zone.getResources()) {
            if (resource.getX() == x && resource.getY() == y) {
                return resource;
            }
        }
        return null;
    }

    public void handleEncounter(Zombie zombie) {
        survivor.encounterWithZombie(zombie);
    }

    public void collectResource(Resource resource) {
        survivor.addResourceToInventory(resource);
        zone.removeResource(resource);
    }
}
