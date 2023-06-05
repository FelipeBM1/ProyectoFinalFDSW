import controlador.EstrategiaPresupuesto;

public class EstrategiaAhorro implements EstrategiaPresupuesto {
    @Override
    public double calcular(double ingresos, double gastos) {
        // Implementa la estrategia de cálculo de presupuesto enfocada en el ahorro
        return ingresos - gastos;
    }
}

public class EstrategiaControlGastos implements EstrategiaPresupuesto {
    @Override
    public double calcular(double ingresos, double gastos) {
        // Implementa la estrategia de cálculo de presupuesto enfocada en el control de gastos
        return ingresos - 1.2 * gastos;
    }
}

// Puedes agregar más clases que implementen diferentes estrategias de cálculo de presupuesto  se uso El patrón Strategy para encapsular diferentes algoritmos o estrategias en clases separadas

