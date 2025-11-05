package DAM1;

import java.util.Scanner;

public class juegoCalculoNumericoC3 {
    int puntos = 0;
    int res = (int) (Math.random() * 4); // La primera vez, res sirve de numero aleatorio 2
    Scanner input = new Scanner(System.in);

    int generarNumeroAleatorio() {
        return (int) ((Math.random() + 1) * 10);
    }

    char generarOperacionAleatoria() {
        int opAleatoria = (int) (Math.random() * 4);
        char res = ' ';

        switch (opAleatoria) {
            case 0:
                res = '+';
                break;
            case 1:
                res = '*';
                break;
            case 2:
                res = '/';
                break;
            case 3:
                res = '-';
                break;
        }
        return res;
    }

    void generarEjercicio() {
        juegoCalculoNumericoC3 calculo = new juegoCalculoNumericoC3();
        int num = calculo.generarNumeroAleatorio();
        char op = calculo.generarOperacionAleatoria();

        System.out.println(res + " " + op + " " + num + " = ");

        res = calculoRes(res, num, op);

        int userRes = pedirRespuesta();
        verificarRespuesta(userRes);
    }

    int calculoRes(int num1, int num2, char op) {
        switch (op) {
            case 43:
                return num1 + num2;
            case 45:
                return num1 - num2;
            case 42:
                return num1 * num2;
            case 47:
                return num1 / num2;
        }
        return 0;
    }

    int pedirRespuesta() {
        return input.nextInt();
    }

    void verificarRespuesta(int userRes) {
        if (userRes == res) {
            puntos++;
            generarEjercicio();
        } else {
            System.out.println("Has fallado. Respuestas correctas: " + puntos);
        }
    }

    public static void main(String[] args) {
        juegoCalculoNumericoC3 juego = new juegoCalculoNumericoC3();
        juego.generarEjercicio();
    }
}
