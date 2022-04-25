package gui;


import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modelclass.Arrangement;
import modelclass.Deltager;
import modelclass.Hotel;
import modelclass.Konference;


public class KonferencePane extends GridPane {
    private ListView<Konference> lvwKonference;
    private ListView<Hotel> lvwHoteller;
    private ListView<Arrangement> lvwArrangement;
    private ListView<Deltager> lvwDeltagere;



    public KonferencePane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonference = new Label("Konferencer");
        this.add(lblKonference,0,0);

        lvwKonference = new ListView<>();
        this.add(lvwKonference,0,1,1,3);
        lvwKonference.setPrefHeight(100);
        lvwKonference.setPrefWidth(200);
        lvwKonference.getItems().setAll(Controller.getKonferencer());

        Label lblHotel = new Label("Hoteller");
        this.add(lblHotel,0,4);

        lvwHoteller = new ListView<>();
        this.add(lvwHoteller,0,5,1,3);
        lvwHoteller.setPrefWidth(200);
        lvwHoteller.setPrefHeight(100);
        lvwHoteller.getItems().setAll(Controller.gethoteller());

        Label lblArrangement = new Label("Arrangement");
        this.add(lblArrangement,2,0);

        lvwArrangement = new ListView<>();
        this.add(lvwArrangement,2,1,1,3);
        lvwArrangement.setPrefHeight(100);
        lvwArrangement.setPrefWidth(200);
        lvwArrangement.getItems().setAll(Controller.getarrangementer());

        Label lblDeltager = new Label("Deltager");
        this.add(lblDeltager,2,4);

        lvwDeltagere = new ListView<>();
        this.add(lvwDeltagere,2,5,1,3);
        lvwDeltagere.setPrefWidth(200);
        lvwDeltagere.setPrefHeight(100);
        lvwDeltagere.getItems().setAll(Controller.getdeltagere());

        HBox hBoxButtons = new HBox();
        this.add(hBoxButtons,1,9);
        hBoxButtons.setPadding(new Insets(10,0,0,0));
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

    }

    private void opretHotelAction() {
        //TODO
    }

    private void opretArrangementAction() {
        //TODO
    }

    private void opretKonferenceAction() {
        //TODO
    }

    public void updateControls(){
        //TODO
    }
}
