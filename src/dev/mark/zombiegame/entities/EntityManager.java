package dev.mark.zombiegame.entities;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
        addEntity(player);
    }

    public void tick() {
        Iterator<Entity> it = entities.iterator();
        while (it.hasNext()) {
            Entity e = it.next();
            e.tick();
            if (!e.isActive())
                it.remove();
        }
        entities.sort((Entity a, Entity b) ->
                a.getY() + a.getHeight() < b.getY() + b.getHeight() ? -1 : 1);
    }

    public void render(Graphics graphics) {
        for(Entity e : entities) {
            e.render(graphics);
        }

    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
