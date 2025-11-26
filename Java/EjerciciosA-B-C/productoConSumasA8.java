package DAM1;

import java.util.Scanner;

public class productoConSumasA8 {
    Scanner input = new Scanner(System.in);

    void cacularProducto() {
        int counter = 0;
        int factorMenor;
        int factorMayor;
        int producto = 0;
        int factorAux = 0;

        System.out.println("Introduce el primer factor: ");
        factorMayor = input.nextInt();

        System.out.println("Introduce el segundo factor: ");
        factorMenor = input.nextInt();

        if (factorMayor < factorMenor) {
            factorAux = factorMayor;
            factorMayor = factorMenor;
            factorMenor = factorAux;
        }

        do {
            producto += factorMayor;
            counter++;
        } while (counter < factorMenor);

        System.out.println("PRODUCTO: " + producto);
    }

    public static void main(String[] args) {
        productoConSumasA8 producto1 = new productoConSumasA8();
        producto1.cacularProducto();
    }
}
