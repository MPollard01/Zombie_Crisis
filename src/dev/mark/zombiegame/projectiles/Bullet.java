package dev.mark.zombiegame.projectiles;

import dev.mark.zombiegame.Handler;

import java.awt.*;

public class Bullet extends Projectile {

    public Bullet(Handler handler,float x, float y) {
        super(handler, x, y, 5, 5);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int)x, (int)y, width, height);
    }
}
