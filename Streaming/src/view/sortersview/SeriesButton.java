package view.sortersview;

import controller.SeriesClickHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.titlekinds.Title;
import view.MainView;
import view.titleviews.TitleFullView;


public class SeriesButton extends Button {

    public SeriesButton(Title t, TitleFullView tfv, MainView m, int i){
        super("S "+i);
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, new SeriesClickHandler(t,tfv,m,this));
    }
}
