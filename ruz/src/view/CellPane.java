package view;

import controller.CellController;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CellPane extends StackPane {
    private static int SIDE = 70;
    private Rectangle r;
    private Rectangle r2;
    private Text t;
    private Color clickedcolor;

    public CellPane(String c, CellController cc, Color bordercolor, Color col){
        this.r = new Rectangle(SIDE-2,SIDE-2);
        this.r2 = new Rectangle(SIDE, SIDE);
        this.t = new Text(c+"");
        r2.setFill(bordercolor);
        this.clickedcolor = col;
        this.getChildren().add(r2);
        this.getChildren().add(r);
        this.getChildren().add(t);

        this.deactivateBg();
        this.setEventHandler(MouseEvent.MOUSE_CLICKED, cc);
    }

    public void activateBg(){
        this.r.setFill(this.clickedcolor);
    }

    public void deactivateBg(){
        this.r.setFill(Color.GRAY);
    }
}
