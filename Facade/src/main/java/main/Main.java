package main;

import precios.FacadeArreglos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean band = true;
        int[] arreglo = null;
        while (band) {
            System.out.println("Arreglos de números");
            System.out.println("Menú");
            System.out.println("1. Leer arreglo");
            System.out.println("2. Ordenar de menor a mayor");
            System.out.println("3. Ordenar de mayor a menor");
            System.out.println("4. Imprimir arreglo");
            System.out.println("5. Salir");
            char opc = scn.next().charAt(0);
            FacadeArreglos fachada = new FacadeArreglos();
            switch (opc) {
                case '1':
                    System.out.println("Cuántos datos se ingresarán?");
                    int datosALeer = scn.nextInt();
                    arreglo = fachada.leerArreglo(datosALeer);
                    break;
                case '2':
                    if (arreglo != null) {
                        fachada.ordenarArregloMenMay(arreglo);
                    } else {
                        System.out.println("Debes leer primero un arreglo");
                    }
                    break;
                case '3':
                    if (arreglo == null) {
                        System.out.println("Debes leer primero un arreglo");
                    } else {
                        fachada.ordenarArregloMayMen(arreglo);
                    }
                    break;
                case '4':
                    if (arreglo == null) {
                        System.out.println("Debes leer primero un arreglo");
                    } else {
                        fachada.imprimirArreglo(arreglo);
                    }
                    break;
                case '5':
                    band = false;
                    break;
                default:
                    System.out.println("Ingresa un valor dentro del rango de opcioenes");
            }
            System.out.println();
        }
    }
}