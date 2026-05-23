package model.bonus;

import javafx.scene.paint.Color;

public class LetterBonus extends AbstractBonus {

    private int letterbonus = 0;

    public LetterBonus(int val){
        this.letterbonus = val;
    }

    @Override
    protected int getLetterBonus() {
        return this.letterbonus;
    }

    @Override
    public int getWordBonus() {
        return 1;
    }

    @Override
    public Color getBorderColor() {
        return Color.RED;
    }

    @Override
    public Color getClickedColor() {
        return Color.ORANGE;
    }

    @Override
    public String toString() {
        return "*"+this.getLetterBonus();
    }
}
