package dev.mark.zombiegame.tiles;

import dev.mark.zombiegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile groundTile = new GroundTile(Assets.ground,0);
    public static Tile wallTop = new WallTile(Assets.dungeon[0][2],1);
    public static Tile wallBottom = new WallTile(Assets.wallBottom,2);
    public static Tile wallRight = new WallTile(Assets.wallRight,3);
    public static Tile wallLeft = new WallTile(Assets.wallLeft,4);
    public static Tile wallTopLeftCorner = new WallTile(Assets.wallTopLeftCorner,5);
    public static Tile wallTopRightCorner = new WallTile(Assets.wallTopRightCorner,6);
    public static Tile wallBottomLeftCorner = new WallTile(Assets.wallBottomLeftCorner,7);
    public static Tile wallBottomRightCorner = new WallTile(Assets.wallBottomRightCorner,8);
    public static Tile pillarTile = new PillarTile(9);
    public static Tile grassTile = new GrassTile(10);
    public static Tile dirtTile = new DirtTile(11);
    public static Tile tree = new TreeTile(12);
    public static Tile grave1 = new GraveTile(Assets.graves[0], 13);
    public static Tile grave2 = new GraveTile(Assets.graves[1], 14);
    public static Tile grave3 = new GraveTile(Assets.graves[2], 15);
    public static Tile grave4 = new GraveTile(Assets.graves[3], 16);
    public static Tile hedge_vLeft = new HedgeTile(Assets.hedges[0], 17);
    public static Tile hedge_vMid = new HedgeTile(Assets.hedges[1], 18);
    public static Tile hedge_vRight = new HedgeTile(Assets.hedges[2], 19);
    public static Tile stair = new StairTile(20);
    public static Tile wallTopJoint = new WallTile(Assets.dungeon[0][4],21);
    public static Tile wallVert1 = new WallTile(Assets.dungeon[1][4],22);
    public static Tile wallVert2 = new WallTile(Assets.dungeon[2][4],23);
    public static Tile wallBottomJoint = new WallTile(Assets.dungeon[3][4],24);
    public static Tile wallTLeftCorner = new WallTile(Assets.dungeon[2][0],25);
    public static Tile wallBRightCorner = new WallTile(Assets.dungeon[2][1],26);
    public static Tile wallTRightCorner = new WallTile(Assets.dungeon[2][2],27);
    public static Tile wallBLeftCorner = new WallTile(Assets.dungeon[2][3],28);
    public static Tile wallVert3 = new WallTile(Assets.dungeon[3][0], 29);
    public static Tile wallVert4 = new WallTile(Assets.dungeon[3][1], 30);
    public static Tile wallHorizontal1 = new WallTile(Assets.dungeon[3][2], 31);
    public static Tile wallHorizontal2 = new WallTile(Assets.dungeon[3][3], 32);
    public static Tile wallTopEnd = new WallTile(Assets.dungeon[4][0],33);
    public static Tile wallBottomEnd = new WallTile(Assets.dungeon[4][1],34);
    public static Tile wallRightEnd = new WallTile(Assets.dungeon[4][2],35);
    public static Tile wallLeftEnd = new WallTile(Assets.dungeon[4][3],36);
    public static Tile wallLeftJoint = new WallTile(Assets.dungeon[5][0],37);
    public static Tile wallHorizontal3 = new WallTile(Assets.dungeon[5][1],38);
    public static Tile wallHorizontal4 = new WallTile(Assets.dungeon[5][2],39);
    public static Tile wallRightJoint = new WallTile(Assets.dungeon[5][3],40);
    public static Tile wallLeftJoint2 = new WallTile(Assets.dungeon[6][0],41);
    public static Tile wallHorizontal5 = new WallTile(Assets.dungeon[6][1],42);
    public static Tile wallTopJoint2 = new WallTile(Assets.dungeon[6][2],43);
    public static Tile wallVert5 = new WallTile(Assets.dungeon[6][3],44);
    public static Tile wallHorizontal6 = new WallTile(Assets.dungeon[7][0],45);
    public static Tile wallRightJoint2 = new WallTile(Assets.dungeon[7][1],46);
    public static Tile wallVert6 = new WallTile(Assets.dungeon[7][2],47);
    public static Tile wallBottomJoint2 = new WallTile(Assets.dungeon[7][3],48);
    public static Tile groundCrack1 = new GroundTile(Assets.dungeon[7][4], 49);
    public static Tile groundTopRight = new GroundTile(Assets.dungeon[8][0], 50);
    public static Tile groundBottomLeft = new GroundTile(Assets.dungeon[8][1], 51);
    public static Tile groundBottomRight = new GroundTile(Assets.dungeon[8][2], 52);
    public static Tile groundTopLeft = new GroundTile(Assets.dungeon[8][3], 53);
    public static Tile groundCrack2 = new GroundTile(Assets.dungeon[8][4], 54);

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }
    public boolean isExit() {return false;}

    public int getId() {
        return id;
    }
}
