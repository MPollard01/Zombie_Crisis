package dev.mark.zombiegame.worlds;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.creatures.Zombie;
import dev.mark.zombiegame.entities.statics.Door;
import dev.mark.zombiegame.items.Item;
import dev.mark.zombiegame.tiles.Tile;
import dev.mark.zombiegame.utils.Timer;

import java.awt.*;

public class Level2 extends Worlds {

    private Timer timer;
    private int zomCount;

    public Level2(Handler handler) {
        super(handler);
        world = new World(handler,"res/textures/worlds/world1.txt");
        init();
        timer = new Timer(1000);
        zomCount = 0;
    }

    @Override
    public void tick() {
        world.tick();

        timer.runTimer();
        if(timer.hasTime()) {
            spawn();
            timer.reset();
        }
    }

    private void spawn() {
        float x = 0;
        float y = 0;

        if(handler.getGameCamera().getXOffset() > 64) {
            x = 72;
        } else if(handler.getGameCamera().getXOffset() < world.getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
            x = handler.getWidth() - handler.getGameCamera().getXOffset();
        }

        if (handler.getGameCamera().getYOffset() > 64) {
            y = 72;
        } else if(handler.getGameCamera().getYOffset() < world.getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
            y = handler.getHeight() - handler.getGameCamera().getYOffset();
        }

        Zombie z = new Zombie(handler,x,y);
        world.getEntityManager().addEntity(z);
        zomCount++;

        if(zomCount == 5) {
            world.setKeyDrop(true);
        }
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
    }

    @Override
    protected void init() {
        world.getEntityManager().addEntity(new Door(handler, Tile.TILEWIDTH*27, Tile.TILEHEIGHT*4));
        world.getEntityManager().addEntity(new Zombie(handler,200,100));
        world.getEntityManager().addEntity(new Zombie(handler,200,164));
        world.getEntityManager().addEntity(new Zombie(handler,200,240));
        world.getEntityManager().addEntity(new Zombie(handler,500,240));
        world.getEntityManager().addEntity(new Zombie(handler,564,240));
        world.getEntityManager().addEntity(new Zombie(handler,1000,700));
        world.getEntityManager().addEntity(new Zombie(handler,1100,700));
        world.getEntityManager().addEntity(new Zombie(handler,1200,770));
        world.getEntityManager().addEntity(new Zombie(handler,1200,800));
        world.getEntityManager().addEntity(new Zombie(handler,1500,900));

    }

}
