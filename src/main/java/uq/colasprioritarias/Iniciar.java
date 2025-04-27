package uq.colasprioritarias;

import ViewController.PedidosViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Iniciar extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Ventana Principal");
        this.mostrarVentanaPrincipal();



    }

    private void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Iniciar.class.getResource("prioridad.fxml"));
            AnchorPane rootLayout = (AnchorPane)loader.load();
            PedidosViewController selectViewController = (PedidosViewController) loader.getController();
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}




