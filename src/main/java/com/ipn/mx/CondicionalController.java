package com.ipn.mx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CondicionalController {
    @FXML
    TextField field_A;
    @FXML
    TextField field_AandB;
    @FXML
    TextField field_BgivenA;
    public void ponerEnMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void resolverCondicional(){
        if (validarEntradas()) {
            Extras.alertar("Campos incompletos", "Solo uno de los campos puede estar vacio");
            return;
        }
        imprimirResultado();
    }

    public void imprimirResultado(){
        int caso = "".equals(field_A.getText()) ? 1 : 0;
        caso += "".equals(field_AandB.getText()) ? 2 : 0;
        caso += "".equals(field_BgivenA.getText()) ? 3 : 0;
//        System.out.println(caso);
        try {
            double resultado, p_X, p_And, p_Given;
            switch (caso){
                case 1:
                    p_And = Double.parseDouble(field_AandB.getText());
                    p_Given = Double.parseDouble(field_BgivenA.getText());
                    resultado = Extras.round(p_And / p_Given, 2);
                    field_A.setText(String.valueOf(resultado));
                    break;
                case 2:
                    p_X = Double.parseDouble(field_A.getText());
                    p_Given = Double.parseDouble(field_BgivenA.getText());
                    resultado = Extras.round(p_X * p_Given, 2);
                    field_AandB.setText(String.valueOf(resultado));
                    break;
                case 3:
                    p_X = Double.parseDouble(field_A.getText());
                    p_And = Double.parseDouble(field_AandB.getText());
                    resultado = Extras.round(p_And / p_X, 2);
                    field_BgivenA.setText(String.valueOf(resultado));
                    break;
            }
        }catch (NumberFormatException error){
            Extras.alertar("Tipo de dato incorrecto", "Alguno de los campos tiene un tipo de dato incorrecto");
        }

    }

    public boolean validarEntradas(){
        int situación = "".equals(field_A.getText()) ? 1 : 0;
        situación += "".equals(field_AandB.getText()) ? 1 : 0;
        situación += "".equals(field_BgivenA.getText()) ? 1 : 0;
        return situación != 1;
    }

}
