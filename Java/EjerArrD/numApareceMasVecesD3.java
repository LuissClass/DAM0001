package DAM1.EjerArrD;

import java.util.Scanner;

public class numApareceMasVecesD3 {
    int[] arr = new int[20];
    int pos = 0;

    public static void main(String[] args) {
        numApareceMasVecesD3 o1 = new numApareceMasVecesD3();

        o1.leerNum();
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

        System.out.println("Este es el numero que mas se repite: " + calcularMasRepetido() + ", repetido unas " + contarNum(calcularMasRepetido()) + " veces");
    }

    int calcularMasRepetido() {
        int numMayor = 0;

        for (int i = 0; i < pos; i++) {
            if (numMayor < contarNum(arr[i])) {
                numMayor = arr[i];
            }
        }
        return numMayor;
    }

    void addNum(int num) {
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
        return res - 1;
    }
}
