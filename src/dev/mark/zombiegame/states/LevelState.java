package dev.mark.zombiegame.states;

import dev.mark.zombiegame.entities.Entity;
import dev.mark.zombiegame.worlds.WorldSettings;

import java.util.List;

public enum LevelState implements WorldSettings {
    LEVEL_1 {
        @Override
        public List<Entity> startingEntities() {
            return null;
        }
    },
    LEVEL_2 {
        @Override
        public List<Entity> startingEntities() {
            return null;
        }
    }
}
