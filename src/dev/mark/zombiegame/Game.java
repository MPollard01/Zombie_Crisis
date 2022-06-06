package dev.mark.zombiegame;

import dev.mark.zombiegame.display.Display;
import dev.mark.zombiegame.gfx.Assets;
import dev.mark.zombiegame.gfx.GameCamera;
import dev.mark.zombiegame.gfx.ImageLoader;
import dev.mark.zombiegame.gfx.SpriteSheet;
import dev.mark.zombiegame.input.KeyManager;
import dev.mark.zombiegame.input.MouseManager;
import dev.mark.zombiegame.projectiles.ProjectileManager;
import dev.mark.zombiegame.states.GameOverState;
import dev.mark.zombiegame.states.GameState;
import dev.mark.zombiegame.states.MenuState;
import dev.mark.zombiegame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private Display display;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    // states
    public State gameState, menuState;

    // input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    private GameCamera camera;
    private Handler handler;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        handler = new Handler(this);
        camera = new GameCamera(handler,0,0);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);
    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bufferStrategy.getDrawGraphics();
        // clear screen
        graphics.clearRect(0, 0, width, height);
        // draw
        if(State.getState() != null) {
            State.getState().render(graphics);
        }
        //end draw
        bufferStrategy.show();
        graphics.dispose();
    }

    private void tick() {
        keyManager.tick();
        if(State.getState() != null) {
            State.getState().tick();
        }
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                delta--;
            }

            if(timer >= 1000000000) timer = 0;
        }

        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {return mouseManager;}

    public GameCamera getGameCamera() {return camera;}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Display getDisplay() {
        return display;
    }

    public synchronized void start() {
        if(running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized  void stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
