package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.titlekinds.Title;
import view.MainView;

public class TitleClickHandler implements EventHandler<MouseEvent> {

    private Title t;
    private MainView m;

    public TitleClickHandler(Title t, MainView m){
        this.t = t;
        this.m = m;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (t == null){
            m.resetMainTitle();
        }else{
            m.setMainTitle(t);
        }
    }
}
