package view;

import controller.FanClickHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.Utente;
import model.fans.AbstractFan;

public class FanPane extends StackPane {
    private Circle c;
    private Text t;

    public AbstractFan af;
    private FanClickHandler fc;
    public Utente u;

    public FanPane(AbstractFan a, FanClickHandler fc, boolean clickable, Utente u){
        this.af = a;
        this.fc = fc;
        this.u = u;
        fc.setClickable(clickable);
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, fc);
        refresh();
    }
    public void refresh(){
        this.getChildren().removeAll(this.getChildren());
        HBox h = new HBox();
        c = new Circle(25);
        t = new Text(af.toString());
        h.getChildren().add(c);
        h.getChildren().add(t);
        this.getChildren().add(h);
        boolean cl = u.hasEnoughFundsFor(this.af);
        this.setClickable(cl);
        if (!cl){
            c.setFill(Color.GRAY);
        }else{
            c.setFill(Color.BLUE);
        }
        c.setStrokeWidth(5);
        if(u.subscriptions.contains(af)){
            c.setStroke(Color.RED);
        }else{
            c.setStroke(Color.BLACK);
        }
    }

    public void setClickable(boolean clickable) {
        this.fc.setClickable(clickable);
    }
}
