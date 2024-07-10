package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SurvivorGameTest {

    private Survivor survivor;
    private Zone zone;
    private Game game;

    @BeforeEach
    public void setUp() {
        zone = new Zone(10, 10);
        zone.addResource(new Resource(2, 3, ResourceType.FOOD));
        zone.addResource(new Resource(5, 5, ResourceType.WATER));
        zone.addResource(new Resource(7, 8, ResourceType.WEAPON));

        zone.addZombie(new Zombie(4, 4));
        zone.addZombie(new Zombie(6, 6));

        survivor = new Survivor(0, 0, Orientation.NORTH, 100);

        game = new Game(zone, survivor);
    }

    @Test
    public void testSurvivorMove() {
        survivor.move(Direction.FORWARD);
        assertEquals(0, survivor.getX());
        assertEquals(1, survivor.getY());

        survivor.move(Direction.LEFT);
        survivor.move(Direction.FORWARD);
        assertEquals(-1, survivor.getX());
        assertEquals(1, survivor.getY());

        survivor.move(Direction.RIGHT);
        survivor.move(Direction.FORWARD);
        assertEquals(-1, survivor.getX());
        assertEquals(2, survivor.getY());
    }

    @Test
    public void testSurvivorEncounterZombie() {
        int initialHealth = survivor.getHealth();
        Zombie zombie = new Zombie(0, 1);
        survivor.encounterWithZombie(zombie);
        assertTrue(survivor.getHealth() < initialHealth);
    }

    @Test
    public void testZoneAddResource() {
        Resource resource = new Resource(3, 3, ResourceType.FOOD);
        zone.addResource(resource);
        assertTrue(zone.getResources().contains(resource));
    }

    @Test
    public void testZoneAddZombie() {
        Zombie zombie = new Zombie(7, 7);
        zone.addZombie(zombie);
        assertTrue(zone.getZombies().contains(zombie));
    }

    @Test
    public void testGameHandleEncounter() {
        Zombie zombie = new Zombie(0, 1);
        zone.addZombie(zombie);
        game.handleEncounter(zombie);
        assertTrue(survivor.getHealth() < 100);
    }

    @Test
    public void testGameCollectResource() {
        Resource resource = new Resource(0, 1, ResourceType.FOOD);
        zone.addResource(resource);
        game.collectResource(resource);
        assertTrue(survivor.getInventory().contains(resource));
    }

    @Test
    public void testGetZombiesAt() {
        Zombie zombie = game.getZombiesAt(4, 4);
        assertNotNull(zombie);
        assertEquals(4, zombie.getX());
        assertEquals(4, zombie.getY());

        Zombie noZombie = game.getZombiesAt(1, 1);
        assertNull(noZombie);
    }

    @Test
    public void testGetResourcesAt() {
        Resource resource = game.getResourcesAt(2, 3);
        assertNotNull(resource);
        assertEquals(2, resource.getX());
        assertEquals(3, resource.getY());

        Resource noResource = game.getResourcesAt(1, 1);
        assertNull(noResource);
    }
}
