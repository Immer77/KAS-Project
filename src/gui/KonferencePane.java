package gui;


import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modelclass.*;

import java.util.ArrayList;


public class KonferencePane extends GridPane {
    private ListView<Konference> lvwKonference;
    private ListView<Hotel> lvwHoteller;
    private ListView<Arrangement> lvwArrangement;
    private ListView<Deltager> lvwDeltagere;


    public KonferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonference = new Label("Konferencer");
        this.add(lblKonference, 0, 0);

        lvwKonference = new ListView<>();
        this.add(lvwKonference, 0, 1, 1, 3);
        lvwKonference.setPrefHeight(200);
        lvwKonference.setPrefWidth(200);
        lvwKonference.getItems().setAll(Controller.getKonferencer());
        lvwKonference.setEditable(false);

        Label lblHotel = new Label("Hoteller");
        this.add(lblHotel, 0, 4);

        lvwHoteller = new ListView<>();
        this.add(lvwHoteller, 0, 5, 1, 3);
        lvwHoteller.setPrefWidth(200);
        lvwHoteller.setPrefHeight(200);
        lvwHoteller.getItems().setAll(Controller.gethoteller());
        lvwHoteller.setEditable(false);

        Label lblArrangement = new Label("Arrangement");
        this.add(lblArrangement, 1, 0);

        lvwArrangement = new ListView<>();
        this.add(lvwArrangement, 1, 1, 1, 3);
        lvwArrangement.setPrefHeight(100);
        lvwArrangement.setPrefWidth(300);
        lvwArrangement.getItems().setAll(Controller.getarrangementer());
        lvwArrangement.setEditable(false);

        Label lblDeltager = new Label("Deltager");
        this.add(lblDeltager, 1, 4);

        lvwDeltagere = new ListView<>();
        this.add(lvwDeltagere, 1, 5, 1, 3);
        lvwDeltagere.setPrefWidth(300);
        lvwDeltagere.setPrefHeight(200);
        lvwDeltagere.getItems().setAll(Controller.getdeltagere());
        lvwDeltagere.setEditable(false);

        HBox hBoxButtons = new HBox();
        this.add(hBoxButtons, 0, 9,2,2);
        hBoxButtons.setPadding(new Insets(1, 1,2,2));
        hBoxButtons.setSpacing(10);
        hBoxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnOpretKonference = new Button("Opret Konference");
        hBoxButtons.getChildren().add(btnOpretKonference);
        btnOpretKonference.setOnAction(event -> this.opretKonferenceAction());

        Button btnOpretArrangement = new Button("Opret Arrangement");
        hBoxButtons.getChildren().add(btnOpretArrangement);
        btnOpretArrangement.setOnAction(event -> this.opretArrangementAction());

        Button btnOpretHotel = new Button("Opret Hotel");
        hBoxButtons.getChildren().add(btnOpretHotel);
        btnOpretHotel.setOnAction(event -> this.opretHotelAction());

        Button btnTilknytHotel = new Button("Tilknyt hotel");
        hBoxButtons.getChildren().add(btnTilknytHotel);
        btnTilknytHotel.setOnAction(event -> this.tilknytHotelAction());

    }

    private void opretHotelAction() {
        HotelWindow hotelWindow = new HotelWindow("Opret hotel");
        hotelWindow.showAndWait();

        this.updateControls();
    }

    private void opretArrangementAction() {
        ArrangementWindow arrangementWindow = new ArrangementWindow("Opret arrangement");
        arrangementWindow.showAndWait();

        this.updateControls();
    }

    private void opretKonferenceAction() {
        KonferenceWindow konferenceWindow = new KonferenceWindow("Lav ny konference");
        konferenceWindow.showAndWait();

        this.updateControls();
    }

    private void tilknytHotelAction(){
        TilknytHotelWindow tilknytHotelWindow = new TilknytHotelWindow("Tilknyt hotel til konference");
        tilknytHotelWindow.showAndWait();

        this.updateControls();
    }

    public void updateControls() {
        Konference konference = lvwKonference.getSelectionModel().getSelectedItem();
        lvwKonference.getItems().setAll(Controller.getKonferencer());
        if (konference != null) {
            lvwArrangement.getItems().setAll(konference.getArrangementer());
            lvwHoteller.getItems().setAll(konference.getHoteller());
            ArrayList<Deltager> deltagers = new ArrayList<>();
            for (Tilmelding t : konference.getTilmeldinger()){
                deltagers.add(t.getDeltager());
            }
            lvwDeltagere.getItems().setAll(deltagers);

        }
    }
}