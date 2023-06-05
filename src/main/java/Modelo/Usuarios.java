package Modelo;

import java.io.*;
import java.util.LinkedList;

public class Usuarios {
    private String Name;
    private String Password;
    public Usuarios(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void User(String Name, String password){
        this.Name=Name;
        this.Password=password;
    }
    public boolean UserinUse(String Email,String pass) {
        ArchivosAdmin adm= ArchivosAdmin.getInstance();
        return adm.CheckFile("Users.txt",Email,pass);
    }
    public boolean CheckCredentials(String Email,String password){
        ArchivosAdmin adm= ArchivosAdmin.getInstance();
        return adm.CheckFile("Users.txt",Email,password);
    }

    public void InsertUser() {
        LinkedList<String> User = new LinkedList<>();
        User.add(Name);
        User.add(Password);
        ArchivosAdmin adm= ArchivosAdmin.getInstance();
        adm.writeFile("Users.txt",User);
    }
    public boolean Log_in(String Email,String Password){
        ArchivosAdmin adm= ArchivosAdmin.getInstance();
        return adm.CheckFile("Users.txt",Email,Password);
    }
    }
