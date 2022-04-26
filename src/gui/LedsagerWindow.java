package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelclass.Arrangement;
import modelclass.Ledsager;
import modelclass.Tilmelding;

import java.util.ArrayList;

public class LedsagerWindow extends Stage {
    private ListView<Ledsager> lvwLedsagere;

    public LedsagerWindow(String title, Arrangement arrangement) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane,arrangement);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane, Arrangement arrangement) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblLedsagere = new Label("Ledsagere til arrangement");
        pane.add(lblLedsagere,0,0);

        lvwLedsagere = new ListView<>();
        pane.add(lvwLedsagere,0,1);
        lvwLedsagere.setEditable(false);
        lvwLedsagere.setPrefHeight(300);
        lvwLedsagere.setPrefWidth(300);

        Button btnOkay = new Button("Okay");
        pane.add(btnOkay,0,2);
        btnOkay.setOnAction(event -> this.okayAction());

        lvwLedsagere.getItems().setAll(arrangement.getLedsagere());
    }

    private void okayAction() {
        this.close();
    }


}
