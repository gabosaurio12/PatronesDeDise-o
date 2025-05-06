package decoradores;


import Interfaz.Bebida;

/**
 * DecoradorConcreto que añade funcionalidad para representar la adición de leche
 * Implementa la lógica específica para extender el comportamiento del componente decorado
 */
public class Leche extends IngredienteDecorador {
    public Leche(Bebida bebida) {
        super(bebida); // Pasa el objeto a decorar al constructor de la clase padre
    }

    @Override
    public String descripcion() {
        return bebida.descripcion() + ", con leche"; // Delega al objeto decorado y añade su propia funcionalidad
    }

    @Override
    public double costo() {
        return bebida.costo() + 0.50; // Extiende el comportamiento del costo añadiendo el valor del ingrediente
    }
}
