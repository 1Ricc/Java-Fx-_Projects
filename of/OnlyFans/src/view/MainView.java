package view;

import controller.FanClickHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Utente;
import model.Vetrina;
import model.fans.AbstractFan;
import model.fans.comparators.CostFanComparator;
import model.fans.comparators.TypeFanComparator;

public class MainView extends BorderPane {
    Utente u;
    Vetrina v;
    int mesi=0;

    HBox tb;
    VBox bottombox;

    public MainView(Utente u, Vetrina v){
        this.u = u;
        this.v = v;

        // top
        tb = new HBox();
        refreshTop();
        this.setTop(tb);

        // center

        // left
        Button bn = new Button();
        bn.setText("Prox Mese");
        bn.setOnAction((e)->{
            if (u.enoughFundsForOneMonth()){
                u.payOneMonth();
                this.mesi+=1;
                this.refresh();
            }else{
                u.removeMostCostly();
                this.refresh();
            }
        });
        Button bp = new Button();
        bp.setText("+ 100 Fondi");
        bp.setOnAction((e)->{
            u.addFunds();
            this.refresh();
        });
        VBox lb = new VBox();
        lb.getChildren().add(bn);
        lb.getChildren().add(bp);

        this.setLeft(lb);

        // right
        Button bt = new Button();
        bt.setText("Ordina per Tipo");
        bt.setOnAction((e)->{
            TypeFanComparator tf = new TypeFanComparator();
            v.fandisponibili.sort(tf);
            this.refreshBottom();
        });

        Button bd = new Button();
        bd.setText("Ordina per Data");
        bd.setOnAction((e)->{
            CostFanComparator cf = new CostFanComparator();
            v.fandisponibili.sort(cf);
            this.refreshBottom();
        });

        VBox hb = new VBox();
        hb.getChildren().add(bt);
        hb.getChildren().add(bd);

        this.setRight(hb);

        // bottom
        bottombox = new VBox();
        refreshBottom();
        this.setCenter(bottombox);
    }

    private void refreshTop(){
        tb.getChildren().removeAll(tb.getChildren());
        tb.getChildren().add(new Text("Capitale: "+u.getCapitale()+" "));
        tb.getChildren().add(new Text("Spesa Mensile: "+u.spesaMensile()+" "));
        tb.getChildren().add(new Text("Mesi Trascorsi: "+this.mesi));
    }
    private void refreshBottom(){
        bottombox.getChildren().removeAll(bottombox.getChildren());
        for (AbstractFan af: v.fandisponibili ) {
            FanClickHandler fch = new FanClickHandler(this,u,af);
            FanPane fp = new FanPane(af,fch,true,u);
            bottombox.getChildren().add(fp);
        }
    }
    public void refresh(){
        this.refreshTop();
        this.refreshBottom();
    }
}
