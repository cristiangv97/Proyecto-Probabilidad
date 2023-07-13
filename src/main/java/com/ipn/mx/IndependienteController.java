package com.ipn.mx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class IndependienteController {
    @FXML
    private TextField field_A;
    @FXML
    private TitledPane tp_APrima;
    @FXML
    private TextField field_B;
    @FXML
    private TitledPane tp_BPrima;
    @FXML
    private TitledPane tp_AandB;
    @FXML
    private TextArea area_AandB;
    @FXML
    private TitledPane tp_AorB;
    @FXML
    private TextArea area_AorB;
    @FXML
    private TextArea area_APrima;
    @FXML
    private TextArea area_BPrima;
    @FXML
    private TextArea area_AxorB;
    @FXML
    private TitledPane tp_AxorB;

    double doble_A;
    double doble_B;
    double AandB;
    double AorB;


    public void ponerEnMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void resolverIndependiente(ActionEvent event){
        try {
            doble_A = Double.parseDouble(field_A.getText());
            doble_B = Double.parseDouble(field_B.getText());
            AandB = Extras.round(doble_A * doble_B, 2);
            AorB = Extras.round(doble_A + doble_B - AandB, 2);
            if (doble_A >= 0 && doble_A <= 1 && doble_B >= 0 && doble_B <= 1){
                imprimirCompA();
                imprimirCompB();
                imprimirAND();
                imprimirOR();
                imprimirXOR();
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Valor fuera de rango");
                alert.setContentText("El valor se tiene que encontrar entre 0 y 1");
                alert.showAndWait();
            }
        }catch (NumberFormatException e){
            System.out.println("Handling error");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tipo de dato incorrecto");
            alert.setContentText("El tipo de dato ingresado en alguno de los campos es incorrecto");
            alert.showAndWait();
        }



    }

    private void imprimirCompA() {
        double complementoA = Extras.round(1 - doble_A, 2);
        tp_APrima.setText("P(A') = " + complementoA);
        area_APrima.setText(String.format("%10s = 1 - P(A)\n", "P(A')"));
        area_APrima.appendText(String.format("%15s = 1 - " + doble_A + "\n", ""));
        area_APrima.appendText(String.format("%15s = " + complementoA, ""));

    }

    private void imprimirCompB() {
        double complementoB = Extras.round(1 - doble_B, 2);
        tp_BPrima.setText("P(B') = " + complementoB);
        area_BPrima.setText(String.format("%10s = 1 - P(B)\n", "P(B')"));
        area_BPrima.appendText(String.format("%15s = 1 - " + doble_B + "\n", ""));
        area_BPrima.appendText(String.format("%15s = " + complementoB, ""));
    }

    private void imprimirAND() {
        tp_AandB.setText("P(A∩B) = " + AandB);
        area_AandB.setText(String.format("%6s = P(A) * P(B)\n", "P(A∩B)"));
        area_AandB.appendText(String.format("%15s = " + doble_A + " * " + doble_B + "\n", ""));
        area_AandB.appendText(String.format("%15s = " + AandB, ""));
    }

    private void imprimirOR() {
        tp_AorB.setText("P(A∪B) = " + AorB);
        area_AorB.setText(String.format("%6s = P(A) + P(B) - P(A∩B)\n", "P(A∪B)"));
        area_AorB.appendText(String.format("%15s = " + doble_A + " + " + doble_B + " - " + AorB + "\n", ""));
        area_AorB.appendText(String.format("%15s = " + AorB, ""));

    }

    public void imprimirXOR(){
        double AxorB = Extras.round(doble_A + doble_B - 2 * AandB, 2);
        tp_AxorB.setText("P(AΔB) = " + AxorB);
        area_AxorB.setText(String.format("%6s = P(A) + P(B) - 2P(A∩B)\n", "P(AΔB)"));
        area_AxorB.appendText(String.format("%15s = " + doble_A + " + " + doble_B + " - 2 * " + AandB + "\n", ""));
        area_AxorB.appendText(String.format("%15s = " + AxorB, ""));
    }

}
