package com.example.directoryclothinginc;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    /**
     * Las funcion se empieza el programa
     * @author Esteban Barrera
     * @param primaryStage recibe dato tipo Stage
     */
    @Override
    public void start(Stage primaryStage) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("menu.fxml"));


            Pane ventana = (Pane) loader.load();


            Scene scene = new Scene(ventana);


            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * La funcion hace el lauch del programa
     * @author Esteban Barrera
     * @param args launch del programa
     */
    public static void main(String[] args) {
        launch(args);
    }

}