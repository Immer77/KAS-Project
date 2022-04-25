package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelclass.Hotel;
import modelclass.Konference;


public class TilknytHotelWindow extends Stage {
    private ListView<Hotel> lvwHoteller = new ListView<>();
    private ListView<Konference> lvwKonferencer = new ListView<>();

    private void initContent(GridPane pane) {
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblKonferencer = new Label("Vælg konference");

        pane.add(lblKonferencer, 0, 0);

        pane.add(lblKonferencer, 0, 0);


        lvwKonferencer.getItems().setAll(Controller.getKonferencer());
        lvwKonferencer.setEditable(false);
        lvwKonferencer.setPrefWidth(150);
        lvwKonferencer.setPrefHeight(300);

        pane.add(lvwKonferencer, 0, 1);

        Label lblHoteller = new Label("Vælg hotel");
        pane.add(lblHoteller, 2, 0);

        pane.add(lvwKonferencer, 0, 1);


        lvwHoteller.getItems().setAll(Controller.gethoteller());
        lvwHoteller.setEditable(false);
        lvwHoteller.setPrefWidth(150);
        lvwHoteller.setPrefHeight(300);
        pane.add(lvwHoteller, 2, 1, 2, 1);

        Button btnTilknytHotelToKonference = new Button("Tilknyt");
        pane.add(btnTilknytHotelToKonference, 2, 2);
        btnTilknytHotelToKonference.setOnAction(event -> tilknytAction());

        Button btnFortryd = new Button("Fortryd");
        pane.add(btnFortryd, 3, 2);
        btnFortryd.setOnAction(event -> fortrydAction());
    }
    public void tilknytAction() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();

        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        Controller.addHotelToKonference(konference, hotel);

        Button btnTilknytHotelToKonference = new Button("Tilknyt");
        btnTilknytHotelToKonference.setOnAction(event -> tilknytAction());

        Button btnFortryd = new Button("Fortryd");
        btnFortryd.setOnAction(event -> fortrydAction());
    }


    public void fortrydAction() {
        this.hide();
    }


}

