package model.bonus;

import javafx.scene.paint.Color;

public class EmptyBonus extends AbstractBonus{

    @Override
    public String toString() {
        return "  ";
    }

    @Override
    protected int getLetterBonus() {
        return 1;
    }

    @Override
    public int getWordBonus() {
        return 1;
    }

    @Override
    public Color getClickedColor() {
        return Color.TRANSPARENT;
    }
}
