package view.titleviews;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.titlekinds.SeriesTitle;
import model.titlekinds.Title;
import view.MainView;
import view.sortersview.SeriesButton;

import java.text.DecimalFormat;

public class TitleFullView extends VBox {

    private Title t;
    private MainView m;
    private int selectedSeasons = 0;
    private HBox seriesbox;
    private Button acquistaButton;

    public TitleFullView(Title t, MainView m){
        if (t == null){
            return;
        }

        this.t = t;
        this.m = m;
        this.seriesbox = new HBox();
        if (t instanceof SeriesTitle){
            for (int i = 1; i <= ((SeriesTitle) t).getSeasons(); i++) {
                SeriesButton bb = new SeriesButton(this.t, this, m, i);
                seriesbox.getChildren().add(bb);
            }
        }
        seriesbox.setAlignment(Pos.CENTER);

        this.acquistaButton = new Button("Acquista");
        acquistaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Connessione non presente "  , ButtonType.OK);
                alert.showAndWait();
            }
        });
    }

    public void redraw(){
        if (t == null){
            return;
        }
        this.getChildren().removeAll(this.getChildren());
        this.getChildren().add(new Text("Titolo: "+t.getTitle()));
        this.getChildren().add(new Text("Anno: "+t.getYear()));
        this.getChildren().add(new Text("Lingua: "+t.getLanguage()));
        this.getChildren().add(new Text("Prezzo base: "+t.getPrice()));
        if (t instanceof SeriesTitle){
            this.getChildren().add(seriesbox);
        }
        double p = this.getBuyPrice(t);

        acquistaButton.setText("Acquista: "+ new DecimalFormat("##.##").format(p));
        this.getChildren().add(acquistaButton);

        this.setAlignment(Pos.CENTER);
    }

    public void incrementSelectedSeasons(){
        this.selectedSeasons++;
    }

    private double getBuyPrice(Title t){
        double p = t.getDiscountPrice(this.selectedSeasons);
        int factor = 1;
        if (t instanceof SeriesTitle){
            factor = this.selectedSeasons;
        }
        p *= factor;
        return p;
    }
}
