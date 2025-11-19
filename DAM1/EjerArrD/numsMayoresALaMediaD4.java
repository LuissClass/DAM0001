package DAM1.EjerArrD;

import java.util.Scanner;

public class numsMayoresALaMediaD4 {
    int[] arr = new int[10];
    int pos = 0;

    public static void main(String[] args) {
        numsMayoresALaMediaD4 o1 = new numsMayoresALaMediaD4();

        o1.leerNum();
        System.out.println("\n\tNumeros mayores a la media: ");
        o1.imprimirMayoresMedia();
    }

    void leerNum() {
        Scanner input = new Scanner(System.in);
        int res;
        do {
            System.out.println("\n\tTe quedan " + (arr.length - pos) + " numeros para introducir.");
            res = input.nextInt();
            if (res != 0) {
                addNum(res);
            }
        } while (pos < arr.length && res != 0);
    }

    void imprimirMayoresMedia() {
        int[] arrMM = calcularMayoresMedia();
        for (int i = 0; i < arrMM.length; i++) {
            System.out.println("\t\t" + arrMM[i]);
        }
    }

    int[] calcularMayoresMedia() {
        int pos2 = 0;
        double media = calcularMedia();

        for (int i = 0; i < pos; i++) {
            if (arr[i] > media) {
                pos2++;
            }
        }

        int[] arr2 = new int[pos2];
        pos2 = 0;

        for (int i = 0; i < pos; i++) {
            if (arr[i] > media) {
                arr2[pos2] = arr[i];
                pos2++;
            }
        }
        return arr2;
    }

    double calcularMedia() {
        double res = 0;
        for (int i = 0; i < pos; i++) {
            res += arr[i];
        }
        return res / pos;
    }

    void addNum(int num) {
        arr[pos] = num;
        pos++;
    }
}

