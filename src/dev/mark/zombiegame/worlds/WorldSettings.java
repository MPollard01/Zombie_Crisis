package dev.mark.zombiegame.worlds;

import dev.mark.zombiegame.entities.Entity;

import java.awt.*;
import java.util.List;

public interface WorldSettings {
    List<Entity> startingEntities();
}
