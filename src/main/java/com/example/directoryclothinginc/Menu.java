package com.example.directoryclothinginc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Menu implements Initializable {
    /**
     * @author Esteban Barrera
     * @param url recibe un parametro URL
     * @param resourceBundle recibe un parametro resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button btnCAMISETA;

    @FXML
    private Button btnCatalogo;

    @FXML
    private Button btnClientes;

    /**
     * Al hacer Click se dirige al fxml de AgregarCamisa
     * @author Esteban Barrera
     * @param event recibe el Click como evento
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */

    @FXML
    void CLICK(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarCamisa.fxml"));


        Parent root = loader.load();


        AgregarCamisas controlador = loader.getController();


        Scene scene1 = new Scene(root);
        Stage stage = new Stage();


        stage.setScene(scene1);
        stage.show();


        stage.setOnCloseRequest(e -> {
            try {
                controlador.closeWindows();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        Stage myStage = (Stage) this.btnCAMISETA.getScene().getWindow();
        myStage.close();
    }

    /**
     * Al hacer Click se dirige al fxml de AgregarCliente
     * @author Esteban Barrera
     * @param event Recibe Click como evento
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    @FXML
    void Click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarCliente.fxml"));


        Parent root = loader.load();


        AgregarClientes controlador = loader.getController();


        Scene scene1 = new Scene(root);
        Stage stage = new Stage();


        stage.setScene(scene1);
        stage.show();


        stage.setOnCloseRequest(e -> {
            try {
                controlador.closeWindows();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        Stage myStage = (Stage) this.btnClientes.getScene().getWindow();
        myStage.close();
    }

    /**
     * Al hacer Click se dirige al fxml de AgregarCatalogo
     * @author Esteban Barrera
     * @param event Recibe click como evento
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    @FXML
    void click (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarCatalogos.fxml"));


        Parent root = loader.load();


        AgregarCatalogos controlador = loader.getController();


        Scene scene1 = new Scene(root);
        Stage stage = new Stage();


        stage.setScene(scene1);
        stage.show();


        stage.setOnCloseRequest(e -> {
            try {
                controlador.closeWindows();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        Stage myStage = (Stage) this.btnCatalogo.getScene().getWindow();
        myStage.close();
    }



}
