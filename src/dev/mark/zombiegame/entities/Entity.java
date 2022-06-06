package dev.mark.zombiegame.entities;

import dev.mark.zombiegame.Game;
import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.projectiles.Projectile;

import java.awt.*;
import java.util.Iterator;

public abstract class Entity {

    public static final int DEFAULT_HEALTH = 10;
    protected Handler handler;
    protected float x, y, xOffset, yOffset;
    protected int width, height, cx, cy;
    protected float health;
    protected boolean active = true;
    protected Rectangle bounds;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        cx = width / 2;
        cy = height / 2;
        health = DEFAULT_HEALTH;
        bounds = new Rectangle(0,0,width,height);
    }

    public boolean checkEntityCollisions(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if(e.equals(this)) continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    public boolean checkProjectileCollision() {
        Iterator<Projectile> it = handler.getWorld().getProjectileManager().getProjectiles().iterator();
        while (it.hasNext()) {
            Projectile p = it.next();
            if(p.getCollisionBounds(0,0).intersects(getCollisionBounds(-handler.getGameCamera().getXOffset(), -handler.getGameCamera().getYOffset()))) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
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

    public float getXOffset() {
        return xOffset;
    }

    public float getYOffset() {
        return yOffset;
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

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void hurt(float amt) {
        health -= amt;
        if(health <= 0) {
            active = false;
            die();
        }
    }

    public abstract void die();
    public abstract void tick();
    public abstract void render(Graphics graphics);
}
