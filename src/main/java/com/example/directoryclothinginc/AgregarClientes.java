package com.example.directoryclothinginc;

import Controlador.Almacenamiento;
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

public class AgregarClientes implements Initializable {

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

    @FXML
    private void click(ActionEvent event) {
        try {
            String Nombre = this.txtNombre.getText();
            String PrimerApellido = this.txtApellido1.getText();
            String SegundoApellido = this.txtApellido2.getText();
            String Direccion = this.txtDireccion.getText();
            String Correo = this.txtCorreo.getText();
            int ID = Integer.parseInt(this.txtID.getText());
            boolean error = Almacenamiento.agregarCliente(Nombre,PrimerApellido, SegundoApellido, Direccion, Correo, ID);



            if (error == false) {
                for (Usuarios usuarioMostrar : Almacenamiento.poolusuarios) {
                    this.usuarios.add(usuarioMostrar);
                    tblUsusarios.getItems().clear();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CargarDatos();
    }
    public void CargarDatos(){
        usuarios.addAll(Almacenamiento.poolusuarios);
        ColmNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        ColmApellido1.setCellValueFactory(new PropertyValueFactory("apellido1"));
        ColmApellido2.setCellValueFactory(new PropertyValueFactory("apellido2"));
        ColmDireccion.setCellValueFactory(new PropertyValueFactory("direccion"));
        ColmEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colmID.setCellValueFactory(new PropertyValueFactory("ID"));
        tblUsusarios.setItems(usuarios);
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
