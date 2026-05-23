package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.cosechescadono.ricette.IntfRicetta;
import view.RicettaPane;

public class RicettaHandler implements EventHandler {

    private RicettaPane rp;
    private IntfRicetta r;

    public RicettaHandler(RicettaPane rp, IntfRicetta r){
        this.rp = rp;
        this.r = r;
    }

    @Override
    public void handle(Event event) {
        this.r.select();
        this.rp.refresh();
        this.rp.setDisable(true);
    }
}
