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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
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
    private Label imgLabel;

    @FXML
    private ImageView imgCa;


    @FXML
    private TextField txtTamannio;

    @FXML
    private Button btnAgregarIMG;

    private String Imagen = "";

    /**
     * La funcion realiza una busqueda de imagen
     * @author Esteban Barrera
     */
    public void buscarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        File imgFile = fileChooser.showOpenDialog(null);
        if (imgFile != null) {
            imgLabel.setText(imgFile.toString());
            imgCa.setImage(new Image(imgFile.toURI().toString()));
            Imagen = imgFile.toString();
        }
    }

    /**
     *La funcion al hacer click inicia la funcion buscarImagen();
     * @author Esteban Barrera
     * @param event Click
     */
    @FXML
    void Click(ActionEvent event) {
        buscarImagen();
    }


    ObservableList<Camisas> camisas = FXCollections.observableArrayList();

    /**
     * La funcion al hacer click se lee los datos agregados
     * @author Esteban Barrera
     * @param event click
     */
    @FXML
    void click(ActionEvent event) {
        try {
            String color = this.txtColor.getText();
            String desc = this.txtDescripcion.getText();
            float precios = Integer.parseInt(this.txtPrecio.getText());
            String tamannio =this.txtTamannio.getText();
            int id = (int) (Math.random()*(999999999-100000000+1)+100000000);
            boolean error = Almacenamiento.agregarCamisa(color, precios, desc, tamannio, Imagen, id);
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


    /**
     * La funcion inicializa el cargarDatos();
     * @author Esteban Barrera
     * @param url recibe un dato URL
     * @param resourceBundle recibe un dato resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CargarDatos();
    }

    /**
     * La funcion agrega los datos en las tablas
     * @author Esteban Barrera
     */
    public void CargarDatos(){
        camisas.addAll(Almacenamiento.poolcamisas);
        coluDesc.setCellValueFactory(new PropertyValueFactory("desc"));
        coluID.setCellValueFactory(new PropertyValueFactory("ID"));
        coluColor.setCellValueFactory(new PropertyValueFactory("color"));
        coluPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        coluImg.setCellValueFactory(new PropertyValueFactory("Imagen"));
        coluTamannio.setCellValueFactory(new PropertyValueFactory("tamannio"));
        tblCamisa.setItems(camisas);
    }

    /**
     * La funcion al cerrar la ventana devovlerse al Menu
     * @author Esteban Barrrera
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
