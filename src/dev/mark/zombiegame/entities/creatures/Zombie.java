package dev.mark.zombiegame.entities.creatures;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.gfx.Animation;
import dev.mark.zombiegame.gfx.Assets;
import dev.mark.zombiegame.items.Item;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Zombie extends Creature {

    private float dx, dy;
    private Animation animMove, animAttack, animBlood;
    private long lastAttackTimer, attackCoolDown = 400, attackTimer = attackCoolDown;

    public Zombie(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 32;
        bounds.height = 25;
        bounds.width = 40;
        speed = 1f;

        animMove = new Animation(1, Assets.zombie_move);
        animAttack = new Animation(1, Assets.zombie_attack);
        animBlood = new Animation(1, Assets.blood);
    }

    private void moveToPlayer() {
        dx = handler.getWorld().getEntityManager().getPlayer().getX() - x;
        dy = handler.getWorld().getEntityManager().getPlayer().getY() - y;
        float length = (float) Math.sqrt(dx*dx + dy*dy);
        dx /= length;
        dy /= length;
        xMove = dx * speed;
        yMove = dy * speed;

        move();
    }

    protected void facePlayer(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        xOffset = x - handler.getGameCamera().getXOffset();
        yOffset = y - handler.getGameCamera().getYOffset();
        float pX = handler.getWorld().getEntityManager().getPlayer().getX() - x - cx;
        float pY = handler.getWorld().getEntityManager().getPlayer().getY() - y - cy;

        double angleRad = Math.atan2(pY, pX);
        AffineTransform oldAT = g.getTransform();
        g.translate(cx + (int)xOffset,cy + (int)yOffset);
        g.rotate(angleRad);
        g.translate(-cx, -cy);
        g.drawImage(attack(), 0, 0, width, height,null);
        g.setTransform(oldAT);
    }

    private BufferedImage attack() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();

        Player p = handler.getWorld().getEntityManager().getPlayer();
        if(p.getCollisionBounds(0,0).intersects(getCollisionBounds(xMove,yMove))) {
            if(attackTimer > attackCoolDown) {
                p.hurt(1);
                attackTimer = 0;
            }
            return animAttack.getCurrentFrame();
        }

        return animMove.getCurrentFrame();
    }

    protected void checkHit(Graphics g, float damage) {
        if(checkProjectileCollision()) {
            hurt(damage);
            animBlood.tick();
            g.drawImage(animBlood.getCurrentFrame(), (int)xOffset,(int)yOffset,width*2,height*2,null);
        }
    }

    @Override
    public void die() {
        if(handler.getWorld().isKeyDrop()) {
            Item key = Item.keyItem.createNew((int)x,(int)y);
            handler.getWorld().getItemManager().addItem(key);
            handler.getWorld().setKeyDrop(false);
        }
    }

    @Override
    public void tick() {
        animMove.tick();
        animAttack.tick();
        moveToPlayer();
    }

    @Override
    public void render(Graphics graphics) {
        checkHit(graphics,5);
        facePlayer(graphics);
        //graphics.setColor(Color.red);
//        graphics.fillRect((int)(x + bounds.x - handler.getGameCamera().getXOffset()),
//                (int)(y + bounds.y - handler.getGameCamera().getYOffset()),
//                bounds.width, bounds.height);
    }
}
