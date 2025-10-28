package DAM1;

import java.util.Scanner;

public class siempreMayorA12 {
    Scanner input = new Scanner(System.in);

    void pedirNumeros() {
        int numeroMenor;
        int numeroMayor = 0;

        do {
            numeroMenor = numeroMayor;
            System.out.println("Introduce un numero mayor al anterior para continuar: ");
            numeroMayor = input.nextInt();

            if (numeroMayor < 0) {
                numeroMayor = numeroMenor;
                System.out.println("ERROR: Se ha introducido un numero negativo!");
            }

        } while (numeroMayor >= numeroMenor);


        System.out.println("Fin");
    }

    public static void main(String[] args) {
        siempreMayorA12 sm = new siempreMayorA12();
        sm.pedirNumeros();
    }
}
