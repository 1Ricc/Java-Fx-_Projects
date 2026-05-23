package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import model.exceptions.CannotDecreaseWindowException;
import model.exceptions.CannotIncreaseWindowException;
import model.titlekinds.Title;
import model.TitlesList;
import view.titleviews.TitleShortView;

import java.util.ArrayList;

public class TopView extends HBox {

    private Button lb;
    private Button rb;
    private TitlesList titles;
    private MainView m;

    TopView(TitlesList t, MainView m){
        lb = new Button("<");
        lb.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try {
                            t.decreaseStartWindow();
                            m.redraw();
                        } catch (CannotDecreaseWindowException e) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Inizio Catalogo "  , ButtonType.OK);
                            alert.showAndWait();
                        }
                    }
                }
        );
        rb = new Button(">");
        rb.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try {
                            t.increaseStartWindow();
                            m.redraw();
                        } catch (CannotIncreaseWindowException e) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Fine catalogo"  , ButtonType.OK);
                            alert.showAndWait();
                        }
                    }
                }
        );
        this.titles = t;
        this.m = m;
        this.redraw();
    }

    public void redraw(){
        this.getChildren().removeAll(this.getChildren());
        this.getChildren().add(lb);
        ArrayList<Title> view = titles.getSizedWindow();
        for (Title t: view) {
            this.getChildren().add(new TitleShortView(t,this.m));
        }
        this.getChildren().add(rb);
    }
}
