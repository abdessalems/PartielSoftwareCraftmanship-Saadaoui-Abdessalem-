package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SurvivorGameTest {

    private Survivor survivor;
    private Zone zone;

    @BeforeEach
    public void setUp() {
        survivor = new Survivor(new Position(5, 5), Orientation.NORTH, 100);
        zone = new Zone(10, 10);
    }

    @Test
    public void testSurvivorMove() {
        survivor.move(Direction.NORTH);
        assertEquals(4, survivor.getPosition().getY());
        survivor.move(Direction.SOUTH);
        assertEquals(5, survivor.getPosition().getY());
        survivor.move(Direction.EAST);
        assertEquals(6, survivor.getPosition().getX());
        survivor.move(Direction.WEST);
        assertEquals(5, survivor.getPosition().getX());
    }

    @Test
    public void testSurvivorEncounterZombie() {
        int initialHealth = survivor.getHealth();
        Zombie zombie = new Zombie(new Position(5, 6));
        survivor.encounterWithZombie(zombie);
        assertTrue(survivor.getHealth() < initialHealth);
    }

    @Test
    public void testZoneAddResource() {
        Resource food = new Resource(ResourceType.FOOD, new Position(3, 5));
        zone.addResource(food);
        assertTrue(zone.getResources().contains(food));
    }

    @Test
    public void testZoneAddZombie() {
        Zombie zombie = new Zombie(new Position(7, 8));
        zone.addZombie(zombie);
        assertTrue(zone.getZombies().contains(zombie));
    }

    @Test
    public void testGameHandleEncounter() {
        Game game = new Game(survivor, zone);
        Zombie zombie = new Zombie(new Position(5, 6));
        zone.addZombie(zombie);
        game.handleEncounter(zombie);
        assertTrue(survivor.getHealth() < 100); // Assuming survivor starts with 100 health
    }

    @Test
    public void testGameCollectResource() {
        Game game = new Game(survivor, zone);
        Resource food = new Resource(ResourceType.FOOD, new Position(3, 5));
        zone.addResource(food);
        game.collectResource(food);
        assertTrue(survivor.getInventory().contains(food));
    }
}
