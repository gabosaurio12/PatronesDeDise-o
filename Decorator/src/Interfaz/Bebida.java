package Interfaz;

/**
 * Interfaz Component del patrón Decorator
 * Define el contrato común que deben implementar tanto el componente base como
 * los decoradores, permite que los decoradores sean tratados de manera transparente
 * como el componente base
 */

public interface Bebida {
    String descripcion();
    double costo();
}

