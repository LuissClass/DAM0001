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
    private AsientoE6[] asientos = new AsientoE6[23];
    private int posAsientos = 0;

    private void menu(){
        iniciarBus();
        String res;
        do {
             System.out.println("\t(1) Reservar\n\t(2) Reserva doble\n\t(3) Cancelar Reserva\n\t(4) Mostrar Reservas\n\t(0) Salir");
             res = input.nextLine();
            switch (res) {
                case "1" -> reservar();
                case "2" -> reservaDoble();
                case "3" -> cancelarReserva();
                case "4" -> mostrarReservas();
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

        System.out.println("Nombre de la reserva: ");
        String nombre = input.nextLine();

        int[] asiento = pedirAsiento();
        int fila = asiento[0];
        int col = asiento[1];

        if (fila < bus.length && col < bus[fila].length) {
            if (isAsientoDisponible(fila, col)) {
                addCliente(nombre, fila, col);
                System.out.println(">EL ASIENTO SE HA RESERVADO CORRECTAMENTE");
            } else {
                System.out.println(">EL ASIENTO NO ESTA DISPONIBLE");
            }
        } else {
            System.out.println(">>EL ASIENTO NO EXISTE");
        }
    }

    private int[] pedirAsiento() {
        boolean esFormatoCorrecto;
        int fila = 0;
        int col = 0;
        int[] res = new int[2];
        do {
            System.out.println("Indica el asiento (1-13/0-1): ");
            String asientoStr = input.nextLine();

            try {
                fila = Integer.parseInt(asientoStr.split("/")[0]);
                col = Integer.parseInt(asientoStr.split("/")[1]);
                esFormatoCorrecto = true;
                res[0] = fila;
                res[1] = col;
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println(">>>Formato incorrecto! Ej: '8/0'\n");
                esFormatoCorrecto = false;
            } catch (NumberFormatException nfe) {
                System.out.println(">>>Formato incorrecto! Debes usar numeros y un guion solamente!\n");
                esFormatoCorrecto = false;
            }
        } while (!esFormatoCorrecto);
        return res;
    }

    private boolean isAsientoDisponible(int fila, int col) {
        if (bus[fila][col] != "[X]" && bus[fila][col] != "[=]" && bus[fila][col] != "[0]") {
            return true;
        }
        return false;
    }

    private void addCliente(String name, int fila, int col) {
        bus[fila][col] = "[X]";
        asientos[posAsientos] = new AsientoE6(name, fila, col);
        posAsientos++;
    }

    private void reservaDoble() {
        boolean hayAsientos = false;
        int fila = 0;

        for (int i = 0; i < bus.length; i++) {
            if (bus[i][0].equals("[ ]") && bus[i][1].equals("[ ]")) {
                fila = i;
                hayAsientos = true;
                break;
            }
        }

        if (hayAsientos) {
            System.out.println("Nombre de la reserva: ");
            String nombre = input.nextLine();
            addCliente(nombre, fila);
            System.out.println(">SE HA HECHO LA RESERVA DOBLE CORRECTAMENTE");
        }
    }

    private void addCliente(String name, int fila) {
        bus[fila][0] = "[X]";
        bus[fila][1] = "[X]";
        asientos[posAsientos] = new AsientoE6(name, fila);
        posAsientos++;
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

    private void cancelarReserva() {
        int[] asiento = pedirAsiento();
        int fila = asiento[0];
        int col = asiento[1];
        int posAsientoEliminar = 0;
        boolean seCancelaReserva = false;

        if (!isAsientoDisponible(fila, col)) {
            System.out.println("Nombre de la reserva: ");
            String nombre = input.nextLine();

            for (int i=0; i < posAsientos; i++) {
                AsientoE6 a = asientos[i];
                if (a.getFila() == fila && a.getCol() == col) {
                    if (a.getCliente().equalsIgnoreCase(nombre)) {
                        posAsientoEliminar = i;
                        seCancelaReserva = true;
                    }
                }
            }

            if (seCancelaReserva) {
                asientos[posAsientoEliminar] = null;
                bus[fila][col] = "[ ]";
                System.out.println("SE HA CANCELADO LA RESERVA CON EXITO");
            }
        }
    }
}

class AsientoE6{
    private String cliente;
    private int fila;
    private int col;

    public AsientoE6(String cliente, int fila) {
        this.cliente = cliente;
        this.fila = fila;
    }

    public AsientoE6(String cliente, int fila, int col) {
        this.cliente = cliente;
        this.fila = fila;
        this.col=col;
    }

    public String getCliente() {
        return cliente;
    }

    public int getCol() {
        return col;
    }

    public int getFila() {
        return fila;
    }
}
