package DAM1.EjsM;

import java.util.Scanner;

public class juegoE8 {
    public static void main(String[] args) {
        BarajaEspE8 baraja = new BarajaEspE8();
        float valorJugador = 0f;
        float valorOrdenador = 0f;
        int puntosJugador = 0;
        int puntosOrdenador = 0;

        baraja.barajear(100);

        for (int i = 0; i < 5; i++) {
            System.out.println(">CARTAS JUGADOR<");
            valorJugador = baraja.repartirCartas(valorJugador, 0);
            System.out.println(">CARTAS ORDENADOR<");
            valorOrdenador = baraja.repartirCartas(valorOrdenador, 1);

            if (valorJugador <= 7.5) {
                if ((7.5f - valorOrdenador > 0 && 7.5f - valorJugador < 7.5f - valorOrdenador) || (7.5f - valorOrdenador < 0)) {
                    System.out.println("PARTIDA PARA EL JUGADOR CON " + valorJugador + " PUNTOS");
                    System.out.println("Ptos ordenador: " + valorOrdenador);
                    puntosJugador++;
                } else if (valorOrdenador <= 7.5) {
                    System.out.println("PARTIDA PARA EL ORDENADOR CON " + valorOrdenador + " PUNTOS");
                    System.out.println("Ptos jugador: " + valorJugador);
                    puntosOrdenador++;

                }
            } else if (valorOrdenador <= 7.5) {
                System.out.println("PARTIDA PARA EL ORDENADOR CON " + valorOrdenador + " PUNTOS");
                System.out.println("Ptos jugador: " + valorJugador);
                puntosOrdenador++;
            } else {
                System.out.println("EMPATE!");
                System.out.println("Ptos jugador: " + valorJugador);
                System.out.println("Ptos ordenador: " + valorOrdenador);
            }

            valorJugador = 0;
            valorOrdenador = 0;
        }

        if (puntosJugador > puntosOrdenador) {
            System.out.println("Gana JUGADOR");
        } else {
            System.out.println("Gana ORDENADOR");
        }

    }
}

class CartaE8 {
    int num;
    String palo;

    public CartaE8(int num, String palo) {
        this.num = num;
        this.palo = palo;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return num + " de " + palo;
    }
}

class BarajaEspE8{
    CartaE8[] baraja = new CartaE8[40];
    int posBaraja = 0;

    BarajaEspE8() {
        for (int i = 1; i < 11; i++) {
            baraja[posBaraja] = new CartaE8(i, "oros");
            posBaraja++;
        }
        for (int i = 1; i < 11; i++) {
            baraja[posBaraja] = new CartaE8(i, "bastos");
            posBaraja++;
        }
        for (int i = 1; i < 11; i++) {
            baraja[posBaraja] = new CartaE8(i, "espadas");
            posBaraja++;
        }
        for (int i = 1; i < 11; i++) {
            baraja[posBaraja] = new CartaE8(i, "copas");
            posBaraja++;
        }
    }

    void barajear(int nIntercambios) {
        int posCarta1;
        int posCarta2;
        int intercambiosCont = 0;
        CartaE8 auxCarta;

        while(intercambiosCont < nIntercambios) {
            intercambiosCont++;
            posCarta1 = (int) (Math.random() * 40);
            posCarta2 = (int) (Math.random() * 40);

            auxCarta = baraja[posCarta1];
            baraja[posCarta1] = baraja[posCarta2];
            baraja[posCarta2] = baraja[posCarta1];
        }
    }

    float repartirCartas(float valor, int jugador) {
        float valorRepartido = 0f;
        int posCarta = 0;
        boolean repartirCarta = true;
        Scanner input = new Scanner(System.in);
        String res;
        boolean esPrimeraCarta = true;

        do {

            if (jugador == 0) {
                System.out.println("¿Quieres cartas? (Y/n)");
                res = input.nextLine();

                if (res.equalsIgnoreCase("n")) {
                    repartirCarta = false;
                } else if (!res.equalsIgnoreCase("n") && !res.equalsIgnoreCase("y")) {
                    System.out.println(">RESPUESTA INADECUADA.");
                    continue;
                }
            } else if (jugador == 1) {
                if (valor >= 7 ) {
                    repartirCarta = false;
                }
            }

            if (repartirCarta) {
                for (int i = 0; i < baraja.length; i++) {
                    if (baraja[i] != null) {
                        valorRepartido = baraja[i].getNum();
                        posCarta = i;
                        break;
                    }
                }


                if (valorRepartido == 0) {
                    break;
                }

                if (valorRepartido > 7) {
                    valorRepartido = 0.5f;
                }

                if (esPrimeraCarta && jugador == 1) {
                    System.out.println("Carta repartida: OCULTADA");
                    valor += valorRepartido;
                    baraja[posCarta] = null;
                    esPrimeraCarta = false;
                } else {
                    System.out.println("Carta repartida: " + baraja[posCarta]);
                    valor += valorRepartido;
                    baraja[posCarta] = null;
                }

                valorRepartido = 0;
            }
        } while (repartirCarta);

        return valor;
    }
}
