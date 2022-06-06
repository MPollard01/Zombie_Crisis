package dev.mark.zombiegame.entities.statics;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.gfx.Animation;
import dev.mark.zombiegame.gfx.Assets;
import dev.mark.zombiegame.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door extends StaticEntity {

    private Animation animOpen;
    private BufferedImage texture;

    public Door(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        bounds.x = 0;
        bounds.y = 36;
        bounds.width = 64;
        bounds.height = 32;
        texture = Assets.door[0];
        animOpen = new Animation(2,Assets.door);
    }

    @Override
    public void die() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        getCurrentAnimationFrame();
        graphics.drawImage(texture, (int) (x - handler.getGameCamera().getXOffset()),
                (int) (y - handler.getGameCamera().getYOffset()), width, height, null);

    }

    private void getCurrentAnimationFrame() {
        if(handler.getWorld().getEntityManager().getPlayer().getInventory().containsItem(0)
            && handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0)
                .intersects(getCollisionBounds(0,5))) {
            texture = Assets.door[3];
            bounds.width = 0;
            bounds.height = 0;
        }
    }
}
