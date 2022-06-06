package dev.mark.zombiegame.states;

import dev.mark.zombiegame.Handler;
import dev.mark.zombiegame.gfx.Assets;
import dev.mark.zombiegame.gfx.Text;
import dev.mark.zombiegame.ui.ClickListener;
import dev.mark.zombiegame.ui.UIImageButton;
import dev.mark.zombiegame.ui.UIManager;

import java.awt.*;

public class GameOverState extends State {
    private UIManager uiManager;

    public GameOverState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton((handler.getWidth() / 2)-64, 200, 128, 64, Assets.btn_restart, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(new GameState(handler));
            }
        }));

        uiManager.addObject(new UIImageButton((handler.getWidth() / 2)-64, 300, 128, 64, Assets.btn_exit, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(new MenuState(handler));
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(0,0,handler.getWidth(),handler.getHeight());
        uiManager.render(graphics);
        Text.drawString(graphics, "Game Over", handler.getWidth()/2, 50,true,Color.red, Assets.munro);
    }
}
