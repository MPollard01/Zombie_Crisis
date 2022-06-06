package dev.mark.zombiegame.entities.creatures;

import dev.mark.zombiegame.Game;
import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.Entity;
import dev.mark.zombiegame.gfx.Animation;
import dev.mark.zombiegame.gfx.Assets;
import dev.mark.zombiegame.inventory.Inventory;
import dev.mark.zombiegame.projectiles.Bullet;
import dev.mark.zombiegame.projectiles.Projectile;
import dev.mark.zombiegame.projectiles.ProjectileManager;
import dev.mark.zombiegame.states.GameOverState;
import dev.mark.zombiegame.states.State;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Animation animRun;

    private float dx, dy;
    private int cx, cy;
    private long lastAttackTimer, attackCoolDown = 100, attackTimer = attackCoolDown;
    private Inventory inventory;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 32;
        bounds.height = 25;
        bounds.width = 32;

        inventory = new Inventory(handler);

        // Animations
        animRun = new Animation(10, Assets.player_run);
    }

    @Override
    public void tick() {
        //System.out.println(x + " " + y);
        animRun.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    public void die() {
        State.setState(new GameOverState(handler));
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up) yMove = -speed;
        if(handler.getKeyManager().down) yMove = speed;
        if(handler.getKeyManager().left) xMove = -speed;
        if(handler.getKeyManager().right) xMove = speed;
    }

    public void shoot() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();

        if(handler.getMouseManager().isLeftPressed() && attackTimer > attackCoolDown) {
            double angleRad = Math.atan2(dy, dx);
            int py = 12;
            if(angleRad >= -2 && angleRad < 1) py = -12;

            handler.getWorld().getProjectileManager()
                    .addProjectile(new Bullet(handler, (float) ((xOffset + cx) - (angleRad*13)), yOffset + cy - py));
            attackTimer = 0;
        }
    }

    private void rotatePlayer(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        xOffset = x - handler.getGameCamera().getXOffset();
        yOffset = y - handler.getGameCamera().getYOffset();
        cx = width / 2;
        cy = height / 2;
        dx = handler.getMouseManager().getMouseX() - xOffset - cx;
        dy = handler.getMouseManager().getMouseY() - yOffset - cy;

        double angleRad = Math.atan2(dy, dx);
        AffineTransform oldAT = g.getTransform();
        g.translate(cx + (int)xOffset,cy + (int)yOffset);
        g.rotate(angleRad);
        g.translate(-cx, -cy);
        g.drawImage(getCurrentAnimationFrame(), 10, 25, 38, 38,null);
        g.drawImage(Assets.player, 0, 0, width, height,null);
        g.setTransform(oldAT);
    }

    @Override
    public void render(Graphics graphics) {
            rotatePlayer(graphics);

//        graphics.setColor(Color.red);
//        graphics.fillRect((int)(x + bounds.x - handler.getGameCamera().getXOffset()),
//                (int)(y + bounds.y - handler.getGameCamera().getYOffset()),
//                bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0) {
            return animRun.getCurrentFrame();
        } else if(xMove > 0) {
            return animRun.getCurrentFrame();
        } else if(yMove < 0) {
            return animRun.getCurrentFrame();
        } else if(yMove > 0) {
            return animRun.getCurrentFrame();
        } else {
            return Assets.player_feet;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
