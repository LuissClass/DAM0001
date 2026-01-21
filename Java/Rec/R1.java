package DAM1.Rec;

import java.util.Scanner;

public class R1 {
    public static void main(String[] args) {
        R1 r = new R1();
        int numsleidos = r.pedirNum(0);
        System.out.println(">> NUMS LEIDOS");
        System.out.println(numsleidos);
    }

    int pedirNum(int contador) {
        Scanner input = new Scanner(System.in);
        int num;

        System.out.println("Escribe num:");
        num = input.nextInt();
        System.out.println("num escrito: " + num + " cont: " + contador);

        if (num != 0) {
            contador = pedirNum(contador+1);
        } else {
        }
        return contador;
    }
}
