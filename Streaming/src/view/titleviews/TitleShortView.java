package view.titleviews;

import controller.TitleClickHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.titlekinds.Title;
import model.titlekinds.AnimeTitle;
import model.titlekinds.FilmTitle;
import model.titlekinds.SeriesTitle;
import view.MainView;

public class TitleShortView extends StackPane {

    private Title t;

    private Rectangle r;
    private Text tx;

    public TitleShortView(Title t, MainView m){
        this.t = t;

        r = new Rectangle(130,40);
        r.setFill( TitleShortView.getColourOfTitle(t) );
        tx = new Text(t.getShortTitle());

        this.setEventHandler(MouseEvent.MOUSE_CLICKED, new TitleClickHandler(t, m));
        this.redraw();
    }
    public void redraw(){
        this.getChildren().add(r);
        this.getChildren().add(tx);
    }

    public static Color getColourOfTitle(Title t){
        if (t instanceof AnimeTitle){
            return Color.SALMON;
        }
        if (t instanceof FilmTitle){
            return Color.CYAN;
        }
        if (t instanceof SeriesTitle){
            return Color.MAGENTA;
        }
        return Color.BLACK;
    }

}
