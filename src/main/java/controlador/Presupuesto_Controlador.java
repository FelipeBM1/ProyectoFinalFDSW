package controlador;

import Modelo.ArchivosLectura;
import Modelo.Presupuesto;
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

public class Presupuesto_Controlador {
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
    private Button Pr_admPre;

    @FXML
    private TextField Pr_presupuesto;

    @FXML
    private Button Pr_principal;

    void Show_Budget(){

        ArchivosLectura lec=ArchivosLectura.getInstance();
        LinkedList<String> datos=lec.LeerArchivo("Budget.txt",usuario);
        Iterator<String> iterator= datos.iterator();
        if(!iterator.hasNext()){
            System.out.println("Vacio");
            return;
        }
        while(iterator.hasNext()){
            iterator.next();
            setBudget(Float.parseFloat(iterator.next()));
        }
        Pr_presupuesto.setText(getBudget().toString());


    }
    @FXML
    void Administrar(ActionEvent event) {
        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Administrate_Budget.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Adm_budget_Controlador admBudgetControlador=loader.getController();
            admBudgetControlador.setUsuario(getUsuario());
            admBudgetControlador.setBudget(getBudget());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void Inicio(ActionEvent event) {
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
