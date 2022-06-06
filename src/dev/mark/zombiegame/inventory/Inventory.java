package dev.mark.zombiegame.inventory;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.items.Item;

import java.util.ArrayList;

public class Inventory {

    private Handler handler;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<>();
    }

    public void addItem(Item item) {
        for (Item i : inventoryItems) {
            if(i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    public void removeItem(Item i) {
        inventoryItems.remove(i);
    }

    public boolean containsItem(int id) {
        for (Item i : inventoryItems) {
            if(i.getId() == id) return true;
        }
        return false;
    }
}
