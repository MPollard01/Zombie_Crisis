package dev.mark.zombiegame.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private final static int width = 64, height = 64;
    public static BufferedImage player, player_feet, pillar, exit, ground, wallTop, wallBottom,
            wallLeft, wallRight, wallRightEnd, wallLeftEnd, wallTopLeftCorner,
            wallTopRightCorner, wallBottomLeftCorner, wallBottomRightCorner, wallJointTop;

    public static Font munro;

    public static BufferedImage[] player_run;
    public static BufferedImage btn_start, gameOver, btn_restart, btn_exit;
    public static BufferedImage[] zombie_move, zombie_attack;
    public static BufferedImage key, bloodSplat;
    public static BufferedImage[] blood;
    public static BufferedImage pineTree, grass, dirt;
    public static BufferedImage[] graves, hedges, door;
    public static BufferedImage[][] dungeon;

    public static void init() {
        munro = FontLoader.loadFont("res/fonts/munro.ttf",50);
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/wall_sheet.png"));
        player = ImageLoader.loadImage("/textures/player/rifle/idle/survivor-idle_rifle_0.png");
        player_feet = ImageLoader.loadImage("/textures/player/feet/idle/survivor-idle_0.png");
        btn_start = ImageLoader.loadImage("/textures/menu/start_btn.png");
        btn_restart = ImageLoader.loadImage("/textures/menu/retry_btn.png");
        btn_exit = ImageLoader.loadImage("/textures/menu/exit_btn.png");
        gameOver = ImageLoader.loadImage("/textures/menu/game over.png");
        SpriteSheet keys = new SpriteSheet(ImageLoader.loadImage("/textures/keys/KeyIcons.png"));
        key = keys.crop(0, 0, width/2, height/2);
        SpriteSheet bloodAnim = new SpriteSheet(ImageLoader.loadImage("/textures/blood/blood.png"));
        bloodSplat = ImageLoader.loadImage("/textures/blood/bloodsplats_0004.png");
        SpriteSheet trees = new SpriteSheet(ImageLoader.loadImage("/textures/trees/plant repack.png"));
        grass = ImageLoader.loadImage("/textures/grass/Grass1.png");
        dirt = ImageLoader.loadImage("/textures/grass/Dirt1.png");
        SpriteSheet grave = new SpriteSheet(ImageLoader.loadImage("/textures/grave/grave_markers.png"));
        graves = new BufferedImage[5];
        graves[0] = grave.crop(0,0,width,90);
        graves[1] = grave.crop(width,0,32,32);
        graves[2] = grave.crop(width,height,64,64);
        graves[3] = grave.crop(128,height,32,64);
        graves[4] = grave.crop((width+32),0,32,32);

        hedges = new BufferedImage[6];
        hedges[0] = trees.crop(285, 10, 32, height);
        hedges[1] = trees.crop((285+32), 10, 32, height);
        hedges[2] = trees.crop((285+64), 10, 32, height);
        hedges[3] = trees.crop(285, height, 32, 32);
        hedges[4] = trees.crop(285, 10, 32, 32);
        hedges[5] = trees.crop(285, 10, 32, 32);

        player_run = new BufferedImage[20];
        for(int i=0; i<player_run.length; i++) {
            player_run[i] = ImageLoader.loadImage("/textures/player/feet/run/survivor-run_"+i+".png");
        }

        zombie_move = new BufferedImage[17];
        for (int i=0; i < zombie_move.length; i++) {
            zombie_move[i] = ImageLoader.loadImage("/textures/zombie/move/skeleton-move_"+i+".png");
        }

        zombie_attack = new BufferedImage[9];
        for (int i=0; i < zombie_attack.length; i++) {
            zombie_attack[i] = ImageLoader.loadImage("/textures/zombie/attack/skeleton-attack_"+i+".png");
        }

        exit = sheet.crop(width*4, height*6, width, height);
        ground = sheet.crop(width*4, height*5, width, height);
        pillar = sheet.crop(width*4, height*4, width, height);
        wallLeftEnd = sheet.crop(width*3, height*4, width, height);
        wallRightEnd = sheet.crop(width*2, height*4, width, height);
        wallJointTop = sheet.crop(width*4, 0, width, height);
        wallTop = sheet.crop(width*2, 0, width, height);
        wallLeft = sheet.crop(0, 0, width, height);
        wallRight = sheet.crop(width, 0, width, height);
        wallBottom = sheet.crop(width*3, 0, width, height);
        wallTopLeftCorner = sheet.crop(0, height, width, height);
        wallBottomRightCorner = sheet.crop(width, height, width, height);
        wallTopRightCorner = sheet.crop(width*2, height, width, height);
        wallBottomLeftCorner = sheet.crop(width*3, height, width, height);

        dungeon = new BufferedImage[9][5];

        for (int i=0; i< dungeon.length; i++) {
            for (int j=0; j<dungeon[i].length; j++) {
                dungeon[i][j] = sheet.crop(width*j, height*i, width, height);
            }
        }

        SpriteSheet doors = new SpriteSheet(ImageLoader.loadImage("/textures/doors/doors.png"));
        door = new BufferedImage[4];
        door[0] = doors.crop((width*2) + 32,(height*4)+32, 32,48);
        door[1] = doors.crop((width*2) + 32,(height*3)+32, 32,48);
        door[2] = doors.crop((width*2) + 32,(height*2)+32, 32,48);
        door[3] = doors.crop((width*2) + 32,32, 32,32);

        pineTree = trees.crop(100, 128, 85,150);

        blood = new BufferedImage[13];
        blood [0] = bloodAnim.crop(512*2, 0, 512, 512);
        blood [1] = bloodAnim.crop(512*3, 0, 512, 512);
        blood [2] = bloodAnim.crop(0, 512, 512, 512);
        blood [3] = bloodAnim.crop(512, 512, 512, 512);
        blood [4] = bloodAnim.crop(512*2, 512, 512, 512);
        blood [5] = bloodAnim.crop(512*3, 512, 512, 512);
        blood [6] = bloodAnim.crop(0, 512*2, 512, 512);
        blood [7] = bloodAnim.crop(512, 512*2, 512, 512);
        blood [8] = bloodAnim.crop(512*2, 512*2, 512, 512);
        blood [9] = bloodAnim.crop(512*3, 512*2, 512, 512);
        blood [10] = bloodAnim.crop(0, 512*3, 512, 512);
        blood [11] = bloodAnim.crop(512, 512*3, 512, 512);
        blood [12] = bloodAnim.crop(512*2, 512*3, 512, 512);
    }
}
