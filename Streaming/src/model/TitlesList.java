package model;

import model.exceptions.CannotDecreaseWindowException;
import model.exceptions.CannotIncreaseWindowException;
import model.titlekinds.Title;

import java.util.ArrayList;

public class TitlesList extends ArrayList<Title> {

    private int startWindow;
    private final int windowSize;

    public TitlesList(){
        this.startWindow = 0;
        this.windowSize = 3;
    }

    public void increaseStartWindow() throws CannotIncreaseWindowException{
        if (this.startWindow + this.windowSize < this.size()){
            this.startWindow ++;
        }else{
            throw new CannotIncreaseWindowException();
        }
    }

    public void decreaseStartWindow() throws CannotDecreaseWindowException {
        if (this.startWindow > 0){
            this.startWindow --;
        }else{
            throw new CannotDecreaseWindowException();
        }
    }

    public ArrayList<Title> getSizedWindow(){
        // invariant: this contains elements at least from index 'startwindow' for 'windowsize' cells
        ArrayList<Title> ret = new ArrayList<>();
        for (int i = this.startWindow; i<this.startWindow+this.windowSize; i++){
            ret.add(this.get(i));
        }
        return ret;
    }
}
