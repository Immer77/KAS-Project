package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelclass.Konference;

import java.time.LocalDate;

public class ArrangementWindow extends Stage {
    private TextField txftitel, txfDato, txfPris;
    private ListView<Konference> lvwKonferencer = new ListView<>();

    public ArrangementWindow(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblTitel = new Label("Titel");
        pane.add(lblTitel,0,0);

        txftitel = new TextField();
        pane.add(txftitel,1,0,2,1);
        txftitel.setPrefWidth(200);

        Label lblDato = new Label("Dato (yyyy-mm-dd)");
        pane.add(lblDato,0,1);

        txfDato = new TextField();
        pane.add(txfDato,1,1,2,1);
        txfDato.setPrefWidth(200);

        Label lblPris = new Label("Pris");
        pane.add(lblPris,0,2);

        txfPris = new TextField();
        pane.add(txfPris,1,2,2,1);
        txfPris.setPrefWidth(200);

        Label lblKonference = new Label("Vælg konference");
        pane.add(lblKonference,0,3);


        lvwKonferencer.setEditable(false);
        lvwKonferencer.setPrefHeight(150);
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());
        pane.add(lvwKonferencer,1,3,2,1);

        Button btnCreate = new Button("Opret");
        pane.add(btnCreate,1,5);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnCancel = new Button("Fortryd");
        pane.add(btnCancel,2,5);
        btnCancel.setOnAction(event -> this.cancelAction());
    }

    public void cancelAction(){
        this.hide();
    }

    public void createAction(){
        String titel = txftitel.getText().trim();
        LocalDate dato = LocalDate.parse(txfDato.getText());
        double pris = Double.parseDouble(txfPris.getText());
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (titel.length() > 0 && dato.isAfter(LocalDate.now())) {
            Controller.createArrangement(titel, pris, dato, konference);
            this.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Opret arrangement");
            alert.setHeaderText("Alle informationer skal være gylidge!");
            alert.showAndWait();
        }

    }
}
