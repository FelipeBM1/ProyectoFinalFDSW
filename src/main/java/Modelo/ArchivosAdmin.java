package Modelo;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArchivosAdmin {
    private static ArchivosAdmin instancia;

    private ArchivosAdmin(){

    }
    public static ArchivosAdmin getInstance() {
        if (instancia == null) {
            instancia = new ArchivosAdmin();
        }
        return instancia;
    }


    public  boolean CheckFile(String filepath, String id,String pass){
        File archivo = new File(filepath);
        String linea = "";

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
                        if(pass=="0"){
                            if (id.equals(partes[0])) {
                                return true;
                            }
                        }
                        else{
                            if (id.equals(partes[0])&&pass.equals(partes[1])) {
                                return true;
                            }
                        }

                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());

            }




        return false;
    }

    public void writeFile(String filePath, LinkedList<String> content) {
        File archivo = new File(filePath);
        FileWriter fr;
        Iterator<String> iterator= content.iterator();
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
        }
        try {
            fr = new FileWriter(archivo, true);
            BufferedWriter br = new BufferedWriter(fr);
            while(iterator.hasNext()) {
                br.write(iterator.next()+",");
            }
            br.newLine();
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void Eliminate_Old_budget(String Email) {
        File archivo = new File("Budget.txt");
        File aux = new File("aux.txt");

        String linea = "";
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
                    if (Email.equals(partes[0])) {

                    } else {
                        FileWriter fw;
                        try {
                            fw = new FileWriter(aux, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(partes[0] + "," + partes[1]);
                            bw.newLine();
                            bw.close();
                            fw.close();

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }

                }
                fr.close();
                br.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        archivo.delete();
        aux.renameTo(archivo);

    }
    }

