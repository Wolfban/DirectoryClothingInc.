package com.example.directoryclothinginc;


import Modelo.Camisas;
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
import java.util.UUID;

public class AgregarCamisas {

    @FXML
    private Button btnCrear;

    @FXML
    private TableColumn<?, ?> coluColor;

    @FXML
    private TableColumn<?, ?> coluDesc;

    @FXML
    private TableColumn<?, ?> coluID;

    @FXML
    private TableColumn<?, ?> coluImg;

    @FXML
    private TableColumn<?, ?> coluPrecio;

    @FXML
    private TableColumn<?, ?> coluTamannio;

    @FXML
    private TableView<Camisas> tblCamisa;

    @FXML
    private TextField txtColor;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtTamannio;


    ObservableList<Camisas> camisas = FXCollections.observableArrayList();
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
