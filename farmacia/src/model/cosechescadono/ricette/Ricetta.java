package model.cosechescadono.ricette;

import model.cosechescadono.AbstractScade;
import model.enums.MedicineNames;
import model.exceptions.RicettaUsataTroppeVolteException;

import java.util.Date;

public class Ricetta extends AbstractScade implements IntfRicetta{

    private MedicineNames perqualemedicina;
    private boolean selected;

    private int volteusata;

    public Ricetta(MedicineNames m, Date ds){
        super(ds);
        this.perqualemedicina = m;
        this.selected = false;
        this.volteusata = 0;
    }

    @Override
    public MedicineNames getMedicina() {
        return this.perqualemedicina;
    }

    @Override
    public void select() {
        this.selected = true;
    }

    @Override
    public String stampa_Dati() {
        String ret = "Ricetta per: " + this.perqualemedicina +"\n";

        if (this.is_Scaduta()){
            ret += "scaduta";
        }else {
            ret += "valida fino al " + this.data_scadenza;
        }
        if(this.selected){
            ret += "\n (selezionata)";
        }
        return ret;
    }

    @Override
    public void reset_selected() {
        this.selected = false;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    public void usa(int max) throws RicettaUsataTroppeVolteException {
        if (this.volteusata >= max){
            throw new RicettaUsataTroppeVolteException();
        }
        this.volteusata++;
    }
}
