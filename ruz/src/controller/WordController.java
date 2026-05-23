package controller;

import model.Word;
import model.cell.CellInterface;
import view.WordPane;
import java.util.HashSet;

public class WordController {

    private WordPane wp ;
    private Word w;
    private HashSet<CellController> ac;

    public WordController(WordPane wp, Word w){
        this.wp = wp;
        this.w = w;
        this.ac = new HashSet<>();
    }

    public void addChar(CellController cc) {
        this.ac.add(cc);
        CellInterface ac = cc.getAc();
        this.w.addChar(ac);
        this.wp.addChar(ac.getChar());
    }

    public void reset(){
        this.wp.reset();
        this.w.resetWord();
        for (CellController cc: this.ac) {
            cc.reset();
        }
        this.ac = new HashSet<>();
    }

}
