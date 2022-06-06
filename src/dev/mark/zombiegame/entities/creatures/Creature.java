package dev.mark.zombiegame.entities.creatures;

import dev.mark.zombiegame.Game;
import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.Entity;
import dev.mark.zombiegame.tiles.Tile;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler,x, y, width, height);

        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        if(!checkEntityCollisions(xMove, 0f))
            moveX();
        if(!checkEntityCollisions(0f, yMove))
            moveY();
    }

    public void moveX() { // moving right
        if(xMove > 0) {
            int tempX = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if(!collisionWithTile(tempX, (int) (y+bounds.y) / Tile.TILEHEIGHT) &&
                !collisionWithTile(tempX, (int) (y+bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else {
                x = tempX * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }
        } else if(xMove < 0) { // moving left
            int tempX = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
            if(!collisionWithTile(tempX, (int) (y+bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tempX, (int) (y+bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else {
                x = tempX * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        if(yMove < 0) { // up
            int tempY = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (x+bounds.x) / Tile.TILEWIDTH, tempY) &&
                    !collisionWithTile((int) (x+bounds.x + bounds.width) / Tile.TILEWIDTH, tempY)) {
                y += yMove;
            } else {
                y = tempY * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        } else if(yMove > 0) { // down
            int tempY = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (x+bounds.x) / Tile.TILEWIDTH, tempY) &&
                    !collisionWithTile((int) (x+bounds.x + bounds.width) / Tile.TILEWIDTH, tempY)) {
                y += yMove;
            } else {
                y = tempY * Tile.TILEHEIGHT - bounds.y - bounds.height -1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x,y).isSolid();
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }




}
