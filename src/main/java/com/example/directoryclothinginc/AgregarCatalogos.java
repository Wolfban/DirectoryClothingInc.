package com.example.directoryclothinginc;

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

public class AgregarCatalogos  {


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
