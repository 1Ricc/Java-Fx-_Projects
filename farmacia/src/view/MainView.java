package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.cosechescadono.medicine.IntfMedicina;
import model.cosechescadono.ricette.IntfRicetta;
import java.util.ArrayList;

public class MainView extends BorderPane {

    ArrayList<IntfMedicina> medicine;
    ArrayList<IntfRicetta> ricette;
    int soldi;

    VBox lb;
    VBox rb;
    HBox bb;

    public MainView (ArrayList<IntfRicetta> rs, ArrayList<IntfMedicina> ms){
        this.medicine = ms;
        this.ricette = rs;
        lb = new VBox();
        rb = new VBox();
        bb = new HBox();
        soldi = 30;

        // left
        lb = new VBox();
        refreshLeft();
        this.setLeft(lb);

        // right
        rb = new VBox();
        refreshRight();
        this.setRight(rb);
        
        // bottom
        bb = new HBox();
        refreshBottom();
        this.setBottom(bb);

        lb.setSpacing(10);
        rb.setSpacing(10);
        bb.setSpacing(10);
    }

    public void refreshLeft() {
        lb.getChildren().removeAll(lb.getChildren());
        medicine.forEach( e -> {
            lb.getChildren().add( new MedicinaPane(e, this) );
        });
    }
    public void refreshRight(){
        rb.getChildren().removeAll(rb.getChildren());
        ricette.forEach( e -> {
            e.reset_selected();
            rb.getChildren().add( new RicettaPane(e) );
        });
    }
    private void refreshBottom(){
        bb.getChildren().removeAll(bb.getChildren());
        Text st = new Text("$ totali: " + this.soldi);
        bb.getChildren().add(st);
        Text dt = new Text( "Data Odierna: " + Main.Main.TODAY);
        bb.getChildren().add(dt);
    }
    private void refreshCenter(){
        this.setCenter(null);
    }

    private void refreshAll(){
        this.refreshBottom();
        this.refreshLeft();
        this.refreshRight();
        this.refreshCenter();
    }

    public void paga(int tot){
        this.soldi -= tot;
        this.refreshAll();
    }

    public ArrayList<IntfRicetta> getRicette(){
        return this.ricette;
    }

    public int getcurrentmoney() {
        return this.soldi;
    }
}
