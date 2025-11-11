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
    private String dineroIntroducido;
    private Monedas monedasIntroducidas;
    private String dineroBebida;
    private Monedas monedasBebida;
    Scanner input = new Scanner(System.in);

    // Monedero de la maquina
    private final Monedas centimo = new Monedas();
    private final Monedas dosCentimos = new Monedas();
    private final Monedas cincoCentimos = new Monedas();
    private final Monedas diezCentimos = new Monedas();
    private final Monedas veinteCentimos = new Monedas();
    private final Monedas cincuentaCentimos = new Monedas();
    private final Monedas unEuro = new Monedas();
    private final Monedas dosEuros = new Monedas();

    public static void main(String[] args) {
        MaquinaRefrescosC7 maquina1 = new MaquinaRefrescosC7();
        maquina1.crearMonederoInicial();
        maquina1.crearStockInicial();
        System.out.println("--------------------------------------------------------------");
        maquina1.mostrarMonedas();
        maquina1.mostrarMenu();
        System.out.println("--------------------------------------------------------------");
        maquina1.mostrarBebidas();
        maquina1.mostrarMonedas();

    }

    void mostrarMenu() {
        mostrarBebidas();
        introducirCodigo();
        elegirBebida();
        introducirDinero();
        calcularCambio();

        if (hayCompra()) { // TODO. ¿Y QUE PASA SI NO HAY MONEDAS EN LA MAQUINA?
            servirBebida();
            darCambio();
        }
    }

    void mostrarBebidas() {
        System.out.println();
        System.out.println("BEBIDAS DISPONIBLES: ");

        if (espacio1 != null) {
            System.out.println("\t" + espacio1.getNombre() + " - codigo: " + espacio1.getCodigo());
        }
        if (espacio2 != null) {
            System.out.println("\t" + espacio2.getNombre() + " - codigo: " + espacio2.getCodigo());
        }
        if (espacio3 != null) {
            System.out.println("\t" + espacio3.getNombre() + " - codigo: " + espacio3.getCodigo());
        }
        if (espacio4 != null) {
            System.out.println("\t" + espacio4.getNombre() + " - codigo: " + espacio4.getCodigo());
        }
        if (espacio5 != null) {
            System.out.println("\t" + espacio5.getNombre() + " - codigo: " + espacio5.getCodigo());
        }
        if (espacio6 != null) {
            System.out.println("\t" + espacio6.getNombre() + " - codigo: " + espacio6.getCodigo());
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

        monedasBebida = bebida.getPrecio();
        dineroBebida = bebida.getPrecio().calcularDinero();
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

        System.out.println();
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
        dineroIntroducido = monedasIntroducidas.calcularDinero();
        System.out.println("ESTO ES EL DINERO >>>>>>>>>>>>>> " + dineroIntroducido);
        recibirDinero();
    }

    void introducirCodigo() {
        System.out.println("Introduce codigo: ");
        codigoIntroducido = input.nextLine();
    }

    boolean esDineroSuficiente() {
        return monedasIntroducidas.valeMasQue(monedasBebida);
    }

    boolean hayCompra() {
        if (esDineroSuficiente() && hayBebida()) {
            return true;
        }
        return false;
    }

    void servirBebida() {
        imprimirBebida();
        restarStock();
    }

    void restarStock() {
        if (elegirBebida() == espacio1) {
            espacio1 = null;
        } else if (elegirBebida() == espacio2) {
            espacio2 = null;
        } else if (elegirBebida() == espacio3) {
            espacio3 = null;
        } else if (elegirBebida() == espacio4) {
            espacio4 = null;
        } else if (elegirBebida() == espacio5) {
            espacio5 = null;
        } else if (elegirBebida() == espacio6) {
            espacio6 = null;
        }
    }

    void crearStockInicial() {
        espacio1 = new Bebida(new Monedas(0, 0, 0, 0, 0, 0, 1, 0), "Fanta Stick", "FSN9");
        espacio2 = new Bebida(new Monedas(0, 0, 0, 0, 0, 0, 0, 1), "Nuka Cola", "BUNK12");
        espacio3 = new Bebida(new Monedas(0, 0, 0, 0, 0, 0, 1, 1), "Agua del Everest", "AWWA");
        espacio4 = new Bebida(new Monedas(1, 0, 0, 0, 0, 0, 0, 7), "Agua Normal Sin Nada 100% Natural", "AA16");
        espacio5 = new Bebida(new Monedas(99, 0, 0, 0, 0, 0, 0, 7), "Mineral Water", "MW00");
        espacio6 = new Bebida(new Monedas(5, 0, 0, 0, 0, 0, 1, 0), "Alcohol 0% Alcohol", "A0A0");
    }

    void crearMonederoInicial() {
        centimo.setCentimo(10);
        dosCentimos.setDosCentimos(10);
        cincoCentimos.setCincoCentimos(10);
        diezCentimos.setDiezCentimos(10);
        veinteCentimos.setVeinteCentimos(10);
        cincuentaCentimos.setCincuentaCentimos(10);
        unEuro.setUnEuro(10);
        dosEuros.setDosEuros(10);
    }

    void imprimirBebida() {
        System.out.println("\nSE HA ENTREGADO BEBIDA '" + elegirBebida().getNombre() + "'");
    }

    void darCambio() {
        retirarMonedas();
        imprimirCambio();
    }

    void imprimirCambio() {
        System.out.println("SE HA ENTREGADO " + returnCambio() + "€ DE CAMBIO");
    }

    String returnCambio() {
        return monedasIntroducidas.calcularDiferenciaDeMonedas(monedasBebida).calcularDinero();
    }

    void recibirDinero() {
        centimo.setCentimo(centimo.getCentimo() + monedasIntroducidas.getCentimo());
        dosCentimos.setDosCentimos(dosCentimos.getDosCentimos() + monedasIntroducidas.getDosCentimos());
        cincoCentimos.setCincoCentimos(cincoCentimos.getCincoCentimos() + monedasIntroducidas.getCincoCentimos());
        diezCentimos.setDiezCentimos(diezCentimos.getDiezCentimos() + monedasIntroducidas.getDiezCentimos());
        veinteCentimos.setVeinteCentimos(veinteCentimos.getVeinteCentimos() + monedasIntroducidas.getVeinteCentimos());
        cincuentaCentimos.setCincuentaCentimos(cincuentaCentimos.getCincuentaCentimos() + monedasIntroducidas.getCincuentaCentimos());
        unEuro.setUnEuro(unEuro.getUnEuro() + monedasIntroducidas.getUnEuro());
        dosEuros.setDosEuros(dosEuros.getDosEuros() + monedasIntroducidas.getDosEuros());
    }

    // TODO SI NO HAY CAMBIO, AL ELEGIR LA BEBIDA SE LE AVISARA AL USUARIO "INSERTE MONTO EXACTO". SI NO HACE CASO, DEVOLVERA EL DINERO INMEDIATAMENTE
    void retirarMonedas() {
        Monedas cambio = monedasIntroducidas.calcularDiferenciaDeMonedas(monedasBebida);
        double devuelto = 0;

        while (devuelto != cambio) {
            if (dosEuros.getDosEuros() >= 1) {
                dosEuros.setDosEuros(dosEuros.getDosEuros() - 1);
                devuelto += 2;
            }
            if (unEuro.getUnEuro() >= 1) {
                unEuro.setUnEuro(unEuro.getUnEuro() - 1);
                devuelto += 1;
            }
            if (cincuentaCentimos.getCincuentaCentimos() >= 1) {
                cincuentaCentimos.setCincuentaCentimos(cincuentaCentimos.getCincuentaCentimos() - 1);
                devuelto += 0.5;
            }
            if (veinteCentimos.getVeinteCentimos() >= 1) {
                veinteCentimos.setVeinteCentimos(veinteCentimos.getVeinteCentimos() - 1);
                devuelto += 0.2;
            }
            if (diezCentimos.getDiezCentimos() >= 1) {
                diezCentimos.setDiezCentimos(diezCentimos.getDiezCentimos() - 1);
                devuelto += 0.1;
            }
            if (dosCentimos.getDosCentimos() >= 1) {
                dosCentimos.setDosCentimos(dosCentimos.getDosCentimos() - 1);
                devuelto += 0.02;
            }
            if (centimo.getCentimo() >= 1) {
                centimo.setCentimo(centimo.getCentimo() - 1);
                devuelto += 0.01;
            }
        }
    }

    void mostrarMonedas() {
        System.out.println("MONEDAS RESTANTES EN MAQUINA: ");
        System.out.println("\tcentimo: " + centimo.getCentimo());
        System.out.println("\tdosCentimos: " + dosCentimos.getDosCentimos());
        System.out.println("\tcincoCentimos: " + cincoCentimos.getCincoCentimos());
        System.out.println("\tdiezCentimos: " + diezCentimos.getDiezCentimos());
        System.out.println("\tveinteCentimos: " + veinteCentimos.getVeinteCentimos());
        System.out.println("\tcincuentaCentimos: " + cincuentaCentimos.getCincuentaCentimos());
        System.out.println("\tunEuro: " + unEuro.getUnEuro());
        System.out.println("\tdosEuros: " + dosEuros.getDosEuros());
    }
}

