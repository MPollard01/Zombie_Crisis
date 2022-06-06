package dev.mark.zombiegame.tiles;

import dev.mark.zombiegame.gfx.Assets;

public class StairTile extends Tile {
    public StairTile(int id) {
        super(Assets.exit, id);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
