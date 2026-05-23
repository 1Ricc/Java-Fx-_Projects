package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.TitlesList;
import model.titlekinds.Title;
import view.MainView;
import java.util.Comparator;

public class SortHandler implements EventHandler<MouseEvent> {

    private TitlesList t;
    private Comparator<Title> c;
    private MainView m;

    public SortHandler(TitlesList t, Comparator<Title> c, MainView m){
        this.t = t;
        this.c = c;
        this.m = m;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        t.sort(c);
        m.redraw();
    }
}
