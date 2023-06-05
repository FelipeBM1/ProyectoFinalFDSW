package Modelo;

import javafx.scene.chart.PieChart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import static java.lang.Float.parseFloat;

public class ArchivosLectura {
    private static ArchivosLectura instancialectura;

    private ArchivosLectura(){

    }
    public static ArchivosLectura getInstance() {
        if (instancialectura == null) {
            instancialectura = new ArchivosLectura();
        }
        return instancialectura;
    }

    public LinkedList<String> LeerArchivo(String filepath, String id){
        File archivo = new File(filepath);
        String linea = "";
        LinkedList<String> datos= new LinkedList<>();

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
        }

            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                try {
                    while ((linea = br.readLine()) != null) {
                        String[] partes = linea.split(",");
                        float total=0;

                            if (id.equals(partes[0])) {


                                try{
                                    total=parseFloat(partes[1]);
                                }
                                catch (Exception ex){
                                    System.out.println(ex.getMessage());
                                }
                                if(partes.length==2){
                                    datos.add(partes[0]);
                                    datos.add(partes[1]);
                                }
                                else{
                                    datos.add(partes[0]);
                                    datos.add(partes[1]);
                                    datos.add(partes[2]);

                                }
                            }
                        }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());

            }




        return datos;
    }


}
