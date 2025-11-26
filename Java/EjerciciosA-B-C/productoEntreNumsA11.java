package DAM1;

import java.util.Scanner;

public class productoEntreNumsA11 {
    Scanner input = new Scanner(System.in);

    void calcularProducto(int numExcluir1, int numExcluir2) {
        int numeroMenor;
        int numeroMayor;
        int numAux;
        int counter = 0;
        int producto = 1;

        System.out.println("Introduce el primer numero: ");
        numeroMenor = input.nextInt();
        System.out.println("Introduce el segundo numero: ");
        numeroMayor = input.nextInt();

        if (numeroMayor < numeroMenor) {
            numAux = numeroMenor;
            numeroMenor = numeroMayor;
            numeroMayor = numAux;
        }

        counter = numeroMenor + 1;

        while(counter < numeroMayor) {
            if (numExcluir1 != counter && numExcluir2 != counter) producto *= counter;
            counter ++;
        }

        System.out.println("Producto final: " + producto);
    }

    public static void main(String[] args) {
        productoEntreNumsA11 pen = new productoEntreNumsA11();
        pen.calcularProducto(5, 6);
    }
}
