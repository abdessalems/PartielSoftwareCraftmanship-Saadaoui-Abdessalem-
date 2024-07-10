package org.example;

public class Main {
    public static void main(String[] args) {
        Zone zone = new Zone(10, 10);
        zone.addResource(new Resource(2, 3, ResourceType.FOOD));
        zone.addZombie(new Zombie(4, 4));

        Survivor survivor = new Survivor(0, 0, Orientation.NORTH, 100);
        Game game = new Game(zone, survivor);

        game.moveSurvivor(Direction.FORWARD);
        game.moveSurvivor(Direction.RIGHT);
        game.moveSurvivor(Direction.FORWARD);

        System.out.println("Survivor health: " + survivor.getHealth());
        System.out.println("Survivor position: (" + survivor.getX() + ", " + survivor.getY() + ")");
        System.out.println("Is survivor alive? " + game.isSurvivorAlive());
    }
}
