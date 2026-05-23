package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.cosechescadono.medicine.IntfMedicina;
import view.FullMedicinePane;
import view.MainView;
import view.MedicinaPane;

public class MedicinaHandler implements EventHandler {

    private MedicinaPane mp;
    private IntfMedicina m;
    private MainView mv;

    public MedicinaHandler(MedicinaPane rp, IntfMedicina r, MainView mv){
        this.mp = rp;
        this.m = r;
        this.mv = mv;
    }

    @Override
    public void handle(Event event) {
        FullMedicinePane fmp = new FullMedicinePane(this.m, this.mv);
        this.mv.setCenter(fmp);
    }
}