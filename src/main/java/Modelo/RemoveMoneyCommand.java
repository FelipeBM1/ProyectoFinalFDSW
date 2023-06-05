package Modelo;

public class RemoveMoneyCommand implements Command {
    private Presupuesto budget;
    private float amount;

    public RemoveMoneyCommand(Presupuesto budget, float amount) {
        this.budget = budget;
        this.amount = amount;
    }

    @Override
    public void execute() {
        budget.removeMoney(amount);
    }
}