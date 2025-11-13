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
    private Monedas monedasCambio;
    Scanner input = new Scanner(System.in);

    private final Monedas monedasEnMaquina = new Monedas();

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

        if (hayCompra()) { // TODO. ¿Y QUE PASA SI NO HAY MONEDAS EN LA MAQUINA?
            darCambio();
            servirBebida();
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
        monedasBebida.calcularSumasEurosYCentimos();
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
        monedasIntroducidas.calcularSumasEurosYCentimos();
        dineroIntroducido = monedasIntroducidas.calcularDinero();
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
        if (esDineroSuficiente() && hayBebida() && hayCambio()) {
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
        monedasEnMaquina.setCentimo(10);
        monedasEnMaquina.setDosCentimos(10);
        monedasEnMaquina.setCincoCentimos(10);
        monedasEnMaquina.setDiezCentimos(10);
        monedasEnMaquina.setVeinteCentimos(10);
        monedasEnMaquina.setCincuentaCentimos(10);
        monedasEnMaquina.setUnEuro(10);
        monedasEnMaquina.setDosEuros(10);
        monedasEnMaquina.calcularSumasEurosYCentimos();
    }

    void imprimirBebida() {
        System.out.println(">>>SE HA ENTREGADO BEBIDA '" + elegirBebida().getNombre() + "'");
    }

    void darCambio() {
        retirarMonedasDeMaquina(getMonedasCambio());
        imprimirCambio();
    }

    void imprimirCambio() {
        System.out.println(">>>SE HA ENTREGADO " + getMonedasCambio().calcularDinero() + "€ DE CAMBIO");
    }

    void calcularMonedasCambio() {
        monedasCambio = monedasIntroducidas.calcularDiferenciaDeMonedas(monedasBebida);
    }

    public Monedas getMonedasCambio() {
        return monedasCambio;
    }

    void recibirDinero() {
        monedasEnMaquina.setCentimo(monedasEnMaquina.getCentimo() + monedasIntroducidas.getCentimo());
        monedasEnMaquina.setDosCentimos(monedasEnMaquina.getDosCentimos() + monedasIntroducidas.getDosCentimos());
        monedasEnMaquina.setCincoCentimos(monedasEnMaquina.getCincoCentimos() + monedasIntroducidas.getCincoCentimos());
        monedasEnMaquina.setDiezCentimos(monedasEnMaquina.getDiezCentimos() + monedasIntroducidas.getDiezCentimos());
        monedasEnMaquina.setVeinteCentimos(monedasEnMaquina.getVeinteCentimos() + monedasIntroducidas.getVeinteCentimos());
        monedasEnMaquina.setCincuentaCentimos(monedasEnMaquina.getCincuentaCentimos() + monedasIntroducidas.getCincuentaCentimos());
        monedasEnMaquina.setUnEuro(monedasEnMaquina.getUnEuro() + monedasIntroducidas.getUnEuro());
        monedasEnMaquina.setDosEuros(monedasEnMaquina.getDosEuros() + monedasIntroducidas.getDosEuros());
    }

    // TODO SI NO HAY CAMBIO, AL ELEGIR LA BEBIDA SE LE AVISARA AL USUARIO "INSERTE MONTO EXACTO". SI NO HACE CASO, DEVOLVERA EL DINERO INMEDIATAMENTE
    boolean hayCambio() {
        boolean res = false;
        calcularMonedasCambio();

        if (getMonedasCambio() != null) {
            int cambioEuros = getMonedasCambio().getSumaEuros();
            int cambioCentimos = getMonedasCambio().getSumaCentimos();

            if (monedasEnMaquina.calcularMonedas(cambioEuros, cambioCentimos) != null) {
                res = true;
            }
        }
        return res;
    }

    void retirarMonedasDeMaquina(Monedas monedas) {
        int eurosSacar = monedas.getSumaEuros();
        int centimosSacar = monedas.getSumaCentimos();

        Monedas monedasEspecificasSacar = monedasEnMaquina.calcularMonedas(eurosSacar, centimosSacar);

        monedasEnMaquina.restarDosEuros(monedasEspecificasSacar.getDosEuros());
        monedasEnMaquina.restarEuro(monedasEspecificasSacar.getUnEuro());
        monedasEnMaquina.restarCincuentaC(monedasEspecificasSacar.getCincuentaCentimos());
        monedasEnMaquina.restarVeinteC(monedasEspecificasSacar.getVeinteCentimos());
        monedasEnMaquina.restarDiezC(monedasEspecificasSacar.getDiezCentimos());
        monedasEnMaquina.restarCincoC(monedasEspecificasSacar.getCincoCentimos());
        monedasEnMaquina.restarDosC(monedasEspecificasSacar.getDosCentimos());
        monedasEnMaquina.restarCentimo(monedasEspecificasSacar.getCentimo());
    }

    void mostrarMonedas() {
        System.out.println("MONEDAS RESTANTES EN MAQUINA: ");
        System.out.println("\tcentimo: " + monedasEnMaquina.getCentimo());
        System.out.println("\tdosCentimos: " + monedasEnMaquina.getDosCentimos());
        System.out.println("\tcincoCentimos: " + monedasEnMaquina.getCincoCentimos());
        System.out.println("\tdiezCentimos: " + monedasEnMaquina.getDiezCentimos());
        System.out.println("\tveinteCentimos: " + monedasEnMaquina.getVeinteCentimos());
        System.out.println("\tcincuentaCentimos: " + monedasEnMaquina.getCincuentaCentimos());
        System.out.println("\tunEuro: " + monedasEnMaquina.getUnEuro());
        System.out.println("\tdosEuros: " + monedasEnMaquina.getDosEuros());
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

    void calcularSumasEurosYCentimos() {
        sumaCentimos = centimo + (dosCentimos * 2) + (cincoCentimos * 5) + (cincuentaCentimos * 50);
        sumaEuros = unEuro + (dosEuros * 2);

        while (sumaCentimos % 100 == 0 && sumaCentimos >= 100) {
            sumaEuros += 1;
            sumaCentimos -= 100;
        }
    }

    String calcularDinero() {
        return sumaEuros + "." + sumaCentimos;
    }

    /**
     * Metodo que calcula una cantidad de Monedas a partir de euros y centimos. Monedas que se encuentran en el monedero que invoca el metodo.
     */
    Monedas calcularMonedas(int euros, int centimos) {
        Monedas res = new Monedas();
        boolean faltanEuros = false;
        boolean faltanCentimos = false;

        while (((euros > 0 && centimos >= 0) || ((euros >= 0 && centimos > 0))) && !faltanEuros && !faltanCentimos) {
            if (euros >= 2 && dosEuros > 0) {
                res.sumarDosEuros(1);
                euros -= 2;
            } else if (euros >= 1 && unEuro > 0) {
                res.sumarEuro(1);
                euros -= 1;
            } else {
                faltanEuros = true;
            }

            if (centimos >= 50 && cincuentaCentimos > 0) {
                res.sumarCincuentaC(1);
                centimos -= 50;
            } else if (centimos >= 20 && veinteCentimos > 0) {
                res.sumarVeinteC(1);
                centimos -= 20;
            } else if (centimos >= 10 && diezCentimos > 0) {
                res.sumarDiezC(1);
                centimos -= 10;
            } else if (centimos >= 5 && cincoCentimos > 0) {
                res.sumarCincoC(1);
                centimos -= 5;
            } else if (centimos >= 2 && dosCentimos > 0) {
                res.sumarDosC(1);
                centimos -= 2;
            } else if (centimos >= 1 && centimo > 0) {
                res.sumarCentimo(1);
                centimos -= 1;
            } else {
                faltanCentimos = true;
            }
        }

        if (faltanEuros || faltanCentimos) {
            res = null;
        } else {
            res.calcularSumasEurosYCentimos();
        }
        return res;
    }

    boolean valeMasQue(Monedas monedas) {
        return sumaEuros >= monedas.sumaEuros && sumaCentimos >= monedas.sumaCentimos;
    }

    Monedas calcularDiferenciaDeMonedas(Monedas monedas) {
        Monedas res = new Monedas();
        int difEuros = sumaEuros - monedas.getSumaEuros();
        int difCent = sumaCentimos - monedas.getSumaCentimos();

        if (difEuros >= 0 && difCent >= 0) {
            while ((difEuros != 0 && difCent >= 0) || (difEuros >= 0 && difCent != 0)) {
                if (difEuros >= 2) {
                    res.sumarDosEuros(1);
                    difEuros -= 2;
                } else if (difEuros >= 1) {
                    res.sumarEuro(1);
                    difEuros -= 1;
                }

                if (difCent >= 50) {
                    res.sumarCincuentaC(1);
                    difCent -= 50;
                } else if (difCent >= 20) {
                    res.sumarVeinteC(1);
                    difCent -= 20;
                } else if (difCent >= 10) {
                    res.sumarDiezC(1);
                    difCent -= 10;
                } else if (difCent >= 5) {
                    res.sumarCincoC(1);
                    difCent -= 5;
                } else if (difCent >= 2) {
                    res.sumarDosC(1);
                    difCent -= 2;
                } else if (difCent >= 1) {
                    res.sumarCentimo(1);
                    difCent -= 1;
                }
            }
            res.calcularSumasEurosYCentimos();
        } else {
            res = null;
        }
        return res;
    }

    // Métodos para sumar
    void sumarCentimo(int cantidad) {
        centimo += cantidad;
    }

    void sumarDosC(int cantidad) {
        dosCentimos += cantidad;
    }

    void sumarCincoC(int cantidad) {
        cincoCentimos += cantidad;
    }

    void sumarDiezC(int cantidad) {
        diezCentimos += cantidad;
    }

    void sumarVeinteC(int cantidad) {
        veinteCentimos += cantidad;
    }

    void sumarCincuentaC(int cantidad) {
        cincuentaCentimos += cantidad;
    }

    void sumarEuro(int cantidad) {
        unEuro += cantidad;
    }

    void sumarDosEuros(int cantidad) {
        dosEuros += cantidad;
    }


    // Métodos para restar
    void restarCentimo(int cantidad) {
        centimo -= cantidad;
    }

    void restarDosC(int cantidad) {
        dosCentimos -= cantidad;
    }

    void restarCincoC(int cantidad) {
        cincoCentimos -= cantidad;
    }

    void restarDiezC(int cantidad) {
        diezCentimos -= cantidad;
    }

    void restarVeinteC(int cantidad) {
        veinteCentimos -= cantidad;
    }

    void restarCincuentaC(int cantidad) {
        cincuentaCentimos -= cantidad;
    }

    void restarEuro(int cantidad) {
        unEuro -= cantidad;
    }

    void restarDosEuros(int cantidad) {
        dosEuros -= cantidad;
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