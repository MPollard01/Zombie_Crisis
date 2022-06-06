package dev.mark.zombiegame.entities.statics;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.gfx.Assets;

import java.awt.*;

public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        bounds.x = 32;
        bounds.y = 128;
        bounds.width = 64;
        bounds.height = 64;
    }

    @Override
    public void die() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.pineTree, (int) (x - handler.getGameCamera().getXOffset()),
                (int) (y - handler.getGameCamera().getYOffset()), width, height, null);

//        graphics.setColor(Color.red);
//        graphics.fillRect((int)(x + bounds.x - handler.getGameCamera().getXOffset()),
//                (int)(y + bounds.y - handler.getGameCamera().getYOffset()),
//                bounds.width, bounds.height);
    }
}
