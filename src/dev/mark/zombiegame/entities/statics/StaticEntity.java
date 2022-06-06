package dev.mark.zombiegame.entities.statics;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.entities.Entity;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
}
