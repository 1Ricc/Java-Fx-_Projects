package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.LanguagesEnum;
import model.TitlesList;
import model.titlekinds.AnimeTitle;
import model.titlekinds.AnimeWithSubTitle;
import model.titlekinds.FilmTitle;
import model.titlekinds.SeriesTitle;
import view.MainView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        TitlesList tl = new TitlesList();
        tl.add(
                new SeriesTitle("Boris", 2010, LanguagesEnum.Italiano, 4, 10)
        );
        tl.add(
                new AnimeWithSubTitle("Attack on Titan", 2013, LanguagesEnum.Giapponese, LanguagesEnum.Inglese, 10)
        );
        tl.add(
                new FilmTitle("Parasite", 2019, LanguagesEnum.Inglese, 20)
        );
        tl.add(
                new AnimeTitle("Pokemon", 2010, LanguagesEnum.Inglese, 10)
        );
        tl.add(
                new FilmTitle("The Irishman", 2010, LanguagesEnum.Inglese, 5)
        );
        tl.add(
                new SeriesTitle("1994", 2019, LanguagesEnum.Italiano, 3, 10)
        );
        tl.add(
                new FilmTitle("Her", 2013, LanguagesEnum.Inglese, 20)
        );

        MainView root = new MainView(tl);
        primaryStage.setTitle("Stream this");
        primaryStage.setScene(new Scene(root, 500, 250));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}