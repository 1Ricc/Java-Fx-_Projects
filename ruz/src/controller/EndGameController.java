package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import model.Game;
import model.classifica.Classifica;
import model.classifica.ClassificaEntry;
import view.ClassificaPane;
import view.MainView;

public class EndGameController implements EventHandler<ActionEvent> {

    private Game g;
    private Classifica c;
    private ClassificaPane cp;
    private MainView mv;

    public EndGameController(Game g, Classifica c, ClassificaPane cp, MainView mv){
        this.g = g;
        this.c = c;
        this.cp = cp;
        this.mv = mv;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog td = new TextInputDialog("Inserire nome");
        td.showAndWait();
        String name = td.getEditor().getText();
        int score = g.getScore();

        ClassificaEntry ce = new ClassificaEntry(name, score);
        c.add(ce);
        cp = new ClassificaPane();
        for (ClassificaEntry i: c.getClassifica()) {
            cp.getChildren().add(new Text(i.toString()));
        }
        this.g.resetScore();
        this.mv.updateScore(this.g);
        this.mv.refreshClassifica(this.cp);
    }
}
