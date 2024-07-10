package org.example;

public class Resource {
    private int x;
    private int y;
    private ResourceType type;

    public Resource(int x, int y, ResourceType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ResourceType getType() {
        return type;
    }
}

