package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelWindow extends Stage {
    private TextField txfNavn, txfAdresse, txfPrisEnkelt, txfPrisDouble;

    public HotelWindow(String title) {
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

        Label lblNavn = new Label("Navn ");
        pane.add(lblNavn,0,0);

        txfNavn = new TextField();
        pane.add(txfNavn,1,0);
        txfNavn.setPrefWidth(200);

        Label lblAdresse = new Label("Adresse ");
        pane.add(lblAdresse,0,1);

        txfAdresse = new TextField();
        pane.add(txfAdresse,1,1);
        txfAdresse.setPrefWidth(200);

        Label lblPrisEnkelt = new Label("Pris en person");
        pane.add(lblPrisEnkelt,0,2);

        txfPrisEnkelt = new TextField();
        pane.add(txfPrisEnkelt,1,2);
        txfPrisEnkelt.setPrefWidth(200);

        Label lblPrisDouble = new Label("Pris to personer");
        pane.add(lblPrisDouble,0,3);

        txfPrisDouble = new TextField();
        pane.add(txfPrisDouble,1,3);
        txfPrisDouble.setPrefWidth(200);

        Button btnCreate = new Button("Opret hotel");
        btnCreate.setOnAction(event -> this.createAction());
        pane.add(btnCreate,1,4);

        Button btnCancel = new Button("Fortryd");
        btnCancel.setOnAction(event -> this.cancelAction());
        pane.add(btnCancel,2,4);

    }

    public void createAction(){
        String navn = txfNavn.getText().trim();
        String adresse = txfAdresse.getText().trim();
        double prisEnkelt = Double.parseDouble(txfPrisEnkelt.getText().trim());
        double prisDouble = Double.parseDouble(txfPrisDouble.getText().trim());
        if (navn.length() > 0 && adresse.length() > 0 && prisDouble > 0 && prisEnkelt > 0) {
            Controller.createHotel(navn, adresse, prisEnkelt, prisDouble);
            this.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Opret hotel");
            alert.setHeaderText("Alle informationer skal udfyldes");
            alert.showAndWait();
        }
    }

    public void cancelAction(){
        this.hide();
    }
}
