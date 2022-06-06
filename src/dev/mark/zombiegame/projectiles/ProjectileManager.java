package dev.mark.zombiegame.projectiles;

import dev.mark.zombiegame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ProjectileManager {

    private Handler handler;
    private ArrayList<Projectile> projectiles;

    public ProjectileManager(Handler handler) {
        this.handler = handler;
        projectiles = new ArrayList<>();
    }

    public void tick() {
        handler.getWorld().getEntityManager().getPlayer().shoot();
        Iterator<Projectile> it = projectiles.iterator();
        while (it.hasNext()) {
            Projectile p = it.next();
            p.tick();
            if(!p.collisionWithTile()) {
                it.remove();
            }

        }
    }

    public void render(Graphics graphics) {
        for (Projectile p : projectiles) {
            p.render(graphics);
        }
    }

    public void addProjectile(Projectile p) {
        projectiles.add(p);
    }

    public void removeProjectile(Projectile p) {
        projectiles.remove(p);
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(ArrayList<Projectile> projectiles) {
        this.projectiles = projectiles;
    }
}
