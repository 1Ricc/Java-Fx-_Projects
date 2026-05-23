package model.cosechescadono.medicine;

import model.enums.MedicineNames;
import model.cosechescadono.ricette.IntfRicetta;
import model.exceptions.*;

import java.util.ArrayList;
import java.util.Date;

public class MedicinaCRRipetibile extends AbstractMedicinaConRicetta{

    private int limite;

    public MedicinaCRRipetibile(MedicineNames n, int c, Date s, IntfRicetta r, int l) {
        super(n, c, s, r);
        this.limite = l;
    }

    @Override
    protected String stampa_Metadati_Ricetta() {
        return "Ripetibile fino a " + this.limite + " volte.";
    }

    @Override
    protected void set_sconto_statale() {
        this.sconto_statale = 5;
    }

    @Override
    public void select(ArrayList<IntfRicetta> ar, int money) throws NoRicettaException, RicettaScadutaException, RicettaNonSelezionataException, NotEnoughMoneyException, MedicinaScadutaException, RicettaUsataTroppeVolteException {
        super.select(ar, money);
        this.ricetta.usa(this.limite);
    }
}
