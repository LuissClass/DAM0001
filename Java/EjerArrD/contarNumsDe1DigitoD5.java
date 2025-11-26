package DAM1.EjerArrD;

import java.util.Scanner;

public class contarNumsDe1DigitoD5 {
    int[] arr = new int[0];
    int pos = 0;

    public static void main(String[] args) {
        contarNumsDe1DigitoD5 contar = new contarNumsDe1DigitoD5();
        contar.leerNum();
    }

    void leerNum() {
        Scanner input = new Scanner(System.in);
        int res = 0;
        do {
            System.out.println("\n\tTe quedan infinitos numeros para introducir.\n\tIntroduce num<0 para terminar.");
            res = input.nextInt();
            if (res > 0) {
                if (res < 10) {
                    addNum(res);
                } else {
                    System.out.println("EL NUMERO " + res + " NO SE HA PROCESADO.");
                }
            }

        } while (res > 0 && pos <= arr.length);
        imprimirNumeros();
    }


    void imprimirNumeros() {
        int[] numerosAparecidos = new int[arr.length];
        int num;
        int posNumApr = 0;
        boolean haAparecido;
        for (int i = 0; i < arr.length; i++) {
            num = arr[i];
            haAparecido = false;

            for (int j = 0; j < numerosAparecidos.length; j++) {
                if (num == numerosAparecidos[j]) {
                    haAparecido = true;
                }
            }

            if (!haAparecido) {
                numerosAparecidos[posNumApr] = num;
                posNumApr++;
            }
        }

        for (int i = 0; i < posNumApr; i++) {
            System.out.println("El " + numerosAparecidos[i] + " se ha introducido " + contarNum(numerosAparecidos[i]) + " veces.");
        }
    }

    void crecerArray() {
        if (arr != null) {
            int[] arrAux = arr;
            arr = new int[arr.length + 1];
            for (int i = 0; i < pos; i++) {
                arr[i] = arrAux[i];
            }
        } else {
            int[] arr = new int[1];
        }
    }

    void addNum(int num) {
        crecerArray();
        arr[pos] = num;
        pos++;
    }

    int contarNum(int num) {
        int res = 0;
        for (int i = 0; i < pos; i++) {
            if (num == arr[i]) {
                res++;
            }
        }
        return res;
    }
}

