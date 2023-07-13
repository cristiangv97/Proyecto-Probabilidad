package com.ipn.mx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EscenasController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    public void ponerEnCondicional(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("condicional.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Probabilidad condicional");
        stage.setScene(scene);
        stage.show();

    }

    public void ponerEnIndependiente(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("independiente.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Probabilidad independiente");
        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(600);
        stage.setResizable(true);
        stage.show();
    }

    public void ponerEnBayes(ActionEvent event) throws IOException {
//        System.out.println("Bayes");
        fxmlLoader = new FXMLLoader(getClass().getResource("bayes.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }
}
