package decoradores;

import Interfaz.Bebida;

/**
 * DecoradorConcreto para azúcar que sigue el mismo patrón que otros decoradores
 * Puede decorar tanto al componente base como a otro decorador, permitiendo composición dinámica
 */

public class Azucar extends IngredienteDecorador {
    public Azucar(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String descripcion() {
        return bebida.descripcion() + ", con azúcar"; // Concatena el nuevo estado al resultado del objeto decorado
    }

    @Override
    public double costo() {
        return bebida.costo() + 0.20; // Aplica el costo adicional sobre el resultado del objeto decorado
    }
}
