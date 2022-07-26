package com.example.directoryclothinginc;


import Controlador.Almacenamiento;
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

public class AgregarCamisas implements Initializable {

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
    @FXML
    void click(ActionEvent event) {
        try {
            String color = this.txtColor.getText();
            String desc = this.txtDescripcion.getText();
            float precios = Integer.parseInt(this.txtPrecio.getText());
            String tamannio =this.txtTamannio.getText();
            int id = (int) (Math.random()*(999999999-100000000+1)+100000000);
            boolean error = Almacenamiento.agregarCamisa(color, precios, desc, tamannio, id);
            if(error == false){
                for (Camisas camisaMostrar: Almacenamiento.poolcamisas){
                    this.camisas.add(camisaMostrar);
                    tblCamisa.getItems().clear();
                    CargarDatos();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato Incorrecto");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
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
        camisas.addAll(Almacenamiento.poolcamisas);
        coluDesc.setCellValueFactory(new PropertyValueFactory("desc"));
        coluID.setCellValueFactory(new PropertyValueFactory("ID"));
        coluColor.setCellValueFactory(new PropertyValueFactory("color"));
        coluPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        coluTamannio.setCellValueFactory(new PropertyValueFactory("tamannio"));
        tblCamisa.setItems(camisas);
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
