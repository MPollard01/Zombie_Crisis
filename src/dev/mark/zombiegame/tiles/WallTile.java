package dev.mark.zombiegame.tiles;

import dev.mark.zombiegame.gfx.Assets;

import java.awt.image.BufferedImage;

public class WallTile extends Tile {

    public WallTile(BufferedImage texture, int id) {
        super(texture, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
