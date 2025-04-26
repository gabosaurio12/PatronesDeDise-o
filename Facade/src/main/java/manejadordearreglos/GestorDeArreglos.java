package manejadordearreglos;

import java.util.Scanner;

public class GestorDeArreglos {

    public int[] leerArreglo(int numeroDatos) {
        Scanner scn = new Scanner(System.in);
        int[] arreglo = new int[numeroDatos];
        for (int i = 0; i < numeroDatos; i++) {
            arreglo[i] = scn.nextInt();
        }

        return arreglo;
    }

    public void quickSortMenorMayor(int[] arreglo, int primero, int ultimo) {
        if (primero < ultimo) {
            int pivote = particionMenorMayor(arreglo, primero, ultimo);

            quickSortMenorMayor(arreglo, primero, pivote - 1);
            quickSortMenorMayor(arreglo, pivote + 1, ultimo);
        }
    }

    public int particionMenorMayor(int[] arreglo, int primero, int ultimo) {
        int pivote = arreglo[ultimo];
        int i = primero - 1;

        for (int j = primero; j < ultimo; j++) {
            if (arreglo[j] < pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[ultimo];
        arreglo[ultimo] = temp;

        return i + 1;
    }

    public void quickSortMayorMenor(int[] arreglo, int primero, int ultimo) {
        if (primero < ultimo) {
            int pivote = particionMayorMenor(arreglo, primero, ultimo);

            quickSortMayorMenor(arreglo, primero, pivote - 1);
            quickSortMayorMenor(arreglo, pivote + 1, ultimo);
        }
    }

    public int particionMayorMenor(int[] arreglo, int primero, int ultimo) {
        int pivote = arreglo[ultimo];
        int i = primero - 1;

        for (int j = primero; j < ultimo; j++) {
            if (arreglo[j] > pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[ultimo];
        arreglo[ultimo] = temp;

        return i + 1;
    }

    public void imprimirArreglo(int[] arreglo) {
        for (int i : arreglo) {
            System.out.printf("%d ", i);
        }
    }

}
