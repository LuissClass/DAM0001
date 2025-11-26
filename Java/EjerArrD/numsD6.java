package DAM1.EjerArrD;

import java.util.Scanner;

public class numsD6 {
    int[] numsIntro = new int[101];
    int posNumsIntro = 0;

    public static void main(String[] args) {
        numsD6 n = new numsD6();
        n.leerNum();
        n.imprimirNumsNoIntro();
    }

    void leerNum() {
        Scanner input = new Scanner(System.in);
        int res = 0;
        do {
            System.out.println("\n\tTe quedan infinitos numeros para introducir.\n\tIntroduce num<0 para terminar.");
            res = input.nextInt();
            if (res >= 0 && res <= 100) {
                addNumIntro(res);
            }

        } while (res >= 0 && posNumsIntro <= numsIntro.length);
    }


    void imprimirNumsNoIntro() {

        for (int i = 0; i <= 100; ++i) {
            if (!estaEnNumsIntro(i)) {
                System.out.println("Numero no introducido: " + i);
            } else {
                System.out.println("ESTE NUMERO SE HA INTRODUCIDO");
            }
        }
    }

    boolean estaEnNumsIntro(int num) {
        boolean res = false;
        for (int i = 0; i < posNumsIntro && !res; ++i) {
            res = num == numsIntro[i];
        }
        return res;
    }

    void addNumIntro(int num) {
        numsIntro[posNumsIntro] = num;
        posNumsIntro++;
    }

}

