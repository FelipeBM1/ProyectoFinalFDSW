package Modelo;

public class AddMoneyCommand implements Command {
    private Presupuesto budget;
    private float amount;

    public AddMoneyCommand(Presupuesto budget, float amount) {
        this.budget = budget;
        this.amount = amount;
    }

    @Override
    public void execute() {
        budget.addMoney(amount);
    }
}