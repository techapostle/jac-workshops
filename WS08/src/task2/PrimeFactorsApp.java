/**********************************************
 Workshop 8
 Course: JAC444 - Semester
 Last Name: Dadkhah Shokrollahi
 First Name: Kian
 ID: 119369205
 Section: NDD
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 2021-11-18
 **********************************************/

package task2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class creates a window and allows for interacting with
 * CheckPrimeFactors through a JavaFX GUI
 */
public class PrimeFactorsApp extends Application {

    @Override
    public void start(Stage ps) throws Exception {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        Label factorsLabel = new Label("");
        TextField numberTextField = new TextField();
        Button btnCalc = new Button("Calculate");

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(11.5,12.5,13.5,14.5));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);
        gridPane.add(new Label("Enter a number to calculate its prime factors."), 0, 0);
        gridPane.add(new Label("Number: "), 0, 1);
        gridPane.add(numberTextField, 1, 1);
        gridPane.add(btnCalc, 1, 3);
        GridPane.setHalignment(btnCalc, HPos.RIGHT);

        Scene scene = new Scene(gridPane);
        stage.setTitle("Prime Calculator");
        stage.setScene(scene);
        stage.show();

        /*
        ** Calculate Button event listener
         */
        btnCalc.setOnAction(e -> {
            CheckPrimeFactors primeObj = new CheckPrimeFactors(Integer.parseInt(numberTextField.getText()));
            factorsLabel.setText(primeObj.display());
            gridPane.add(factorsLabel, 0, 2);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}