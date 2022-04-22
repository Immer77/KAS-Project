package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.concurrent.Callable;


public class DeltagerPane extends GridPane {
    private TextField txfNavn, txfAdresse, txfby, txfLand, txfAnkomst, txfAfrejse, txfTlfNr, txfFirmaNavn, txfFirmaTlf, txfLedsagerNavn;



    public DeltagerPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblnavn = new Label("Navn");
        this.add(lblnavn,0,0);

        Label lblAdrese = new Label("Adresse");
        this.add(lblAdrese,0,1);

        Label lblby = new Label("By");
        this.add(lblby,0,2);

        Label lblLand = new Label("Land");
        this.add(lblLand,0,3);

        Label lblAnkomst = new Label("Ankomstdato");
        this.add(lblAnkomst,0,4);

        Label lblAfrejse = new Label("Afrejsedato");
        this.add(lblAfrejse,0,5);

        Label lblForedragsHolder = new Label("Foredragsholder ja/nej");
        this.add(lblForedragsHolder,2,0);

        Label lbltlfNr = new Label("Tlf. Nr.");
        this.add(lbltlfNr,2,1);

        Label lblFirmaNavn = new Label("Firma navn");
        this.add(lblFirmaNavn,2,2);

        Label lblFirmaTlf = new Label("Firma Tlf.");
        this.add(lblFirmaTlf,2,3);

        //TODO: Indsæt tekstfield til Labels

        //TODO: Indsæt CheckBokse til foredragsholder, Ledsager, arrangement, hotel og tillæg

        //TODO: Tilføj radiobutton med VBOX Hotel


    }

    //TODO Tilføj opretTilmeldingsMetode til knappen OpretTilmelding
}
