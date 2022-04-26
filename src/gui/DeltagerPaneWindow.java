package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelclass.Deltager;
import modelclass.Tilmelding;


public class DeltagerPaneWindow extends Stage {
    private TextField txfSamletPris;

    public DeltagerPaneWindow(String title, Tilmelding tilmelding){
        this.initStyle(StageStyle.DECORATED);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane,tilmelding);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane,Tilmelding tilmelding) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblSamletPris = new Label("Samlet pris");
        pane.add(lblSamletPris,0,0);

        txfSamletPris = new TextField();
        pane.add(txfSamletPris,1,0);
        txfSamletPris.setText(String.valueOf(Controller.beregnSamledeTilmeldingsPris(tilmelding)));
        txfSamletPris.setEditable(false);


        Button btnOkay = new Button("I agree");
        pane.add(btnOkay,1,1);
        btnOkay.setOnAction(event -> this.close());
    }
}
