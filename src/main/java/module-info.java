module com.example.directoryclothinginc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.directoryclothinginc to javafx.fxml;
    exports com.example.directoryclothinginc;
    opens Controlador to javafx.fxml;
    exports Controlador;
    opens Modelo to javafx.fxml;
    exports Modelo;
}