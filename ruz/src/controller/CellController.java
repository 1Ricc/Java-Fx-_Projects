package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.cell.CellInterface;
import view.CellPane;

public class CellController implements EventHandler<MouseEvent> {

    private CellInterface ac;
    private CellPane cp;
    private WordController wc;
    private boolean isactive;

    public CellController(CellInterface a, WordController wc){
        this.ac = a;
        this.cp = new CellPane(this.ac.getDisplay(), this, a.getBorderColor(), a.getClickedColor());
        this.wc = wc;
        this.isactive = false;
    }

    public CellPane getCp(){
        return this.cp;
    }

    public CellInterface getAc(){
        return this.ac;
    }

    @Override
    public void handle(MouseEvent event) {
        if (!this.isactive){
            this.isactive = true;
            this.cp.activateBg();
            this.wc.addChar(this);
        }
    }

    public void reset(){
        this.isactive = false;
        this.cp.deactivateBg();
    }
}
