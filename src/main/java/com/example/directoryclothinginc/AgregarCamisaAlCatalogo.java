package com.example.directoryclothinginc;

import Controlador.Almacenamiento;
import Modelo.Catalogos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgregarCamisaAlCatalogo implements  Initializable {

    @FXML
    private Button btnAgregar;

    @FXML
    private TextField txtIDCami;

    @FXML
    private TextField txtIDCat;

    @FXML
    void click(ActionEvent event) {
        try {
            int IdCami = Integer.parseInt(this.txtIDCami.getText());
            int IdCat  = Integer.parseInt(this.txtIDCat.getText());
            boolean error = Almacenamiento.agregarCamisetaCatalogo(IdCami, IdCat);
            if (error == true) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato Incorrecto");
                alert.showAndWait();
            }


        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato Incorrecto");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void closeWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));

        Parent root = loader.load();
        Object controlador = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();


    }
}
