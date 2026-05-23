package view;

import controller.EndGameController;
import controller.TrovaController;
import controller.WordController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Game;
import model.Word;
import model.classifica.Classifica;

public class MainView extends VBox {

    private GrigliaPane gp;
    private WordPane wp;
    private Button trovabutton;
    private Text score;
    private Button terminabutton;
    private ClassificaPane cp;
    private WordController wc;

    public MainView(Game g, Word w, Classifica c){
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);

        this.wp = new WordPane();
        wc = new WordController(wp, w);
        this.trovabutton = new Button("Trova");
        this.trovabutton.setOnAction(new TrovaController(g, w, this));
        HBox hb1 = new HBox();
        hb1.getChildren().add(this.trovabutton);
        hb1.getChildren().add(this.wp);
        hb1.setSpacing(20);
        hb1.setAlignment(Pos.CENTER_LEFT);

        this.score = new Text();
        this.updateScore(g);
        this.terminabutton = new Button("Termina");

        this.cp = new ClassificaPane();
        this.terminabutton.setOnAction(new EndGameController(g, c, cp, this));
        HBox hb2 = new HBox();
        hb2.getChildren().add(this.score);
        hb2.getChildren().add(this.terminabutton);
        hb2.setSpacing(20);
        hb2.setAlignment(Pos.CENTER);

        VBox vb1 = new VBox();
        vb1.getChildren().add(hb1);
        vb1.getChildren().add(hb2);
        vb1.setSpacing(10);

        this.gp = new GrigliaPane(g, wc);
        this.getChildren().add(this.gp);
        this.getChildren().add(vb1);
        this.getChildren().add(this.cp);

        this.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE){
                this.trovabutton.fire();
            }
            if (keyEvent.getCode() == KeyCode.T){
                this.terminabutton.fire();
            }
        });
    }

    public void updateScore(Game g) {
        this.score.setText("Punteggio: "+g.getScore());
    }

    public void resetWc() {
        this.wc.reset();
    }

    public void refreshClassifica(ClassificaPane cp){
        this.getChildren().remove(this.cp);
        this.cp = cp;
        this.getChildren().add(this.cp);
    }
}
