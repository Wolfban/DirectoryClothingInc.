package com.example.directoryclothinginc;

import Controlador.Almacenamiento;
import Modelo.Catalogos;
import Modelo.Usuarios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgregarCatalogos implements Initializable  {


    @FXML
    private Button btnAgregarCamisa;

    @FXML
    private Button btnCrear;

    @FXML
    private TableColumn colmFecha;

    @FXML
    private TableColumn colmNombre;

    @FXML
    private TableColumn columCami;

    @FXML
    private TableColumn columIDCat;

    @FXML
    private TableView<Catalogos> tblCatalogo;

    @FXML
    private TextField txtFechaCreacion;

    @FXML
    private TextField txtNombre;

    ObservableList<Catalogos> catalogos = FXCollections.observableArrayList();

    /**
     * Las funcion al hacer click se envia al AgregarCamisaAlCatalogo.fxml
     * @author Esteban Barrera
     * @param event Click
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    @FXML
    void click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarCamisaAlCatalogo.fxml"));
        Parent root = loader.load();
        AgregarCamisaAlCatalogo controlador = loader.getController();
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


        Stage myStage = (Stage) this.btnAgregarCamisa.getScene().getWindow();
        myStage.close();
    }

    /**
     * La funcion click lee los datos ingresados  y agrega un Id random
     * @author Esteban Barrera
     * @param event Click
     */
    @FXML
    private void Click(ActionEvent event) {
        try {
            String nombre = this.txtNombre.getText();
            String fecha  = this.txtFechaCreacion.getText();
            int ID  = (int) (Math.random()*(999999999-100000000+1)+100000000);

            boolean error = Almacenamiento.agregarCatalogo(nombre,fecha,ID);
            if (error == false) {
                for (Catalogos catalogosMostrar : Almacenamiento.poolcatalogos) {
                    this.catalogos.add(catalogosMostrar);
                    tblCatalogo.getItems().clear();
                    CargarDatos();
                }

            } else {
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
     * La funcion inicializa el CargarDatos();
     * @author Esteban Barrera
     * @param url Recibe URL
     * @param resourceBundle recibe resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CargarDatos();
    }
    /**
     * La funcion CargarDatos(); agrega los datos leidos y los ingresa a la tabla
     * @author Esteban Barrera
     */
    public void CargarDatos(){
        catalogos.addAll(Almacenamiento.poolcatalogos);
        colmFecha.setCellValueFactory(new PropertyValueFactory("fechaCreacion"));
        colmNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columCami.setCellValueFactory(new PropertyValueFactory("camisas"));
        columIDCat.setCellValueFactory(new PropertyValueFactory("ID"));
        tblCatalogo.setItems(catalogos);
    }
    /**
     * La funcion closeWindows(); al cerrar la aplicacion se devuelve al menu
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
