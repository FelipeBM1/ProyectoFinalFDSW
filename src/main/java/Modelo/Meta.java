package Modelo;

public class Meta  {
    private String Email;
    private float Ammount;
    private String Goal;


    Meta(String em,float am,String go){
        this.Email=em;
        this.Ammount=am;
        this.Goal=go;
    }

    public String getEmail() {
        return this.Email;
    }


    public void setEmail(String email) {
        this.Email=email;
    }


    public float getAmmount() {
        return this.Ammount;
    }


    public void setAmmount(float Ammount) {
        this.Ammount=Ammount;
    }

    public String getGoal() {
        return Goal;
    }

    public void setGoal(String goal) {
        Goal = goal;
    }
}
