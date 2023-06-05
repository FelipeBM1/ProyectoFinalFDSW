package controlador;

import Modelo.ArchivosAdmin;
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
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Nueva_Meta_Controlador {
    private String usuario;
    private Float Budget;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
    private TextField N_Meta;

    @FXML
    private TextField N_presupuesto;

    @FXML
    private Button New_goal;

    @FXML
    private Button Nm_Inicio;

    @FXML
    private Label Nm_label1;

    @FXML
    private Label Nm_label2;


    @FXML
    void Insert_New_Goal(ActionEvent event) {
        try{
            String Meta=N_Meta.getText();
            String values=N_presupuesto.getText();

            if(Meta.isEmpty()||values.isEmpty()){
                Nm_label2.setText("Faltan campos por llenar");
                return;
            }
            Float amount=Float.parseFloat(values);
            if(amount<1){
                Nm_label2.setText("El valor debe ser mayor a 0");
            }
            ArchivosAdmin adm=ArchivosAdmin.getInstance();
            LinkedList<String> datos=new LinkedList<>();
            datos.add(usuario);
            datos.add(Meta);
            datos.add(values);
            adm.writeFile("Goals.txt",datos);
            Nm_label2.setText("Se ha añadido la meta exitosamente");

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void Volver_Inicio(ActionEvent event) {
        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Sing_Up.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
