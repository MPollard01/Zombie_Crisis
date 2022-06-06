package dev.mark.zombiegame;

import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)size.getWidth();
        int screenHeight = (int)size.getHeight();

       Game game = new Game("Zombie Crisis", screenWidth, screenHeight);
       game.start();
    }
}
