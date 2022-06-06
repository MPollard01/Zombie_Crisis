package dev.mark.zombiegame.projectiles;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.Entity;
import dev.mark.zombiegame.tiles.Tile;

import java.awt.*;

public abstract class Projectile {

    protected float x,y,dx,dy, velX, velY, speed;
    protected int width, height;
    protected Rectangle bounds;
    protected Handler handler;
    protected boolean active = true;

    public Projectile(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        speed = 10f;
        dx = handler.getMouseManager().getMousePoint().x - x;
        dy = handler.getMouseManager().getMousePoint().y - y;
        float length = (float) Math.sqrt(dx*dx + dy*dy);
        dx /= length;
        dy /= length;
        velX = dx * speed;
        velY = dy * speed;
        this.width = width;
        this.height = height;
        this.handler = handler;


        bounds = new Rectangle(0,0,width,height);
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);

    public boolean collisionWithTile() {
        if(handler.getWorld().getTile((int)(x + handler.getGameCamera().getXOffset()) / Tile.TILEWIDTH,
                (int)(y + handler.getGameCamera().getYOffset()) / Tile.TILEHEIGHT).isSolid()) {
            active = false;
        }
        return active;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x - xOffset), (int) (y + bounds.y - yOffset), bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
