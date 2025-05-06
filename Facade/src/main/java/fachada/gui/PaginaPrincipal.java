package fachada.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class PaginaPrincipal extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Utilidades.abrirVentana(
                "/PaginaPrincipal.fxml",
                "Sistema de audio"
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
