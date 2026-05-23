package model.bonus;

import javafx.scene.paint.Color;

public abstract class AbstractBonus {

    protected abstract int getLetterBonus();
    public abstract int getWordBonus();

    public Color getBorderColor() {
        return Color.BLACK;
    }
    public abstract Color getClickedColor();

    //this should be really done as a lambda
    public int applyLetterBonus(int startingvalue){
        return startingvalue * this.getLetterBonus();
    }

}
