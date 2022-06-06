package dev.mark.zombiegame.entities.creatures;

import dev.mark.zombiegame.Handler;

import java.awt.*;

public class BossZombie extends Zombie {

    public BossZombie(Handler handler, float x, float y) {
        super(handler, x, y);
        speed = 2.5f;
        width = 128;
        height = 128;
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 80;
        bounds.height = 80;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render(Graphics graphics) {
        facePlayer(graphics);
        checkHit(graphics,0.1f);
//        graphics.setColor(Color.red);
//        graphics.fillRect((int)(x + bounds.x - handler.getGameCamera().getXOffset()),
//                (int)(y + bounds.y - handler.getGameCamera().getYOffset()),
//                bounds.width, bounds.height);
    }
}
