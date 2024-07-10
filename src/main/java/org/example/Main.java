package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Création de la zone de jeu...");

        // Create a zone
        Zone zone = new Zone(10, 10);

        // Add resources and zombies
        System.out.println("Ajout des ressources et des zombies dans la zone...");
        zone.addResource(new Resource(2, 3, ResourceType.FOOD));
        zone.addResource(new Resource(5, 5, ResourceType.WATER));
        zone.addResource(new Resource(7, 8, ResourceType.WEAPON));

        zone.addZombie(new Zombie(4, 4));
        zone.addZombie(new Zombie(6, 6));

        // Create a survivor
        System.out.println("Création du survivant à la position (0, 0) orienté vers le nord avec 100 points de santé...");
        Survivor survivor = new Survivor(0, 0, Orientation.NORTH, 100);

        // Create the game
        System.out.println("Création du jeu avec la zone et le survivant...");
        Game game = new Game(zone, survivor);

        // Example usage of getZombiesAt and getResourcesAt
        int x = 4;
        int y = 4;

        System.out.println("\nExemple d'utilisation de getZombiesAt et getResourcesAt :");
        System.out.println("Recherche de zombies à la position (" + x + ", " + y + ")...");
        Zombie zombie = game.getZombiesAt(x, y);
        if (zombie != null) {
            System.out.println("Zombie trouvé à la position (" + x + ", " + y + ")");
        } else {
            System.out.println("Aucun zombie trouvé à la position (" + x + ", " + y + ")");
        }

        x = 2;
        y = 3;
        System.out.println("Recherche de ressources à la position (" + x + ", " + y + ")...");
        Resource resource = game.getResourcesAt(x, y);
        if (resource != null) {
            System.out.println("Ressource trouvée à la position (" + x + ", " + y + ") : " + resource.getType());
        } else {
            System.out.println("Aucune ressource trouvée à la position (" + x + ", " + y + ")");
        }

        // Afficher l'état final du survivant
        System.out.println("\nÉtat final du survivant :");
        System.out.println("Position : (" + survivor.getX() + ", " + survivor.getY() + ")");
        System.out.println("Orientation : " + survivor.getOrientation());
        System.out.println("Santé : " + survivor.getHealth());
    }
}
