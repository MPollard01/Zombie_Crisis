package dev.mark.zombiegame.items;

import dev.mark.zombiegame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {

    private Handler handler;
    private ArrayList<Item> items;

    public ItemManager(Handler handler) {
        this.handler = handler;
        items = new ArrayList<>();
    }

    public void tick() {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item i = it.next();
            i.tick();
            if(i.isPickedUp())
                it.remove();
        }
    }

    public void render(Graphics graphics) {
        for(Item i : items) {
            i.render(graphics);
        }
    }

    public void addItem(Item i) {
        i.setHandler(handler);
        items.add(i);
    }

    public boolean containsItem(String key) {
        for (Item item : items) {
            if(item.getName().equals(key)) return true;
        }
        return false;
    }

    public Item getItem(String key) {
        for (Item item : items) {
            if(item.getName().equals(key)) return item;
        }
        return null;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
