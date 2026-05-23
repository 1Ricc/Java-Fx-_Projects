package view;

import controller.CompraHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.cosechescadono.medicine.IntfMedicina;

public class FullMedicinePane extends VBox {
    private MedicinaPane mp;
    private Button cb;

    public FullMedicinePane(IntfMedicina e, MainView mv){
        this.mp = new MedicinaPane(e, mv);
        this.cb = new Button("Compra");
        this.getChildren().add(mp);
        this.getChildren().add(cb);

        this.cb.addEventHandler(MouseEvent.MOUSE_CLICKED, new CompraHandler(mp.getMedicina(), mv));

        this.setAlignment(Pos.CENTER);
    }
}
