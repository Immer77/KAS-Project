package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelclass.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.Callable;


public class DeltagerPane extends GridPane {
    private final TextField txfNavn, txfAdresse, txfby, txfLand, txfAnkomst, txfAfrejse, txfTlfNr, txfFirmaNavn, txfFirmaTlf, txfLedsagerNavn;
    private final ToggleGroup group = new ToggleGroup();
    private final CheckBox chBoxForedragsHolder = new CheckBox();
    private final CheckBox chBoxLedsager = new CheckBox();
    private final CheckBox chBoxHotel = new CheckBox();
    private final ListView<Hotel> lvwHotel;
    private final ListView<Konference> lvwKonferencer;
    private final ListView<Tillæg> lvwTillæg;
    private final ListView<Arrangement> lvwArrangement;
    private KonferencePane konferencePane = new KonferencePane();


    public DeltagerPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonferencer = new Label("Konferencer ");
        this.add(lblKonferencer,0,0);

        lvwKonferencer = new ListView<>();
        this.add(lvwKonferencer, 0,1,1,1);
        lvwKonferencer.setPrefHeight(40);
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());
        lvwKonferencer.setOnMouseClicked(event -> this.konferenceActionUpdate());


        Label lblnavn = new Label("Navn");
        this.add(lblnavn,0,2);
        txfNavn = new TextField();
        this.add(txfNavn,1,2);

        Label lblAdrese = new Label("Adresse");
        this.add(lblAdrese,0,3);
        txfAdresse = new TextField();
        this.add(txfAdresse,1,3);

        Label lblby = new Label("By");
        this.add(lblby,0,4);
        txfby = new TextField();
        this.add(txfby,1,4);

        Label lblLand = new Label("Land");
        this.add(lblLand,0,5);
        txfLand = new TextField();
        this.add(txfLand,1,5);

        Label lblAnkomst = new Label("Ankomstdato");
        this.add(lblAnkomst,0,6);
        txfAnkomst = new TextField();
        this.add(txfAnkomst,1,6);

        Label lblAfrejse = new Label("Afrejsedato");
        this.add(lblAfrejse,0,7);
        txfAfrejse = new TextField();
        this.add(txfAfrejse,1,7);

        Label lblForedragsHolder = new Label("Foredragsholder ja/nej");
        this.add(lblForedragsHolder,2,2);
        this.add(chBoxForedragsHolder,3,2);

        Label lbltlfNr = new Label("Tlf. Nr.");
        this.add(lbltlfNr,2,3);
        txfTlfNr = new TextField();
        this.add(txfTlfNr,3,3);

        Label lblFirmaNavn = new Label("Firma navn");
        this.add(lblFirmaNavn,2,4);
        txfFirmaNavn = new TextField();
        this.add(txfFirmaNavn,3,4);


        Label lblFirmaTlf = new Label("Firma Tlf.");
        this.add(lblFirmaTlf,2,5);
        txfFirmaTlf = new TextField();
        this.add(txfFirmaTlf,3,5);

        Label lblledsager = new Label("Ledsager");
        this.add(lblledsager,0,8);
        this.add(chBoxLedsager,1,8);
        chBoxLedsager.setOnAction(event -> this.updateControls());

        Label lblLedsagerNavn = new Label("Ledsager Navn: ");
        this.add(lblLedsagerNavn,0,9);
        txfLedsagerNavn = new TextField();
        this.add(txfLedsagerNavn,1,9);
        txfLedsagerNavn.setDisable(true);



        Label lblHotel = new Label("Hoteller: ");
        this.add(lblHotel,0,11);
        this.add(chBoxHotel,1,11);
        chBoxHotel.setOnAction(event -> this.updateControls());

        lvwArrangement = new ListView<>();
        this.add(lvwArrangement,0,10);
        lvwArrangement.setPrefWidth(200);
        lvwArrangement.setPrefHeight(100);
