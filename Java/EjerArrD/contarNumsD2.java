package DAM1.EjerArrD;

import java.util.Scanner;

public class contarNumsD2 {
    int[] arr = new int[10];
    int pos = 0;

    public static void main(String[] args) {
        contarNumsD2 contar = new contarNumsD2();
        contar.leerNum();
    }

    void leerNum() {
        Scanner input = new Scanner(System.in);
        int res = 0;
        do {
            System.out.println("\n\tTe quedan " + (arr.length - pos) + " numeros para introducir.\n\tIntroduce 0 para terminar.");
            res = input.nextInt();
            if (res != 0) {
                addNum(res);
            }
            System.out.println("Este numero se repite " + contarNum(res) + " veces");
        } while (res != 0 && pos < arr.length);
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
