package DAM1;

import java.util.Scanner;

public class decimalToBinaryC6 {
    long bin = 0;
    Scanner input = new Scanner(System.in);
    int suma = 0;

    long convertirToBinario(int decimal) {
        int potencia = calcularPotencia(decimal);
        bin = (long) Math.pow(10, potencia);
        long digitoBin = bin;

        suma += Math.pow(2, potencia);
        potencia--;
        digitoBin /= 10;

        while (suma != decimal) {
            if (suma + Math.pow(2, potencia) <= decimal) {
                suma += Math.pow(2, potencia);
                bin += digitoBin;
            }
            digitoBin /= 10;
            potencia--;
        }
        return bin;
    }

    int calcularPotencia(int decimal) {
        int potencia = 0;
        while (Math.pow(2, potencia) < decimal) {
            potencia++;
        }
        return potencia - 1;
    }

    public static void main(String[] args) {
        decimalToBinaryC6 calculo = new decimalToBinaryC6();
        System.out.println(calculo.convertirToBinario(11));
    }
}
