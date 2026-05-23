package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Word;
import model.classifica.Classifica;
import view.MainView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Game g = new Game();
        Word w = new Word();
        Classifica c = new Classifica();

        MainView mv = new MainView(g, w, c);

        primaryStage.setTitle("Ruzzol-ARE");
        primaryStage.setScene(new Scene(mv, 280, 500));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}