package dev.mark.zombiegame.worlds;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.creatures.Zombie;
import dev.mark.zombiegame.entities.statics.Grave;
import dev.mark.zombiegame.entities.statics.Tree;
import dev.mark.zombiegame.tiles.Tile;

import java.awt.*;

public class Level1 extends Worlds {

    public Level1(Handler handler) {
        super(handler);
        world = new World(handler,"res/textures/worlds/graveyard.txt");
        init();
    }


    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
    }

    @Override
    protected void init() {
        int treeSpace = -60;
        for(int i=0; i<26; i++) {
            world.getEntityManager().addEntity(new Tree(handler,-60, treeSpace, 100, 200));
            world.getEntityManager().addEntity(new Tree(handler,1800, treeSpace, 100, 200));
            treeSpace += 50;
        }

        world.getEntityManager().addEntity(new Tree(handler,200, 300, 100, 200));
        world.getEntityManager().addEntity(new Tree(handler,500, 800, 100, 200));
        world.getEntityManager().addEntity(new Tree(handler,250, 1000, 100, 200));
        world.getEntityManager().addEntity(new Tree(handler,1000, 900, 100, 200));
        world.getEntityManager().addEntity(new Grave(handler,(Tile.TILEWIDTH*5)-10, (Tile.TILEHEIGHT*5)-20));

        int zx = 100;
        int zy = 100;
        for(int i=0; i<25; i++) {
            world.getEntityManager().addEntity(new Zombie(handler,zx,zy));
            zx += 60;
        }
    }

}
