package model.cosechescadono.medicine;

import model.cosechescadono.IntfScade;
import model.exceptions.*;
import model.cosechescadono.ricette.IntfRicetta;
import java.util.ArrayList;

public interface IntfMedicina extends IntfScade {

    String stampa_Dati();
    int get_Prezzo_Scontato();
    void select(ArrayList<IntfRicetta> ar, int money) throws NoRicettaException, RicettaScadutaException, RicettaNonSelezionataException, NotEnoughMoneyException, MedicinaScadutaException, RicettaUsataTroppeVolteException;
}
