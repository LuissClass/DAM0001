package damClase.EjsF;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class F2 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        F2 f2 = new F2();

        System.out.println("¿Cuantos nombres quieres introducir?");
        int numNames = input.nextInt();

        String[] nameList = f2.pedirNames(numNames);
        String[] arrOrdendo = f2.ordenarArr(nameList.clone());

        for (int i = 0; i < nameList.length; i++) {
            System.out.println("Index: " + i + " -> Original: " + nameList[i] + " - Ordenado: " + arrOrdendo[i]);
        }
    }


    String[] ordenarArr(String[] arr) {
        // Usar burbuja
        String aux;
        String[] parejas = new String[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                parejas[0] = arr[j];
                parejas[1] = arr[j+1];
                Arrays.sort(parejas);
                arr[j] = parejas[1];
                arr[j+1] = parejas[0];
            }
        }
        return arr;
    }

    String[] pedirNames(int numNames) {
        String[] nameList;
        String names;
        boolean arrTieneMismoTamanoQueNumNames = false;

        do {
            if (numNames == 1) {
                System.out.println("Escribe el nombre: ");
            } else {
                System.out.println("Escibe los " + numNames + " nombres, separados por espacios en blanco (' '): ");
            }
            names = input.nextLine();
            nameList = names.split(" ");

            if (nameList.length == numNames) {
                arrTieneMismoTamanoQueNumNames = true;
            } else if (nameList.length > numNames) {
                System.out.println(">>Te has pasado de " + numNames + " cantidad de nombres");
            } else {
                System.out.println(">>Te  faltan nombres");
            }
        } while (!arrTieneMismoTamanoQueNumNames);
        return nameList;
    }
}
