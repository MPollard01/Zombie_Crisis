package dev.mark.zombiegame.states;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.worlds.WorldManager;
import java.awt.*;

public class GameState extends State {

    private final WorldManager worldManager;

    public GameState(Handler handler) {
        super(handler);
        worldManager = new WorldManager(handler);
    }

    @Override
    public void tick() {
        worldManager.tick();
    }

    @Override
    public void render(Graphics graphics) {
        worldManager.render(graphics);
    }
}
