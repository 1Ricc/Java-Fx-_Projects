package view;

import controller.RicettaHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.cosechescadono.ricette.IntfRicetta;

public class RicettaPane extends Button {
    private IntfRicetta ricetta;

    RicettaPane(IntfRicetta r){
        this.ricetta = r;

        this.setText(this.ricetta.stampa_Dati());
        this.setDisable(this.ricetta.is_Scaduta());
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, new RicettaHandler(this, ricetta));
    }

    public void refresh(){
        this.setText(this.ricetta.stampa_Dati());
    }

}
