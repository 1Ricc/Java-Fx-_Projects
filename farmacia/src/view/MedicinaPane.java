package view;

import controller.MedicinaHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.cosechescadono.medicine.IntfMedicina;

public class MedicinaPane extends Text {
    private IntfMedicina medicina;
    private MainView mv;

    MedicinaPane(IntfMedicina m, MainView mv){
        this.medicina = m;
        this.mv = mv;

        this.refresh();
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, new MedicinaHandler(this, this.medicina, this.mv));
    }

    public void refresh(){
        this.setText(this.medicina.stampa_Dati());
    }

    public IntfMedicina getMedicina() {
        return this.medicina;
    }
}
