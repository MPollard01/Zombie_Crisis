package dev.mark.zombiegame.gfx;

import dev.mark.zombiegame.Game;
import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.Entity;
import dev.mark.zombiegame.tiles.Tile;

public class GameCamera {

    private float xOffset, yOffset;
    private Handler handler;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace() {
        if(xOffset < 0) {
            xOffset = 0;
        } else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        } else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
        //System.out.println(xOffset);
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    public float getXOffset() {
        return xOffset;
    }

    public void setXOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getYOffset() {
        return yOffset;
    }

    public void setYOffset(float yOffset) {
        this.yOffset = yOffset;
    }


}
