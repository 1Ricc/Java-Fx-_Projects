package view;

import controller.TitleClickHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.TitlesList;
import model.titlekinds.Title;
import view.sortersview.SortersView;
import view.titleviews.TitleFullView;

public class MainView extends BorderPane {

    private TopView tv;
    private TitleFullView tfv;
    private SortersView sv;
    private Button cl;

    public MainView (TitlesList t){
        super();

        tv = new TopView(t,this);
        tfv = new TitleFullView(null, this);
        sv = new SortersView(t,this);
        cl = new Button("Clear");
        cl.addEventHandler(MouseEvent.MOUSE_CLICKED, new TitleClickHandler(null,this) );

        this.setTop(tv);
        this.setCenter(tfv);
        this.setRight(sv);
        this.setLeft(cl);

        tv.setAlignment(Pos.CENTER);

        this.redraw();
    }

    public void redraw(){
        this.tv.redraw();
        this.tfv.redraw();
    }

    public void resetMainTitle() {
        this.internalSetTitle(null);
    }
    public void setMainTitle(Title t) {
        this.internalSetTitle(t);
    }

    private void internalSetTitle(Title t){
        tfv = new TitleFullView(t, this);
        this.setCenter(tfv);
        this.redraw();
    }
}
