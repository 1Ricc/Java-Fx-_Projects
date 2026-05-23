package model.alimentazioni;

import model.enums.Alimentazionie;

public class AlimentazioneBatteria extends AbstractAlimentazioneElettrica{

    public AlimentazioneBatteria(){
        this.fun = (arg)->{return arg * 3;};
        this.al = Alimentazionie.Batteria;
    }
}