class Bebida {
    Monedas precio;
    String nombre;
    String codigo;

    public Bebida(Monedas precio, String nombre, String codigo) {
        this.precio = precio;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Monedas getPrecio() {
        return precio;
    }
}


class Monedas {
    private int centimo = 0;
    private int dosCentimos = 0;
    private int cincoCentimos = 0;
    private int diezCentimos = 0;
    private int veinteCentimos = 0;
    private int cincuentaCentimos = 0;
    private int unEuro = 0;
    private int dosEuros = 0;

    private int sumaEuros;
    private int sumaCentimos;

    public Monedas() {

    }

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

    String calcularDinero() {
        sumaCentimos = centimo + (dosCentimos * 2) + (cincoCentimos * 5) + (cincuentaCentimos * 50);
        sumaEuros = unEuro + (dosEuros * 2);

        while (sumaCentimos % 100 == 0 && sumaCentimos >= 100) {
            sumaEuros += 1;
            sumaCentimos -= 100;
        }
        return sumaEuros + "." + sumaCentimos;
    }

    boolean valeMasQue(Monedas monedasBebida) {
        return sumaEuros >= monedasBebida.sumaEuros && sumaCentimos > monedasBebida.sumaCentimos;
    }

    Monedas calcularDiferenciaDeMonedas(Monedas monedasBebida) {
        return new Monedas();
    }

