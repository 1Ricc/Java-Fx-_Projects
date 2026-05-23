package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.enums.MedicineNames;
import model.cosechescadono.medicine.IntfMedicina;
import model.cosechescadono.medicine.MedicinaCRNonRipetibile;
import model.cosechescadono.medicine.MedicinaCRRipetibile;
import model.cosechescadono.medicine.MedicinaDaBanco;
import model.cosechescadono.ricette.IntfRicetta;
import model.cosechescadono.ricette.Ricetta;
import view.MainView;
import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {

    public static Date TODAY = new Date();

    @Override
    public void start(Stage primaryStage) throws Exception{

        Date tomorrow  = new Date(TODAY.getTime()+100000000);
        Date yesterday = new Date(TODAY.getTime()-100000000);
        System.out.println(TODAY);
        System.out.println(tomorrow);
        System.out.println(yesterday);

        IntfRicetta ricettabrufen800 = new Ricetta(MedicineNames.Brufen800,yesterday);
        IntfRicetta ricettaOki = new Ricetta(MedicineNames.Oki,tomorrow);
        IntfRicetta ricettaTachi = new Ricetta(MedicineNames.Tachipirina1000, tomorrow);
        IntfRicetta ricettaFluifort = new Ricetta(MedicineNames.Fluifort,tomorrow);

        IntfMedicina benagol = new MedicinaDaBanco(MedicineNames.Benagol, 10, tomorrow);
        IntfMedicina brufen200 = new MedicinaDaBanco( MedicineNames.Brufen200, 8, tomorrow);
        IntfMedicina brufen800 = new MedicinaCRNonRipetibile(MedicineNames.Brufen800, 20, tomorrow, ricettabrufen800);
        IntfMedicina oki = new MedicinaCRRipetibile(MedicineNames.Oki, 12, tomorrow, ricettaOki, 4);
        IntfMedicina fluifort = new MedicinaCRRipetibile(MedicineNames.Fluifort, 18, yesterday, ricettaFluifort, 3);
        IntfMedicina tachipirina = new MedicinaCRRipetibile(MedicineNames.Tachipirina1000, 6, tomorrow, ricettaTachi, 2);

        ArrayList<IntfMedicina> am = new ArrayList<>();
        am.add(benagol);
        am.add(brufen200);
        am.add(brufen800);
        am.add(oki);
        am.add(fluifort);
        am.add(tachipirina);

        ArrayList<IntfRicetta> ar = new ArrayList<>();
        ar.add(ricettabrufen800);
        ar.add(ricettaFluifort);
        ar.add(ricettaTachi);

        // debugging
        am.forEach( e -> {
            System.out.println(e.stampa_Dati());
        });
        ar.forEach( e->{
            System.out.println(e.stampa_Dati());
        });

        MainView mv = new MainView(ar, am);

        StackPane root = new StackPane(mv);
        primaryStage.setTitle("Farmacia");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}