module com.example.proyecto_fundamentos {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;


    exports controlador;
    opens controlador to javafx.fxml;
    exports Vista;
    opens Vista to javafx.fxml;
}