//        lvwArrangement.getItems().setAll(Controller.getarrangementer());
        lvwArrangement.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwArrangement.setDisable(true);

        lvwHotel = new ListView<>();
        this.add(lvwHotel,0,12);
        lvwHotel.setPrefHeight(100);
        lvwHotel.setPrefWidth(200);
        //
        ChangeListener<Hotel> hotelChangeListener = (oh, oldHotel, newHotel) -> this.hotelSelectionChanged();
        lvwHotel.getSelectionModel().selectedItemProperty().addListener(hotelChangeListener);
        lvwHotel.setDisable(true);

        lvwTillæg = new ListView<>();
        this.add(lvwTillæg,1,12);
        lvwTillæg.setPrefHeight(100);
        lvwTillæg.setPrefWidth(200);
        lvwTillæg.setDisable(true);




        Button btnOpretTilmelding = new Button("Opret Tilmelding");
        this.add(btnOpretTilmelding,2,13);
        btnOpretTilmelding.setOnAction(event -> this.opretTilmeldingAction());




        //TODO: Indsæt CheckBokse til foredragsholder, Ledsager, arrangement, hotel og tillæg

    }

    private void konferenceActionUpdate() {
        lvwHotel.getItems().setAll(Controller.gethoteller());
        lvwArrangement.getItems().setAll(Controller.getarrangementer());

    }

    private void hotelSelectionChanged() {
        Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
        if(hotel != null){
            lvwTillæg.getItems().setAll(Controller.getTillæg(hotel));
        }

    }

    public void opretTilmeldingAction() {
        Deltager d1 = Controller.createDeltager(txfNavn.getText(),txfAdresse.getText(), Integer.parseInt(txfTlfNr.getText()), chBoxForedragsHolder.isSelected(), txfFirmaNavn.getText(), Integer.parseInt(txfFirmaTlf.getText()));
        System.out.println(Controller.getdeltagere());
        if(chBoxLedsager.isSelected()){
            Ledsager l1 = Controller.createLedsager(txfLedsagerNavn.getText(), d1);
            Controller.addArrangementToLedsager(lvwArrangement.getSelectionModel().getSelectedItem(),l1);
        }
        if(lvwKonferencer.getSelectionModel().getSelectedItem() != null){
            if(chBoxHotel.isSelected()){
                Controller.createTilmelding(txfLand.getText(),txfby.getText(), LocalDate.parse(txfAnkomst.getText()),LocalDate.parse(txfAfrejse.getText()), d1, lvwHotel.getSelectionModel().getSelectedItem(), lvwKonferencer.getSelectionModel().getSelectedItem());
                System.out.println(Controller.getdeltagere());
                clearTextFields();
            }else{
                Controller.createTilmelding(txfLand.getText(),txfby.getText(), LocalDate.parse(txfAnkomst.getText()),LocalDate.parse(txfAfrejse.getText()), d1, null, lvwKonferencer.getSelectionModel().getSelectedItem());
                System.out.println(Controller.getdeltagere());
                clearTextFields();

            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Input");
            alert.setHeaderText("Vælg venligst konference");
            alert.show();
        }

    }

    private void clearTextFields(){
        txfby.clear();
        txfFirmaTlf.clear();
        txfLedsagerNavn.clear();
        txfFirmaNavn.clear();
        txfAfrejse.clear();
        txfTlfNr.clear();
        txfLedsagerNavn.clear();
        txfAnkomst.clear();
        txfLand.clear();
        txfNavn.clear();
        txfAdresse.clear();
    }

    private void updateControls(){
        if(chBoxLedsager.isSelected()){
           lvwArrangement.setDisable(false);
           txfLedsagerNavn.setDisable(false);
        }else{
            lvwArrangement.setDisable(true);
            txfLedsagerNavn.setDisable(true);
        }

        if(chBoxHotel.isSelected()){
            lvwHotel.setDisable(false);
            lvwTillæg.setDisable(false);
        }else{
            lvwHotel.setDisable(true);
            lvwTillæg.setDisable(true);
        }
    }
    public void updateTab(){
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());
    }

    //TODO Tilføj opretTilmeldingsMetode til knappen OpretTilmelding
}
