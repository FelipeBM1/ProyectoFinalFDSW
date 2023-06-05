package controlador;

public class Controlador {
    private Vista vista;
    private EstrategiaPresupuesto estrategia;

    public Controlador(Vista vista) {
        this.vista = vista;
        // Establece una estrategia predeterminada, por ejemplo, la de ahorro
        this.estrategia = new EstrategiaAhorro();
    }

    public void cambiarEstrategia(EstrategiaPresupuesto estrategia) {
        this.estrategia = estrategia;
    }

    public void calcularPresupuesto(double ingresos, double gastos) {
        double saldoRestante = estrategia.calcular(ingresos, gastos);
        vista.mostrarResumen(ingresos, gastos, saldoRestante);
    }
}