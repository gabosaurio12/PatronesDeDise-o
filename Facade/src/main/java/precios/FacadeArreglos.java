package precios;

import manejadordearreglos.GestorDeArreglos;

public class FacadeArreglos implements Facade{
    private final GestorDeArreglos gestor = new GestorDeArreglos();

    @Override
    public int[] leerArreglo(int numeroDatos) {
        return gestor.leerArreglo(numeroDatos);
    }

    @Override
    public void ordenarArregloMenMay(int[] arreglo) {
        gestor.quickSortMenorMayor(arreglo, 0, arreglo.length - 1);
    }

    @Override
    public void ordenarArregloMayMen(int[] arreglo) {
        gestor.quickSortMayorMenor(arreglo, 0, arreglo.length - 1);
    }

    @Override
    public void imprimirArreglo(int[] arreglo) {
        gestor.imprimirArreglo(arreglo);
    }
}
