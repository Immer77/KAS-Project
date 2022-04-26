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
import modelclass.Deltager;
import modelclass.Hotel;
import modelclass.Tilmelding;

import java.util.ArrayList;

public class HotelgæstWindow extends Stage {
    private ListView<Tilmelding> lvwHotelgæster;

    public HotelgæstWindow(String title, Hotel hotel) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane,hotel);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane, Hotel hotel) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblLedsagere = new Label("Gæster og ledsagere på hotellet");
        pane.add(lblLedsagere,0,0);

        lvwHotelgæster = new ListView<>();
        pane.add(lvwHotelgæster,0,1);
        lvwHotelgæster.setEditable(false);
        lvwHotelgæster.setPrefHeight(300);
        lvwHotelgæster.setPrefWidth(300);

        Button btnOkay = new Button("Okay");
        pane.add(btnOkay,0,2);
        btnOkay.setOnAction(event -> this.okayAction());

        lvwHotelgæster.getItems().setAll(hotel.getTilmeldinger());
    }

    private void okayAction() {
        this.close();
    }


}