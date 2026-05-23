package model.cosechescadono.ricette;

import model.enums.MedicineNames;
import model.cosechescadono.IntfScade;
import model.exceptions.RicettaUsataTroppeVolteException;

public interface IntfRicetta extends IntfScade {

    MedicineNames getMedicina();
    void select();
    String stampa_Dati();
    void reset_selected();
    boolean isSelected();
    void usa(int max) throws RicettaUsataTroppeVolteException;
}
