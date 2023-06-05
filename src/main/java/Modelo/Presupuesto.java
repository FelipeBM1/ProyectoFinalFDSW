package Modelo;

import java.util.LinkedList;

public class Presupuesto  {
    private String Email;
    private float Amount;

    public Presupuesto(String email, float ammount) {
        Email = email;
        Amount = ammount;
    }

    public String getEmail() {
        return this.Email;
    }


    public void setEmail(String email) {
        this.Email=email;
    }


    public float getAmmount() {
        return this.Amount;
    }


    public void setAmmount(float Ammount) {
        this.Amount=Ammount;
    }

    public void InsertBudget(String Email,String Ammount){
        ArchivosAdmin adm= ArchivosAdmin.getInstance();
        LinkedList<String> budget= new LinkedList<>();
        budget.add(Email);
        budget.add(Ammount);
        adm.writeFile("Budget.txt",budget);
    }
    public void addMoney(float amount) {
        this.Amount += amount;
            }

    public void removeMoney(float amount) {

            this.Amount -= amount;


    }

    public void executeCommand(Command command) {
        command.execute();
    }


}
