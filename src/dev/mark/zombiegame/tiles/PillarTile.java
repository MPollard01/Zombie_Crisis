package dev.mark.zombiegame.tiles;

import dev.mark.zombiegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class PillarTile extends Tile {
    public PillarTile(int id) {
        super(Assets.pillar, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
