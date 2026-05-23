package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.Game;
import model.InexistentWordException;
import model.Word;
import view.MainView;

public class TrovaController implements EventHandler<ActionEvent> {

    private Game g;
    private Word w;
    private MainView mv;

    public TrovaController(Game g, Word w, MainView mv){
        this.g = g;
        this.w = w;
        this.mv = mv;
    }

    @Override
    public void handle(ActionEvent event) {
        try{
            this.g.addScore(this.w);
            this.mv.updateScore(this.g);
        } catch (InexistentWordException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Parola non trovata");
            a.showAndWait();
        }
        this.mv.resetWc();
    }
}
