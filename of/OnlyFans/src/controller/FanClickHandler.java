package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Utente;
import model.fans.AbstractFan;
import view.MainView;

public class FanClickHandler implements EventHandler<MouseEvent> {

    private boolean clickable = true;
    private MainView mv;
    private Utente u;
    private AbstractFan af;

    public FanClickHandler(MainView mv, Utente u, AbstractFan af){
        this.mv=mv;
        this.u=u;
        this.af=af;
    }

    public void handle(MouseEvent e){
        if (clickable){
            if(u.hasEnoughFundsFor(af)) {
                if (!u.subscriptions.contains(af)) {
                    u.subscriptions.add(af);
                }
                mv.refresh();
                System.out.println(u);
            }
        }else{
            System.out.println("not clicking");
        }
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }
}
