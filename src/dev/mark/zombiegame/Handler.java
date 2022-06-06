package dev.mark.zombiegame;

import dev.mark.zombiegame.gfx.GameCamera;
import dev.mark.zombiegame.input.KeyManager;
import dev.mark.zombiegame.input.MouseManager;
import dev.mark.zombiegame.projectiles.ProjectileManager;
import dev.mark.zombiegame.worlds.World;

public class Handler {

    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {return game.getMouseManager();}

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
