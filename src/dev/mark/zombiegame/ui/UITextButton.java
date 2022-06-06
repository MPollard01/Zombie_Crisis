package dev.mark.zombiegame.ui;

import dev.mark.zombiegame.gfx.Text;

import java.awt.*;

public class UITextButton extends UIObject {

    private Font font;
    private String text;
    private boolean center;
    private Color color;
    private ClickListener clicker;

    public UITextButton(float x, float y, Font font, String text, boolean center, Color c, ClickListener clicker) {
        super(x, y, 100,50);
        this.font = font;
        this.text = text;
        this.center = center;
        this.color = c;
        this.clicker = clicker;
//        if(g != null) {
//            FontMetrics fm = g.getFontMetrics(font);
//            this.width = fm.stringWidth(text);
//            this.height = fm.getHeight();
//        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        Text.drawString(g,text,(int)x,(int)y,center,color,font);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}
