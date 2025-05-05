import Interfaz.Bebida;
import componentebase.CafeSimple;
import decoradores.Azucar;
import decoradores.Leche;

public class Main {
    public static void main(String[] args) {
        // Instanciamos el componente concreto que será decorado posteriormente
        Bebida cafe = new CafeSimple();
        System.out.println(cafe.descripcion() + " | Costo: $" + cafe.costo());

        // Envolvemos la instancia original en un decorador de tipo decoradores.Leche
        // Ahora 'cafe' referencia al decorador que contiene la instancia original
        cafe = new Leche(cafe);
        System.out.println(cafe.descripcion() + " | Costo: $" + cafe.costo());

        // Envolvemos nuevamente el objeto decorado con otro decorador
        // La composición de decoradores se acumula en cascada
        cafe = new Azucar(cafe);
        System.out.println(cafe.descripcion() + " | Costo: $" + cafe.costo());
    }
}
