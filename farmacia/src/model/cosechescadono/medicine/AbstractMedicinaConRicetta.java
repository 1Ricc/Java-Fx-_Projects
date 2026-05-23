package model.cosechescadono.medicine;

import model.enums.MedicineNames;
import model.exceptions.*;
import model.cosechescadono.ricette.IntfRicetta;
import java.util.ArrayList;
import java.util.Date;

public abstract class AbstractMedicinaConRicetta extends AbstractMedicina {

    protected IntfRicetta ricetta;
    protected int sconto_statale;

    protected AbstractMedicinaConRicetta(MedicineNames n, int c, Date s, IntfRicetta r) {
        super(n, c, s);
        if (this.name != r.getMedicina()){
            throw new RuntimeException();
        }
        this.ricetta = r;
        this.set_sconto_statale();
    }

    protected abstract String stampa_Metadati_Ricetta();
    protected abstract void set_sconto_statale();

    protected String stampa_Metadati(){
        String ret = "Con ricetta: ";
        ret += this.stampa_Metadati_Ricetta();
        return ret;
    }

    @Override
    protected int get_discounts() {
        return this.sconto_statale;
    }

    @Override
    public void select(ArrayList<IntfRicetta> ar, int money) throws NoRicettaException, RicettaScadutaException, RicettaNonSelezionataException, NotEnoughMoneyException, MedicinaScadutaException, RicettaUsataTroppeVolteException {
        super.select(ar, money);

        if (!ar.contains(this.ricetta)){
            throw new NoRicettaException();
        }
        if (!this.ricetta.isSelected()){
            throw new RicettaNonSelezionataException();
        }
        if (this.ricetta.is_Scaduta()){
            throw new RicettaScadutaException();
        }
    }
}
