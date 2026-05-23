package model;

import model.fans.AbstractFan;
import model.fans.comparators.CostFanComparator;

import java.util.ArrayList;

public class Utente {

    private int funds=100;
    private int monthlycosts=0;

    public ArrayList<AbstractFan> subscriptions;

    public Utente(){
        subscriptions=new ArrayList<>();
    }

    public void addFunds(){
        this.funds+=100;
    }

    public int getCapitale() {
        return this.funds;
    }

    public int spesaMensile() {
        int ret = 0;
        for (AbstractFan af: this.subscriptions) {
            ret += af.getCosto();
        }
        this.monthlycosts = ret;
        return monthlycosts;
    }

    public boolean enoughFundsForOneMonth(){
        return this.funds > this.monthlycosts;
    }
    public void payOneMonth(){
        this.funds-=this.monthlycosts;
    }

    public boolean hasEnoughFundsFor(AbstractFan af) {
        return this.funds>af.getCosto();
    }

    public void removeMostCostly(){
        this.subscriptions.sort(new CostFanComparator());
        this.subscriptions.remove(this.subscriptions.size()-1);
    }

    public String toString(){
        String ret = "[";
        for (AbstractFan f :this.subscriptions) {
            ret += f.toString()+"\n,";
        }
        return ret+"]";
    }
}
