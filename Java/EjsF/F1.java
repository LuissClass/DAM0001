package damClase.EjsF;

import java.util.Scanner;

public class F1 {
    public static void main(String[] args) {
        //PLANTILLA_10_NOMBRES -> "Juan Pedro Luis Carlos Miguel Andres Jose Diego Mario Sergio";
        F1 f1 = new F1();
        f1.buscarNames(f1.pedirNames(10));
    }

    Scanner input = new Scanner(System.in);

    void buscarNames(String[] arr) {
        if (isArrComplete(arr)) {
            String[] namesUser;
            String[] res;
            int contAciertos = 0;

            do {
                System.out.println("\t\t\t\t (PARA FINALIZAR ESCRIBE 'fin')");
                res = pedirNames(1);

                if (!res[0].equalsIgnoreCase("fin")) {
                    for (int i = 0; i < arr.length; i++) {
                        if (res[0].equalsIgnoreCase(arr[i])) {
                            contAciertos++;
                            System.out.println("\t>>El nombre " + res[0] + " se encuentra en el array de nombres.\tAciertos: " + contAciertos);
                        }
                    }
                    System.out.println("\t>>Aciertos: " + contAciertos);
                }
            } while (!res[0].equalsIgnoreCase("fin"));
        } else {
            System.out.println(">>El array no esta lleno");
        }
    }

    boolean isArrComplete(String[] arr) {
        boolean isComplete = true;
        for (int i = 0; i < arr.length; i++) {
            isComplete = arr[i] != null && isComplete;
        }
        return isComplete;
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
