package dev.mark.zombiegame.items;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    public static Item[] items = new Item[256];
    public static Item keyItem = new Item(Assets.key, "key", 0);

    public static final int ITEMWIDTH = 20, ITEMHEIGHT = 20;

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;
    protected int x, y, count;
    protected Rectangle bounds;
    protected boolean pickedUp = false;

    public Item(BufferedImage texture, String name, int id) {
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;
        bounds = new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT);
        items[id] = this;
    }

    public void tick() {
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0).intersects(bounds)) {
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
    }

    public void render(Graphics g) {
        if(handler == null) return;
        render(g, (int)(x-handler.getGameCamera().getXOffset()),
                (int)(y-handler.getGameCamera().getYOffset()));
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
    }

    public Item createNew(int x, int y) {
        Item i = new Item(texture, name, id);
        i.setPosition(x,y);
        return i;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
