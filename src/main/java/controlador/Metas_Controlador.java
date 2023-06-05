package controlador;

import Modelo.ArchivosAdmin;
import Modelo.ArchivosLectura;
import Modelo.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.LinkedList;

public class Metas_Controlador {
    private String usuario;
    private Float Budget;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Float getBudget() {
        return Budget;
    }

    public void setBudget(Float budget) {
        Budget = budget;
    }

    @FXML
    private Button Me_Incio;

    @FXML
    private Button Me_Nueva;

    @FXML
    private TextField Me_text;

    void Mostrar_Metas(){
        ArchivosLectura lectura= ArchivosLectura.getInstance();
        LinkedList<String> datos=new LinkedList<>();
        datos=lectura.LeerArchivo("Goals.txt",usuario);
        if(datos.isEmpty()){
            Me_text.setText("No hay metas aun");
        }
        else{
            Iterator<String> iterator= datos.iterator();
            while(iterator.hasNext()){
                iterator.next();
                Me_text.setText(iterator.next()+" "+iterator.next());
            }
        }
    }
    @FXML
    void Pantalla_Nueva_Meta(ActionEvent event) {
        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("New_Goal.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Nueva_Meta_Controlador newg=loader.getController();
            newg.setUsuario(usuario);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void Volver_inicio(ActionEvent event) {
        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Main_Screen.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Main_Screen_Controlador mainc=loader.getController();
            mainc.setUsuario(usuario);
            mainc.Display_Name();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}