package application;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application{
    @Override
    public void start(Stage primaryStage) {
            try {

                    final URL fxmlURL = getClass().getResource("/view/VRoot.fxml");
                    final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
                    
                   // final VBox node = (VBox) fxmlLoader.load();
                    final AnchorPane node = (AnchorPane) fxmlLoader.load();
                    Scene scene = new Scene(node);
                    
                    primaryStage.setX(100);
                    primaryStage.setY(100);

                    primaryStage.setTitle("Acceuil");
                    primaryStage.setScene(scene);
                    primaryStage.show();
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

    public static void main(String[] args) {
            launch(args);
    }

}
