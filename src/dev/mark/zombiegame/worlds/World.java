package dev.mark.zombiegame.worlds;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.EntityManager;
import dev.mark.zombiegame.entities.creatures.Player;
import dev.mark.zombiegame.entities.creatures.Zombie;
import dev.mark.zombiegame.entities.statics.Exit;
import dev.mark.zombiegame.entities.statics.Tree;
import dev.mark.zombiegame.items.ItemManager;
import dev.mark.zombiegame.projectiles.ProjectileManager;
import dev.mark.zombiegame.tiles.Tile;
import dev.mark.zombiegame.utils.Utils;

import java.awt.*;
import java.util.Random;

public class World {

    private Handler handler;
    private String path;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private boolean keyDrop = false;

    private EntityManager entityManager;
    private ProjectileManager projectileManager;
    private ItemManager itemManager;

    public World(Handler handler, String path) {
        this.handler = handler;
        this.path = path;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        itemManager = new ItemManager(handler);
        projectileManager = new ProjectileManager(handler);
        //loadWorld(path);
    }

    public void tick() {
        itemManager.tick();
        entityManager.tick();
        projectileManager.tick();
    }

    public void render(Graphics graphics) {
        int xStart = (int)Math.max(0,handler.getGameCamera().getXOffset()/ Tile.TILEWIDTH);
        int yStart = (int)Math.max(0, handler.getGameCamera().getYOffset() / Tile.TILEHEIGHT);
        int xEnd = (int)Math.min(width, (handler.getGameCamera().getXOffset() + handler.getWidth()) / Tile.TILEWIDTH +1);
        int yEnd = (int)Math.min(height, (handler.getGameCamera().getYOffset() + handler.getHeight()) / Tile.TILEHEIGHT +1);

        for(int y=yStart; y<yEnd; y++) {
            for(int x=xStart; x < xEnd; x++) {
                getTile(x,y).render(graphics, (int)(x*Tile.TILEWIDTH - handler.getGameCamera().getXOffset()),
                        (int)(y*Tile.TILEHEIGHT - handler.getGameCamera().getYOffset()));
            }
        }
        itemManager.render(graphics);
        entityManager.render(graphics);
        projectileManager.render(graphics);
    }

    public Tile getTile(int x, int y) {
        if(x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.groundTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null) return Tile.groundTile;
        return t;
    }

    public void loadWorld() {
        String file = Utils.loadFileString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y=0; y<height; y++) {
            for(int x=0; x<width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width) + 4]);
            }
        }

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void spawnZombies(int zomNum) {
        Random rand = new Random();
//        int xEnd = (int)Math.max(width, (handler.getGameCamera().getXOffset() + handler.getWidth()) / Tile.TILEWIDTH +1);
//        int yEnd = (int)Math.max(height, (handler.getGameCamera().getYOffset() + handler.getHeight()) / Tile.TILEHEIGHT +1);
//        float maxX = xEnd*Tile.TILEWIDTH - handler.getGameCamera().getXOffset()-128;
//        float maxY = yEnd*Tile.TILEHEIGHT - handler.getGameCamera().getYOffset()-128;
//
//        float minX = handler.getWidth()-handler.getGameCamera().getXOffset();
//        float minY = handler.getHeight()-handler.getGameCamera().getYOffset();

        float maxX = 0;
        float minX = 64;
        float maxY = 0;
        float minY = 64;


        if(handler.getGameCamera().getXOffset() > 0) {
            maxX = Math.max(128, handler.getGameCamera().getXOffset());
        } else {
            maxX = width*Tile.TILEWIDTH - handler.getGameCamera().getXOffset()-128;
            minX = handler.getWidth() - handler.getGameCamera().getXOffset();
        }

        if(handler.getGameCamera().getYOffset() > 0) {
            maxY = Math.max(128, handler.getGameCamera().getYOffset());
        } else {
            maxY = height*Tile.TILEHEIGHT - handler.getGameCamera().getYOffset()-128;
            minY = handler.getHeight() - handler.getGameCamera().getYOffset();
        }

        for (int i=0; i<zomNum; i++) {
            float ranX = rand.nextInt((int) (maxX-minX)) + minX;
            float ranY = rand.nextInt((int) (maxY-minY)) + minY;
            entityManager.addEntity(new Zombie(handler, ranX, ranY));
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ProjectileManager getProjectileManager() {return projectileManager; }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public boolean isKeyDrop() {
        return keyDrop;
    }

    public void setKeyDrop(boolean keyDrop) {
        this.keyDrop = keyDrop;
    }
}
