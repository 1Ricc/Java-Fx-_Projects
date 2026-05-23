package model.cosechescadono.medicine;

import model.enums.MedicineNames;
import java.util.Date;

public class MedicinaDaBanco extends AbstractMedicina {

    public MedicinaDaBanco(MedicineNames n, int c, Date s) {
        super(n, c, s);
    }

    @Override
    protected String stampa_Metadati() {
        return "Medicinale da banco";
    }

}
