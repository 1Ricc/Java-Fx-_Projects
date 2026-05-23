package view;

import controller.CellController;
import controller.WordController;
import javafx.scene.layout.GridPane;
import model.Game;
import model.cell.CellInterface;

public class GrigliaPane extends GridPane {

    public GrigliaPane(Game g, WordController wc){
        CellInterface[][] gr = g.getGrid();

        for (int rows = 0; rows < Game.SIZE; rows++){
            for (int cols = 0 ; cols < Game.SIZE; cols++){
                CellInterface ac = gr[rows][cols];
                CellController cc = new CellController(ac, wc);
                this.add(cc.getCp(), cols, rows);
            }
        }
    }
}
