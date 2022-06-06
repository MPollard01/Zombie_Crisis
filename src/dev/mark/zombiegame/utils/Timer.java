package dev.mark.zombiegame.utils;

public class Timer {
    private long lastTimer, coolDown, timer;

    public Timer(long coolDown) {
        this.coolDown = coolDown;
        this.timer = coolDown;
    }

    public void runTimer() {
        timer += System.currentTimeMillis() - lastTimer;
        lastTimer = System.currentTimeMillis();
    }

    public void reset() {
        timer = 0;
    }

    public boolean hasTime() {
        return timer > coolDown;
    }
}
