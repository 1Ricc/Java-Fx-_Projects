package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import model.titlekinds.Title;
import view.MainView;
import view.titleviews.TitleFullView;

public class SeriesClickHandler implements EventHandler<MouseEvent> {

    private Title t;
    private TitleFullView tfv;
    private MainView m;
    private Button b;

    public SeriesClickHandler(Title t, TitleFullView tfv, MainView m, Button b){
        this.t = t;
        this.tfv = tfv;
        this.m = m;
        this.b = b;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        b.setDisable(true);
        tfv.incrementSelectedSeasons();
        m.redraw();
    }
}
