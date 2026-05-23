package model.cell;

import javafx.scene.paint.Color;
import model.bonus.AbstractBonus;
import model.bonus.EmptyBonus;

abstract class AbstractCell implements CellInterface {

    private char content;
    private AbstractBonus bns;

    protected AbstractCell(char c ) {
        this.content = c;
        this.bns = new EmptyBonus();
    }

    protected abstract int getValue();

    @Override
    public void setBns(AbstractBonus b){
        this.bns = b;
    }

    @Override
    public char getChar() {
        return this.content;
    }

    @Override
    public int getTotalValue(){
        int ret = this.getValue();
        ret = this.bns.applyLetterBonus(ret);
        return ret;
    }

    @Override
    public String getDisplay() {
        return this.content+" "+this.bns.toString();
    }

    @Override
    public Color getBorderColor(){
        return this.bns.getBorderColor();
    }
    @Override
    public Color getClickedColor(){
        return this.bns.getClickedColor();
    }

    @Override
    public int getWordBonus(){
        return this.bns.getWordBonus();
    }

}
