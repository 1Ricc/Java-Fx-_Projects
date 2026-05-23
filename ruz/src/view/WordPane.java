package view;

import javafx.scene.text.Text;

public class WordPane extends Text {

    public WordPane(){
        this.reset();
    }

    public void addChar(char c){
        this.setText(this.getText()+c);
    }

    public void reset(){
        this.setText("Parola Corrente: ");
    }
}
