package dev.mark.zombiegame.entities.statics;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.gfx.Assets;
import dev.mark.zombiegame.tiles.Tile;

import java.awt.*;

public class Exit extends StaticEntity {

    public Exit(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.exit, (int) (x - handler.getGameCamera().getXOffset()),
                (int) (y - handler.getGameCamera().getYOffset()), width, height, null);
    }

    public void die() {

    }
}
