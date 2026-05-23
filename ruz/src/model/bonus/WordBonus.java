package model.bonus;

import javafx.scene.paint.Color;

public class WordBonus extends AbstractBonus {
    private int wordbonus = 0;

    public WordBonus(int val){
        this.wordbonus = val;
    }

    @Override
    public Color getClickedColor() {
        return Color.LIGHTGREEN;
    }

    @Override
    public String toString() {
        return "*"+this.getWordBonus()+"w";
    }

    @Override
    protected int getLetterBonus() {
        return 1;
    }

    @Override
    public int getWordBonus() {
        return this.wordbonus;
    }
}
