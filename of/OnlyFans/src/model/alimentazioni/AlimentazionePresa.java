package model.alimentazioni;

import model.enums.Alimentazionie;

public class AlimentazionePresa extends AbstractAlimentazioneElettrica{

    public AlimentazionePresa(){
        this.fun = (arg)->{return arg * 2;};
        this.al = Alimentazionie.Presa;
    }
}
