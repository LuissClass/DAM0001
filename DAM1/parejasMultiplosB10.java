package DAM1;

import java.util.Scanner;

public class parejasMultiplosB10 {
    Scanner input = new Scanner(System.in);
    int num1;
    int num2;
    int contadorMultiplos;

    void calcularParejasDeMultiplos() {
        do {
            System.out.println("Introduce el primer numero: ");
            num1 = input.nextInt();
            System.out.println("Introduce el segundo numero: ");
            num2 = input.nextInt();

            if (num1 != 0 && num2 != 0) {
                if (num1 != num2) {
                    contadorMultiplos = num1 % num2 == 0 ? contadorMultiplos + 1 : contadorMultiplos;
                    contadorMultiplos = num2 % num1 == 0 ? contadorMultiplos + 1 : contadorMultiplos;
                } else {
                    contadorMultiplos++;
                }
            }
        } while (num1 != 0 && num2 != 0);
        System.out.println("En " + contadorMultiplos + " parejas un numero ha sido multiplo del otro.");
    }

    public static void main(String[] args) {
        parejasMultiplosB10 cm = new parejasMultiplosB10();
        cm.calcularParejasDeMultiplos();
    }
}
