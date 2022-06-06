package dev.mark.zombiegame.worlds;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class WorldManager {

    private Handler handler;
    private ArrayList<Worlds> worlds;
    private int currentWorld;

    public WorldManager(Handler handler) {
        this.handler = handler;
        worlds = new ArrayList<>();
        worlds.add(new Level1(handler));
        worlds.add(new Level2(handler));
        worlds.add(new Level3(handler));
        currentWorld = 0;
        handler.setWorld(getCurrentWorld());
        getCurrentWorld().loadWorld();
    }

    public void nextWorld() {
        if ((currentWorld +1) < worlds.size()) {
            currentWorld++;
            handler.setWorld(getCurrentWorld());
            getCurrentWorld().loadWorld();
        }
    }

    public void tick() {
        if(getCurrentWorld().getTile(((int)getCurrentWorld().getEntityManager().getPlayer().getX()+32) / Tile.TILEWIDTH,
                ((int)getCurrentWorld().getEntityManager().getPlayer().getY()+32) / Tile.TILEHEIGHT).isExit()) {
            nextWorld();
        }
        getWorld().tick();
    }

    public void render(Graphics graphics) {
        getWorld().render(graphics);
    }

    public World getCurrentWorld() {
        return worlds.get(currentWorld).getWorld();
    }

    public Worlds getWorld() {
        return worlds.get(currentWorld);
    }
}
