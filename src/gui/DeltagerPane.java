package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelclass.Arrangement;
import modelclass.Hotel;
import modelclass.Tillæg;

import java.util.ArrayList;
import java.util.concurrent.Callable;


public class DeltagerPane extends GridPane {
    private TextField txfNavn, txfAdresse, txfby, txfLand, txfAnkomst, txfAfrejse, txfTlfNr, txfFirmaNavn, txfFirmaTlf, txfLedsagerNavn;
    private final ToggleGroup group = new ToggleGroup();


    public DeltagerPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblnavn = new Label("Navn");
        this.add(lblnavn,0,0);
        txfNavn = new TextField();
        this.add(txfNavn,1,0);

        Label lblAdrese = new Label("Adresse");
        this.add(lblAdrese,0,1);
        txfAdresse = new TextField();
        this.add(txfAdresse,1,1);

        Label lblby = new Label("By");
        this.add(lblby,0,2);
        txfby = new TextField();
        this.add(txfby,1,2);

        Label lblLand = new Label("Land");
        this.add(lblLand,0,3);
        txfLand = new TextField();
        this.add(txfLand,1,3);

        Label lblAnkomst = new Label("Ankomstdato");
        this.add(lblAnkomst,0,4);
        txfAnkomst = new TextField();
        this.add(txfAnkomst,1,4);

        Label lblAfrejse = new Label("Afrejsedato");
        this.add(lblAfrejse,0,5);
        txfAfrejse = new TextField();
        this.add(txfAfrejse,1,5);

        Label lblForedragsHolder = new Label("Foredragsholder ja/nej");
        this.add(lblForedragsHolder,2,0);
        CheckBox chBoxForedragsHolder = new CheckBox();
        this.add(chBoxForedragsHolder,3,0);

        Label lbltlfNr = new Label("Tlf. Nr.");
        this.add(lbltlfNr,2,1);
        txfTlfNr = new TextField();
        this.add(txfTlfNr,3,1);

        Label lblFirmaNavn = new Label("Firma navn");
        this.add(lblFirmaNavn,2,2);
        txfFirmaNavn = new TextField();
        this.add(txfFirmaNavn,3,2);


        Label lblFirmaTlf = new Label("Firma Tlf.");
        this.add(lblFirmaTlf,2,3);
        txfFirmaTlf = new TextField();
        this.add(txfFirmaTlf,3,3);

        Label lblledsager = new Label("Ledsager");
        this.add(lblledsager,1,6);
        CheckBox chBoxLedsager = new CheckBox();
        this.add(chBoxLedsager,2,6);

        Label lblLedsagerNavn = new Label("Ledsager Navn: ");
        this.add(lblLedsagerNavn,1,7);
        txfLedsagerNavn = new TextField();
        this.add(txfLedsagerNavn,2,7);

        VBox vBoxArrangement = new VBox();
        this.add(vBoxArrangement,0,8);

        Label lblHotel = new Label("Hoteller: ");
        this.add(lblHotel,0,9);
        CheckBox chBoxHotel = new CheckBox();
        this.add(chBoxHotel,1,9);

        VBox vBoxHoteller = new VBox();
        this.add(vBoxHoteller,0,10);

        VBox vBoxTillæg = new VBox();
        this.add(vBoxTillæg,2,10);

        for (Arrangement a : Controller.getarrangementer()){
            RadioButton rb = new RadioButton();
            vBoxArrangement.getChildren().add(rb);
            rb.setText(a.getTitel() + " " + a.getDato());
        }

        for(Hotel h : Controller.gethoteller()){
            RadioButton rb1 = new RadioButton();
            vBoxHoteller.getChildren().add(rb1);
            rb1.setText(h.getNavn() + " " + h.getPrisEnkeltVærelse() + "/" + h.getPrisDoubleVærelse());
            rb1.setToggleGroup(group);
            for (Tillæg t : h.getTillæg()){
                RadioButton rb2 = new RadioButton();
                vBoxTillæg.getChildren().add(rb2);
                rb2.setText(t.getNavn() + " " + t.getPris());
            }
        }




        //TODO: Indsæt CheckBokse til foredragsholder, Ledsager, arrangement, hotel og tillæg

        //TODO: Tilføj radiobutton med VBOX Hotel


    }

    //TODO Tilføj opretTilmeldingsMetode til knappen OpretTilmelding
}
