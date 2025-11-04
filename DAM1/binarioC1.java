package DAM1;

import java.util.Scanner;

public class binarioC1 {
    int decimal = 0;
    long bin = 0;
    Scanner input = new Scanner(System.in);

    void pedirBinario() {
        System.out.println("ESCRIBE EL NUMERO EN BINARIO: ");
        bin = input.nextLong();
    }

    void calcularDeBinADec() {
        int digito;
        long binario = bin;
        int counter = -1;

        do {
            counter++;
            digito = (int) (binario % 10);
            binario = binario / 10;

            if (digito == 1) {
                decimal += Math.pow(2, counter);
            } else if (digito == 0) {

            } else {
                System.out.println("ERROR!");
            }

        } while (((binario * 10) / 10) != 0);

    }

    void imprimirDec() {
        System.out.println("[...]\nNUMERO EN DECIMAL: " + decimal);
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        binarioC1 bin1 = new binarioC1();
        bin1.pedirBinario();
        bin1.calcularDeBinADec();
        bin1.imprimirDec();
        long fin = System.currentTimeMillis();
        System.out.println("Duracion del programa: " + ((fin-inicio)/1000) + " segundos");
    }
}
