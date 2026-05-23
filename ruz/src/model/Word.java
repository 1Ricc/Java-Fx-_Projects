package model;

import model.bonus.AbstractBonus;
import model.cell.CellInterface;
import java.util.ArrayList;
import java.util.HashSet;

public class Word {

    private HashSet<CellInterface> chars = new HashSet<>();
    private ArrayList<CellInterface> sortedchars = new ArrayList<>();

    public int getWordScore(){
        int ret = 0;
        for (CellInterface ac: chars) {
            ret += ac.getTotalValue();
        }
        for (CellInterface ac: chars){
            ret *= ac.getWordBonus();
        }
        return ret;
    }

    public void addChar(CellInterface ac){
        if (this.chars.add(ac)) {
            this.sortedchars.add(this.sortedchars.size(), ac);
        }
    }
    public void resetWord(){
        this.chars = new HashSet<>();
        this.sortedchars = new ArrayList<>();
    }

    public String toString() {
        String ret = "";
        for (CellInterface ac: this.sortedchars) {
            ret+=ac.getChar();
        }
        return ret;
    }
}
