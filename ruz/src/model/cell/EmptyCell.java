package model.cell;

import model.bonus.EmptyBonus;

public class EmptyCell extends AbstractCell{

    public EmptyCell() {
        super(' ');
        this.setBns(new EmptyBonus());
    }

    @Override
    public int getValue() {
        return 0;
    }
}
