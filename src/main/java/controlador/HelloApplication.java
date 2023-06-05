package controlador;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class HelloApplication extends Application {
    public HelloApplication() {
    }
    @Override
    public void start(Stage primaryStage)  {
        try{

            Parent root = FXMLLoader.load(getClass().getResource("Sing_up.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}