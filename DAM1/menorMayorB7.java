package DAM1;

import java.util.Scanner;

public class menorMayorB7 {
    Scanner input = new Scanner(System.in);
    int mayor;
    int num;

    void calcularMayor() {
        do {
            System.out.println("Escibe un numero: ");
            num = input.nextInt();

            if (num >= 0) {
                mayor = mayor > num ? mayor : num;
            } else {
                System.out.println("ERROR! Se ha introducido un numero negativo.");
            }
        } while (num != 0);

        System.out.println("El mayor: " + mayor);
    }

    public static void main(String[] args) {
        menorMayorB7 elMayor = new menorMayorB7();
        elMayor.calcularMayor();
    }
}
