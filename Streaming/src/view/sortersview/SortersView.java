package view.sortersview;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.TitlesList;
import model.comparators.TitleNameComparator;
import model.comparators.TitleTypeComparator;
import model.comparators.TitleYearComparator;
import view.MainView;

public class SortersView extends VBox {

    public SortersView(TitlesList t, MainView m){
        SorterButton byname = new SorterButton("Nome", t, new TitleNameComparator(), m);
        SorterButton byyear = new SorterButton("Anno", t, new TitleYearComparator(), m);
        SorterButton bytype = new SorterButton("Tipo", t, new TitleTypeComparator(), m);

        this.getChildren().add(new Text("Ordina per:"));
        this.getChildren().add(byname);
        this.getChildren().add(byyear);
        this.getChildren().add(bytype);

        this.setSpacing(10);
    }
}
