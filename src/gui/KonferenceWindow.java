package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;



public class KonferenceWindow extends Stage {
    private TextField txfNavn, txfLokation, txfFraDato, txfTilDato, txfAfgiftPrDag;

    public KonferenceWindow(String title){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane =new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblNavn = new Label("Navn på konference ");
        pane.add(lblNavn,0,0,1,1);

        txfNavn = new TextField();
        pane.add(txfNavn,2,0);
        txfNavn.setPrefWidth(200);

        Label lblLokation = new Label("Lokation ");
        pane.add(lblLokation,0,1,1,1);

        txfLokation = new TextField();
        pane.add(txfLokation,2,1);
        txfLokation.setPrefWidth(200);

        Label lblFraDato = new Label("Fra dato (yyyy-mm-dd)");
        pane.add(lblFraDato,0,2,1,1);

        txfFraDato = new TextField();
        pane.add(txfFraDato,2,2);
        txfFraDato.setPrefWidth(200);

        Label lblTilDato = new Label("Til dato (yyyy-mm-dd)");
        pane.add(lblTilDato,0,3,1,1);

        txfTilDato = new TextField();
        pane.add(txfTilDato,2,3);
        txfTilDato.setPrefWidth(200);

        Label lblAfgiftPrDag = new Label("Afgift per dag ");
        pane.add(lblAfgiftPrDag,0,4,1,1);

        txfAfgiftPrDag = new TextField();
        pane.add(txfAfgiftPrDag,2,4);
        txfAfgiftPrDag.setPrefWidth(200);

        HBox hbxButtons = new HBox(20);
        pane.add(hbxButtons,2,7,1,1);
        hbxButtons.setPadding(new Insets(10,0,0,0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Lav Konference");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        Button btnCancel = new Button("Fortryd");
        hbxButtons.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());
    }


    private void cancelAction(){
        this.hide();
    }

    private void createAction(){
        String navn = txfNavn.getText().trim();
        String lokation = txfLokation.getText().trim();
        LocalDate fraDato = LocalDate.parse(txfFraDato.getText());
        LocalDate tilDato = LocalDate.parse(txfTilDato.getText());
        int afgiftPrDag = Integer.parseInt(txfAfgiftPrDag.getText().trim());

        if (navn.length() > 0 && lokation.length() > 0 && afgiftPrDag > 0){
            Controller.createKonference(navn,lokation,fraDato,tilDato,afgiftPrDag);
            this.hide();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lav ny konferenec");
            alert.setHeaderText("Alle felter skal udfyldes med gyldig information!");
            alert.showAndWait();
        }
    }
}
