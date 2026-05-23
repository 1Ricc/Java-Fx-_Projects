package model.cell;

import javafx.scene.paint.Color;
import model.bonus.AbstractBonus;

public interface CellInterface {
    void setBns(AbstractBonus b);
    char getChar();
    int getTotalValue();
    String getDisplay();
    Color getBorderColor();
    Color getClickedColor();
    int getWordBonus();
}
