package model.cosechescadono;

import Main.Main;
import java.util.Date;

public class AbstractScade implements IntfScade {
    protected Date data_scadenza;

    protected AbstractScade(Date ds){
        this.data_scadenza = ds;
    }

    @Override
    public boolean is_Scaduta(){
        return this.data_scadenza.before(Main.TODAY);
    }

}
