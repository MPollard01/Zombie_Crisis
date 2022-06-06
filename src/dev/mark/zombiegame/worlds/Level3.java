package dev.mark.zombiegame.worlds;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.creatures.BossZombie;
import dev.mark.zombiegame.entities.creatures.Zombie;
import dev.mark.zombiegame.tiles.Tile;
import dev.mark.zombiegame.utils.Timer;

import java.awt.*;

public class Level3 extends Worlds {

    private Timer timer;

    public Level3(Handler handler) {
        super(handler);
        world = new World(handler,"res/textures/worlds/world3.txt");
        init();
        timer = new Timer(1000);
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

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
    }

    private void spawn() {

        if(handler.getGameCamera().getXOffset() > 100 && handler.getGameCamera().getYOffset() > 100) {
            world.getEntityManager().addEntity(new Zombie(handler,1000, 100));
        }
        if(handler.getGameCamera().getXOffset() < 100 && handler.getGameCamera().getYOffset() > 100) {
            world.getEntityManager().addEntity(new Zombie(handler,2000, 1000));
        }

        if(handler.getGameCamera().getXOffset() > 1600 && handler.getGameCamera().getYOffset() > 100) {
            world.getEntityManager().addEntity(new Zombie(handler,100, 600));
            world.getEntityManager().addEntity(new Zombie(handler,1600, 1000));
        }

    }

    @Override
    protected void init() {
        world.getEntityManager().addEntity(new BossZombie(handler,1000,1000));
        world.getEntityManager().addEntity(new Zombie(handler,1000,700));
        world.getEntityManager().addEntity(new Zombie(handler,1100,700));
        world.getEntityManager().addEntity(new Zombie(handler,1200,770));
        world.getEntityManager().addEntity(new Zombie(handler,1200,800));
        world.getEntityManager().addEntity(new Zombie(handler,1500,900));
    }
}
