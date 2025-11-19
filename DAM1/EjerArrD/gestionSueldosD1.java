package DAM1.EjerArrD;

import java.util.Scanner;

public class gestionSueldosD1 {
    public static void main(String[] args) {
        Empresa empr1 = new Empresa();
        empr1.addSueldo(1200.13);
        empr1.addSueldo(1500.21);
        empr1.addSueldo(980.70);
        empr1.addSueldo(2500.99);
        empr1.addSueldo(600.4);
        empr1.imprimirSueldos();

        empr1.menu();
    }
}

class Empresa {
    double[] sueldoEmpleados = new double[50];
    int pos = 0;

    void menu() {
        Scanner input = new Scanner(System.in);
        int res = 0;

        do {
            System.out.println("\n==MENU==");
            System.out.println("Opciones: \n\t(1) Añadir sueldo (2) Imprimir sueldos (3) Mostrar sueldo medio" +
                    "\n\t(4) Subir sueldo (5) Subir sueldo a los sueldos debajo de la media (6) Subir sueldo a X empleados" +
                    "\n\t(7) Devolver codigo empleados con mayor y menor sueldo\n\t(0) salir");
            res = input.nextInt();

            switch (res) {
                case 1:
                    System.out.println("Da un sueldo: ");
                    res = input.nextInt();
                    addSueldo(res);
                    System.out.println("Se ha añadido el sueldo " + res);
                    break;
                case 2:
                    imprimirSueldos();
                    break;
                case 3:
                    System.out.println(calcularSueldoMedio());
                    break;
                case 6:
                    System.out.println("A que empleados quieres subir el sueldo: ");
                    subirSueldoXEmpleados(crearArr());
                default:
                    break;
            }

        } while (res != 0);

    }

    int[] crearArr() {
        Scanner input = new Scanner(System.in);
        int res = 0;
        int[] arr2 = new int[50];
        int pos2 = 0;

        do {
            System.out.println("\n\t\tSiguiente id. Pulsa -1 para terminar");
            res = input.nextInt();
            if (!(res < 0)) {
                arr2[pos2] = res;
                pos++;
            }
        } while (res != -1 && pos < 50);

        int[] arrRes = new int[pos];

        for (int i = 0; i < pos; i++) {
            arrRes[i] = arr2[i];
        }

        return arrRes;
    }

    void imprimirSueldos() {
        for (int i = 0; i < pos; i++) {
            System.out.println("Sueldo " + i + ": " + sueldoEmpleados[i]);
        }
    }


    void addSueldo(double sueldo) {
        if (pos < 50 && pos >= 0) {
            sueldoEmpleados[pos] = sueldo;
            pos++;
        }
    }

    double calcularSueldoMedio() {
        double res = 0;
        for (int i = 0; i < pos; i++) {
            res += (sueldoEmpleados[i] / pos);
        }
        return res;
    }

    void subirSueldo(int porcentaje) {
        for (int i = 0; i < pos; i++) {
            sueldoEmpleados[i] += (sueldoEmpleados[i] * (porcentaje / 100.0));
        }
    }

    void subirSueldoMenoresMedia(int porcentajeSubida) {
        double sueldoMedio = calcularSueldoMedio();
        for (int i = 0; i < pos; i++) {
            if (sueldoEmpleados[i] < sueldoMedio) {
                sueldoEmpleados[i] += (sueldoEmpleados[i] * (porcentajeSubida / 100.0));
            }
        }
    }

    void subirSueldoXEmpleados(int[] id) {
        for (int j = 0; j < id.length; j++) {
            sueldoEmpleados[id[j]] += (sueldoEmpleados[id[j]] * 0.1);
        }
    }

    double[] devolverCodigoEmpleadosMenoryMayorSueldo() {
        double[] res = new double[2];
        double sueldoMenor = 0;
        double sueldoMayor = 0;
        for (int i = 0; i < pos; i++) {
            if (sueldoMenor > sueldoEmpleados[i]) {
                sueldoMenor = sueldoEmpleados[i];
            }
            if (sueldoMayor < sueldoEmpleados[i]) {
                sueldoMayor = sueldoEmpleados[i];
            }
        }
        res[0] = sueldoMenor;
        res[1] = sueldoMayor;
        return res;
    }
}
