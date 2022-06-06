package dev.mark.zombiegame.tiles;

import dev.mark.zombiegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HedgeTile extends Tile {

    public HedgeTile(BufferedImage texture, int id) {
        super(texture, id);
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(Assets.grass, x, y, TILEWIDTH, TILEHEIGHT, null);
        graphics.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
