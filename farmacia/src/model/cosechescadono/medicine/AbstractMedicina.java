package model.cosechescadono.medicine;

import model.cosechescadono.AbstractScade;
import model.enums.MedicineNames;
import model.exceptions.*;
import model.cosechescadono.ricette.IntfRicetta;
import java.util.ArrayList;
import java.util.Date;

public abstract class AbstractMedicina extends AbstractScade implements IntfMedicina {

    protected MedicineNames name;
    protected int costo;

    protected AbstractMedicina(MedicineNames n, int c, Date s){
        super(s);
        this.name = n;
        this.costo = c;
    }

    @Override
    public String stampa_Dati() {
        String ret = new String(this.name.toString()+"\n");
        ret += "Costo base: " + this.costo + "$" + ", Scontato a " + this.get_Prezzo_Scontato() + "$\n";
        if (this.is_Scaduta()){
            ret += "scaduta";
        }else{
            ret += "scadenza: "+this.data_scadenza.toString();
        }
        ret += "\n"+stampa_Metadati()+"";
        return ret;
    }

    @Override
    public int get_Prezzo_Scontato(){
        int ret = this.costo;
        ret -= this.get_discounts();
        return ret;
    }

    @Override
    public void select(ArrayList<IntfRicetta> ar, int money) throws RicettaScadutaException, NoRicettaException, RicettaNonSelezionataException, NotEnoughMoneyException, MedicinaScadutaException, RicettaUsataTroppeVolteException {
        if (this.is_Scaduta()){
            throw new MedicinaScadutaException();
        }
        if (this.get_Prezzo_Scontato() > money){
            throw new NotEnoughMoneyException();
        }
    }

    protected abstract String stampa_Metadati();

    protected int get_discounts(){
        return 0;
    }
}
