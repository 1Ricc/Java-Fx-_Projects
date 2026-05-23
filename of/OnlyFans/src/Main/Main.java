package Main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Utente;
import model.Vetrina;
import view.MainView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Utente u = new Utente();
        Vetrina v = new Vetrina();

        MainView mv = new MainView(u,v);

        StackPane root = new StackPane(mv);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}