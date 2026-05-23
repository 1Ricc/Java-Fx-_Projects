package model.cosechescadono.medicine;

import model.enums.MedicineNames;
import model.cosechescadono.ricette.IntfRicetta;
import java.util.Date;

public class MedicinaCRNonRipetibile extends AbstractMedicinaConRicetta{

    public MedicinaCRNonRipetibile(MedicineNames n, int c, Date s, IntfRicetta r) {
        super(n, c, s, r);
    }

    @Override
    protected String stampa_Metadati_Ricetta() {
        return "Non Ripetibile";
    }

    @Override
    protected void set_sconto_statale() {
        this.sconto_statale = 10;
    }
}
