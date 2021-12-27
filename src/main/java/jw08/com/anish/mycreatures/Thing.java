package com.anish.mycreatures;

import java.awt.Color;

public class Thing {

    protected World world;

    public Tile<? extends Thing> tile;

    public int getX() {
        return this.tile.getxPos();
    }

    public int getY() {
        return this.tile.getyPos();
    }

    public void setTile(Tile<? extends Thing> tile) {
        this.tile = tile;
    }

    public Thing(Color color, char glyph, World world) {
        this.color = color;
        this.glyph = glyph;
        this.world = world;
    }

    private  Color color;

    public Color getColor() {
        return this.color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }

    private final char glyph;

    public char getGlyph() {
        return this.glyph;
    }

}
