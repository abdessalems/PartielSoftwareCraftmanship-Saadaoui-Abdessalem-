package org.example;

public class Game {
    private Zone zone;
    private Survivor survivor;

    public Game(Zone zone, Survivor survivor) {
        this.zone = zone;
        this.survivor = survivor;
    }

    public void moveSurvivor(Direction direction) {
        survivor.move(direction);
        if (!zone.isWithinBounds(survivor.getX(), survivor.getY())) {
            throw new RuntimeException("Survivor moved out of bounds and died!");
        }

        Resource resource = zone.getResourceAt(survivor.getX(), survivor.getY());
        if (resource != null) {
            // Add resource to inventory (not shown in this simple example)
            System.out.println("Found resource: " + resource.getType());
        }

        List<Zombie> zombies = zone.getZombiesAt(survivor.getX(), survivor.getY());
        if (!zombies.isEmpty()) {
            survivor.decreaseHealth(zombies.size() * 10); // Lose 10 health per zombie
            System.out.println("Encountered " + zombies.size() + " zombies, health decreased!");
        }
    }

    public boolean isSurvivorAlive() {
        return survivor.getHealth() > 0;
    }
}

