package DAM1;

import java.util.Scanner;

public class MaquinaRefrescosC7 {
    private Bebida espacio1;
    private Bebida espacio2;
    private Bebida espacio3;
    private Bebida espacio4;
    private Bebida espacio5;
    private Bebida espacio6;
    private String codigoIntroducido;
    private double dineroIntroducido;
    private Monedas monedasIntroducidas;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        MaquinaRefrescosC7 maquina1 = new MaquinaRefrescosC7();
        maquina1.crearStockInicial();
        maquina1.mostrarMenu();

    }

    void mostrarMenu() {
        elegirBebida();
        introducirDinero();

        if (hayCompra()) {
            servirBebida();
            devolverCambio();
        }
    }

    Bebida elegirBebida() {
        Bebida bebida = null;
        String codigo = codigoIntroducido;

        if (codigo.equals(espacio1.getCodigo())) {
            bebida = espacio1;
        } else if (codigo.equals(espacio2.getCodigo())) {
            bebida = espacio2;
        } else if (codigo.equals(espacio3.getCodigo())) {
            bebida = espacio3;
        } else if (codigo.equals(espacio4.getCodigo())) {
            bebida = espacio4;
        } else if (codigo.equals(espacio5.getCodigo())) {
            bebida = espacio5;
        } else if (codigo.equals(espacio6.getCodigo())) {
            bebida = espacio6;
        }

        return bebida;
    }

    boolean hayBebida() {
        return elegirBebida() != null;
    }

    void introducirDinero() {
        int centimo;
        int dosCentimos;
        int cincoCentimos;
        int diezCentimos;
        int veinteCentimos;
        int cincuentaCentimos;
        int unEuro;
        int dosEuros;

        System.out.println("INTRODUCE MONEDAS DE 2 EUROS: ");
        dosEuros = input.nextInt();
        System.out.println("INTRODUCE MONEDAS DE 1 EURO: ");
        unEuro = input.nextInt();
        System.out.println("INTRODUCE MONEDAS DE 50 CENTIMOS: ");
        cincuentaCentimos = input.nextInt();
        System.out.println("INTRODUCE MONEDAS DE 20 CENTIMOS: ");
        veinteCentimos = input.nextInt();
        System.out.println("INTRODUCE MONEDAS DE 10 CENTIMOS: ");
        diezCentimos = input.nextInt();
        System.out.println("INTRODUCE MONEDAS DE 5 CENTIMO: ");
        cincoCentimos = input.nextInt();
        System.out.println("INTRODUCE MONEDAS DE 2 CENTIMO: ");
        dosCentimos = input.nextInt();
        System.out.println("INTRODUCE MONEDAS DE 1 CENTIMO: ");
        centimo = input.nextInt();

        monedasIntroducidas = new Monedas(centimo, dosCentimos, cincoCentimos, diezCentimos, veinteCentimos, cincuentaCentimos, unEuro, dosEuros);
    }

    boolean esDineroSuficiente() {
        monedasIntroducidas.calcularDinero();
        if (dineroIntroducido >= elegirBebida().getPrecio().calcularDinero()) {
            return true;
        }
        return false;
    }

    boolean hayCompra() {
        if (esDineroSuficiente() && hayBebida()) {
            return true;
        }
        return false;
    }


    public void setCodigoIntroducido(String codigoIntroducido) {
        this.codigoIntroducido = codigoIntroducido;
    }

    public void setDineroIntroducido(float dineroIntroducido) {
        this.dineroIntroducido = dineroIntroducido;
    }

    void servirBebida() {
        restarStock();
        imprimirBebida();
        imprimirCambio();
    }

    void restarStock() {

    }

    void crearStockInicial() {
        espacio1 = new Bebida(new Monedas(0, 0, 0, 0, 0, 0, 1, 0), "Fanta Stick", "FSN9");
        espacio2 = new Bebida(new Monedas(0, 0, 0, 0, 0, 0, 0, 1), "Nuka Cola", "BUNK12");
        espacio3 = new Bebida(new Monedas(0, 0, 0, 0, 0, 0, 1, 1), "Agua del Everest", "AWWA");
        espacio4 = new Bebida(new Monedas(1, 0, 0, 0, 0, 0, 0, 7), "Agua Normal Sin Nada 100% Natural", "AA16");
        espacio5 = new Bebida(new Monedas(99, 0, 0, 0, 0, 0, 0, 7), "Mineral Water", "MW00");
        espacio6 = new Bebida(new Monedas(5, 0, 0, 0, 0, 0, 1, 0), "Alcohol 0% Alcohol", "A0A0");
    }

    void imprimirBebida() {
        System.out.println("Toma tu bebida: " + elegirBebida());
    }

    void imprimirCambio() {
        System.out.println("Toma tu cambio: " + devolverCambio());
    }

    float devolverCambio() {
        return 0;
    }
}

class Bebida {
    Monedas precio;
    String nombre;
    String codigo;

    public Bebida() {

    }

    public Bebida(Monedas precio, String nombre, String codigo) {
        this.precio = precio;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public Monedas getPrecio() {
        return precio;
    }
}


class Monedas {
    int centimo;
    int dosCentimos;
    int cincoCentimos;
    int diezCentimos;
    int veinteCentimos;
    int cincuentaCentimos;
    int unEuro;
    int dosEuros;

    public Monedas(int centimo, int dosCentimos, int cincoCentimos, int diezCentimos, int veinteCentimos, int cincuentaCentimos, int unEuro, int dosEuros) {
        this.centimo = centimo;
        this.dosCentimos = dosCentimos;
        this.cincoCentimos = cincoCentimos;
        this.diezCentimos = diezCentimos;
        this.veinteCentimos = veinteCentimos;
        this.cincuentaCentimos = cincuentaCentimos;
        this.unEuro = unEuro;
        this.dosEuros = dosEuros;
    }

    double calcularDinero() {
        int sumaCentimos;
        int sumaEuros;
        double dinero = 0;

        sumaCentimos = centimo + dosCentimos + cincoCentimos;
        sumaEuros = unEuro + dosEuros;

        while (sumaCentimos % 100 == 0) {
            sumaEuros += 1;
            sumaCentimos -= 100;
        }
        dinero = (sumaEuros * 1.0) + (sumaCentimos / 100.0);
        System.out.println(dinero);
        return dinero;
    }
}