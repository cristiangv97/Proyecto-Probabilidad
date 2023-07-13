package com.ipn.mx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BayesController {
    @FXML
    TextField field_A;
    @FXML
    TextField field_B;
    @FXML
    TextField field_AgivenB;
    @FXML
    TextField field_BgivenA;
    public void ponerEnMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void resolverBayes(){
        if (validarEntradas()) {
            Extras.alertar("Campos incompletos", "Solo uno de los campos puede estar vacio");
            return;
        }
        imprimirResultado();
    }

    public void imprimirResultado(){
        int caso = "".equals(field_A.getText()) ? 1 : 0;
        caso += "".equals(field_B.getText()) ? 2 : 0;
        caso += "".equals(field_AgivenB.getText()) ? 3 : 0;
        caso += "".equals(field_BgivenA.getText()) ? 4 : 0;
//        System.out.println(caso);
        try {
            double resultado, p_X, p_Y, p_GivenOne, p_GivenTwo;
            switch (caso){
                case 1:
                    p_Y = Double.parseDouble(field_B.getText());
                    p_GivenOne = Double.parseDouble(field_AgivenB.getText());
                    p_GivenTwo = Double.parseDouble(field_BgivenA.getText());
                    resultado = Extras.round(p_GivenOne * p_Y / p_GivenTwo, 2);
                    field_A.setText(String.valueOf(resultado));
                    break;
                case 2:
                    p_GivenTwo = Double.parseDouble(field_BgivenA.getText());
                    p_X = Double.parseDouble(field_A.getText());
                    p_GivenOne = Double.parseDouble(field_AgivenB.getText());
                    resultado = Extras.round(p_GivenTwo * p_X / p_GivenOne, 2);
                    field_B.setText(String.valueOf(resultado));
                    break;
                case 3:
                    p_GivenTwo = Double.parseDouble(field_BgivenA.getText());
                    p_X = Double.parseDouble(field_A.getText());
                    p_Y = Double.parseDouble(field_B.getText());
                    resultado = Extras.round(p_GivenTwo * p_X / p_Y, 2);
                    field_AgivenB.setText(String.valueOf(resultado));
                    break;
                case 4:
                    p_GivenOne = Double.parseDouble(field_AgivenB.getText());
                    p_Y = Double.parseDouble(field_B.getText());
                    p_X = Double.parseDouble(field_A.getText());
                    resultado = Extras.round(p_GivenOne * p_Y / p_X, 2);
                    field_BgivenA.setText(String.valueOf(resultado));
            }
        }catch (NumberFormatException error){
            Extras.alertar("Tipo de dato incorrecto", "Alguno de los campos tiene un tipo de dato incorrecto");
        }

    }

    public boolean validarEntradas(){
        int situación = "".equals(field_A.getText()) ? 1 : 0;
        situación += "".equals(field_B.getText()) ? 1 : 0;
        situación += "".equals(field_AgivenB.getText()) ? 1 : 0;
        situación += "".equals(field_BgivenA.getText()) ? 1 : 0;
        return situación != 1;
    }
}