    public int getSumaCentimos() {
        return sumaCentimos;
    }

    public int getSumaEuros() {
        return sumaEuros;
    }

    public int getCentimo() {
        return centimo;
    }

    public int getDosCentimos() {
        return dosCentimos;
    }

    public int getCincoCentimos() {
        return cincoCentimos;
    }

    public int getDiezCentimos() {
        return diezCentimos;
    }

    public int getVeinteCentimos() {
        return veinteCentimos;
    }

    public int getCincuentaCentimos() {
        return cincuentaCentimos;
    }

    public int getUnEuro() {
        return unEuro;
    }

    public int getDosEuros() {
        return dosEuros;
    }

    public void setCentimo(int centimo) {
        this.centimo = centimo;
    }

    public void setDosCentimos(int dosCentimos) {
        this.dosCentimos = dosCentimos;
    }

    public void setCincoCentimos(int cincoCentimos) {
        this.cincoCentimos = cincoCentimos;
    }

    public void setDiezCentimos(int diezCentimos) {
        this.diezCentimos = diezCentimos;
    }

    public void setVeinteCentimos(int veinteCentimos) {
        this.veinteCentimos = veinteCentimos;
    }

    public void setCincuentaCentimos(int cincuentaCentimos) {
        this.cincuentaCentimos = cincuentaCentimos;
    }

    public void setUnEuro(int unEuro) {
        this.unEuro = unEuro;
    }

    public void setDosEuros(int dosEuros) {
        this.dosEuros = dosEuros;
    }
}
