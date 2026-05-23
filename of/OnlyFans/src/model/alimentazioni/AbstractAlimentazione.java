package model.alimentazioni;

import model.enums.Alimentazionie;

import java.util.function.IntUnaryOperator;

public abstract class AbstractAlimentazione {
    protected IntUnaryOperator fun;
    protected Alimentazionie al;

    public int calcolaCostoFinale(int costo){
        return fun.applyAsInt(costo);
    }

    public String toString(){
        return this.al.name();
    }
}
