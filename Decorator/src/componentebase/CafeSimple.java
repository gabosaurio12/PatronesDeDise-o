package componentebase;

import Interfaz.Bebida;

/**
 * Clase ConcreteComponent que implementa la interfaz Interfaz.Bebida
 * Implementación concreta del componente base sobre el cual se aplicarán
 * los decoradores
 * Define el comportamiento básico que puede ser modificado dinámicamente
 */

public class CafeSimple implements Bebida {
    @Override
    public String descripcion() { return "Café simple"; }

    @Override
    public double costo() { return 2.00; }
}
