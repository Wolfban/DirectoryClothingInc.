package com.example.directoryclothinginc;

import Modelo.Usuarios;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgregarClientes  {

    @FXML
    private TableColumn ColmApellido1;

    @FXML
    private TableColumn ColmApellido2;

    @FXML
    private TableColumn ColmDireccion;

    @FXML
    private TableColumn ColmEmail;

    @FXML
    private TableColumn ColmNombre;

    @FXML
    private Button btnAgregar;

    @FXML
    private TableColumn colmID;

    @FXML
    private TableView<Usuarios> tblUsusarios;

    @FXML
    private TextField txtApellido1;

    @FXML
    private TextField txtApellido2;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNombre;

    ObservableList<Usuarios> usuarios = FXCollections.observableArrayList();





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
