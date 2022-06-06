package dev.mark.zombiegame.worlds;

import dev.mark.zombiegame.Handler;
import java.awt.*;

public abstract class Worlds {
    protected Handler handler;
    protected World world;

    public Worlds(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);
    protected abstract void init();

    public World getWorld() {
        return world;
    }
}
