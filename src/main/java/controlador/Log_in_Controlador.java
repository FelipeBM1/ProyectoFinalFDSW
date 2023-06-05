package controlador;

import Modelo.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Log_in_Controlador {

    @FXML
    private TextField In_con;

    @FXML
    private Button In_ing;

    @FXML
    private Label In_label;

    @FXML
    private TextField In_nombre;

    @FXML
    private Button In_reg;

    @FXML
    void Camb_reg(ActionEvent event) {
        Stage primaryStage;
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Sing_up.fxml"));
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void Ingresar(ActionEvent event) {
        String Name= In_nombre.getText();
        String Password= In_con.getText();
        Usuarios usuarios = new Usuarios();

        if (Name.isEmpty() || Password.isEmpty() ) {
            In_label.setText("algunos de los campos esta vacio");
            return;
        }
        if(!usuarios.CheckCredentials(Name,Password)){
            In_label.setText("Contraseña o nombre equivocado");
            return;
        }


        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Main_Screen.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Main_Screen_Controlador mainc=loader.getController();
            mainc.setUsuario(Name);
            mainc.Display_Name();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}