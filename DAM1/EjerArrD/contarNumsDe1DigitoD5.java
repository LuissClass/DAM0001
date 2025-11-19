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
                addNum(res);
            }
        } while (res > 0 && pos < arr.length + 1);
        imprimirNumeros();
    }


    void imprimirNumeros() {
        for (int i = 0; i < pos; i++) {
            System.out.println("El " + arr[i] + " se ha introducido " + contarNum(arr[i]) + " veces.");
        }
    }

    void crecerArray() {
        arr = new int[arr.length + 1];
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

