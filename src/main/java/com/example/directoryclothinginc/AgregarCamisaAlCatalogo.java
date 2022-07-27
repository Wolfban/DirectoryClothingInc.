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

    /**
     * La funcion Action event lo que realiza es revisar si se efectua el click y realiza la funcion correspondiente
     * @author Esteban Barrera
     * @param event click
     */

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

    /**
     * @author Esteban Barrera
     * @param url recibe un parametro tipo URL
     * @param resourceBundle recibe un parametro tipo resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * La funcion es para cerrar la ventana y devolverse a la pagina menu
     * @author Esteban Barrera
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
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
