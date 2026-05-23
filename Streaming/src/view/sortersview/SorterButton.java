package view.sortersview;

import controller.SortHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.titlekinds.Title;
import model.TitlesList;
import view.MainView;

import java.util.Comparator;

public class SorterButton extends Button {

    SorterButton(String title, TitlesList t, Comparator<Title> c, MainView m){
        super(title);
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, new SortHandler(t,c, m));
    }
}
