package decoradores;

import Interfaz.Bebida;

/**
 * Clase Decorator abstracta que implementa la misma interfaz del componente
 * Actúa como clase base para todos los decoradores concretos
 * Mantiene una referencia al objeto decorado para implementar la delegación
 */
public abstract class IngredienteDecorador implements Bebida {
    protected Bebida bebida; // Referencia al objeto que se está decorando

    public IngredienteDecorador(Bebida bebida) {
        this.bebida = bebida; // Inyecta la dependencia del objeto a decorar mediante constructor
    }

    // No implementa los métodos de la interfaz, forzando a las subclases a definir cómo extienden la funcionalidad
}
