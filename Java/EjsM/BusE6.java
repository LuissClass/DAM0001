package DAM1.EjsM;

import java.util.Arrays;
import java.util.Scanner;

public class BusE6 {
    public static void main(String[] args) {
        BusE6 e6 = new BusE6();

        e6.menu();
    }

    private final String[][] bus  = new String[14][2];
    Scanner input = new Scanner(System.in);
    private String[] clientesHoy = new String[0];

    private void menu(){
        iniciarBus();
        String res;
        do {
             System.out.println("(1) Reservar\n(3) Mostrar Reservas\n(0) Salir");
             res = input.nextLine();
            switch (res) {
                case "1" -> reservar();
                case "3" -> mostrarReservas();
            }
        } while (!res.equals("0"));
    }

    private void iniciarBus() {
        for (int i = 0; i < bus.length; i++) {
            Arrays.fill(bus[i], "[ ]");
        }
        bus[0][0] = "[0]";
        bus[0][1] = "[=]";
        bus[7][1] = "[=]";
    }

    private void reservar() {
        System.out.println("Asiento (1-13/0-1): ");
        String asientoStr = input.nextLine();

        int fila = Integer.parseInt(asientoStr.split("/")[0]);
        int col = Integer.parseInt(asientoStr.split("/")[1]);

        if (fila < bus.length && col < bus[fila].length) {
            bus[fila][col] = "[X]";
            System.out.println("EL ASIENTO SE HA RESERVADO CORRECTAMENTE");

            if (isAsientoDisponible()) {

            }
        } else {
            System.out.println("EL ASIENTO NO EXISTE");
        }

    }

    private void addCliente(String name) {
        clientesHoy = new String[clientesHoy.length + 1];
        clientesHoy[clientesHoy.length - 1] = name;
    }

    private void mostrarReservas() {
        String planoBus = "";
        for (int i = 0; i < bus.length; i++) {
            planoBus += i + " ";
            for (int j = 0; j < bus[i].length; j++) {
                planoBus += bus[i][j];
            }
            planoBus += "\n";
        }

        System.out.println(planoBus);
    }


}
