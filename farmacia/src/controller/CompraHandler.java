package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.exceptions.*;
import model.cosechescadono.medicine.IntfMedicina;
import view.MainView;

public class CompraHandler implements EventHandler {

    private IntfMedicina m;
    private MainView mv;

    public CompraHandler(IntfMedicina mp, MainView mv){
        this.m = mp;
        this.mv = mv;
    }

    @Override
    public void handle(Event event) {

        try {
            this.m.select(this.mv.getRicette(), this.mv.getcurrentmoney());

            this.mv.paga(this.m.get_Prezzo_Scontato());
//        } catch (Exception ex) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setContentText(ex.toString());
//            alert.showAndWait();
        }
        catch (NoRicettaException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Ricetta mancante nella lista");
            alert.showAndWait();
        } catch (RicettaScadutaException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Ricetta scaduta");
            alert.showAndWait();
        } catch (RicettaNonSelezionataException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Ricetta non selezionata");
            alert.showAndWait();
        } catch (NotEnoughMoneyException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Soldi insufficienti");
            alert.showAndWait();
        } catch (MedicinaScadutaException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Medicina scaduta");
            alert.showAndWait();
        } catch (RicettaUsataTroppeVolteException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Ricetta usata troppe volte");
            alert.showAndWait();
        }
    }
}
