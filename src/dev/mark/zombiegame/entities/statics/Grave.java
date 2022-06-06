package dev.mark.zombiegame.entities.statics;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.gfx.Assets;
import dev.mark.zombiegame.tiles.Tile;

import java.awt.*;

public class Grave extends StaticEntity {

    public Grave(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH+20, Tile.TILEHEIGHT+32);
    }

    @Override
    public void die() {

    }

    private void checkHit() {
        if(checkProjectileCollision()) {
            hurt(2);
        }
    }

    @Override
    public void tick() {
        checkHit();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.graves[4], (int) (x - handler.getGameCamera().getXOffset()),
                (int) (y - handler.getGameCamera().getYOffset()), width, height, null);
    }
}
