package fachada.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Utilidades {

    public static void abrirVentana(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(Utilidades.class.getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Error al abrir ventana" + e.getMessage());
        }
    }

    public static <T> T abrirVentana(String fxmlPath, String title, Class<T> controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(Utilidades.class.getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

            T loaderController;
            loaderController = loader.getController();
            if (controllerClass.isInstance(loaderController)) {
                return controllerClass.cast(loaderController);
            } else {
                System.err.println("Controlador no es del tipo esperado");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al abrir ventana");
            return null;
        }
    }
}
