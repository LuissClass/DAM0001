package DAM1;

import java.util.Scanner;

public class contarMultiplosA9 {

    void calcularMultiplos() {
        int multiplosDos = 0;
        int multiplosTres = 0;
        int multiplosCinco = 0;
        Scanner input = new Scanner(System.in);
        int num;

        do {
            System.out.println("Introduce un numero: ");
            num = input.nextInt();

            if (num != 0) {
                multiplosDos = num % 2 == 0 ? multiplosDos + 1 : multiplosDos;
                multiplosTres = num % 3 == 0 ? multiplosTres + 1 : multiplosTres;
                multiplosCinco = num % 5 == 0 ? multiplosCinco + 1 : multiplosCinco;
            }
        } while (num != 0);

        System.out.println("Multiplos de 2: " + multiplosDos
                + "\nMultiplos de 3: " + multiplosTres + "\nMultiplos de 5: " + multiplosCinco);
    }

    public static void main(String[] args) {
        contarMultiplosA9 multiplos = new contarMultiplosA9();
        multiplos.calcularMultiplos();
    }
}