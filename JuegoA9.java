/*
Se desea hacer una aplicación de combate entre diferentes personajes.

Cada Personaje tiene como atributos, su nombre, su Posición en el tablero (x e y), su porcentaje de vida (entre 0 y 100), su fuerza (entre 0 y 50 ) y dos armas (que se pasan en el constructor).
También se dispone del Arma que tiene como características, su nombre y su porcentaje de aumento de fuerza.   Si un personaje tiene una fuerza de 30 y un arma con porcentaje de aumento de 40% cuando el personaje luche tendrá una fuerza de 30+ 30*0,40 = 42.
Los personajes pueden realizar las siguientes acciones, que deberán codificarse con los correspondientes métodos.

Moverse en una dirección (sólo en horizontal o sólo en vertical) un determinado número de CASILLAS. El metodo recibirá la dirección y el número de CASILLAS. Está acción modificará su posición.
Cambiar el arma disponible por otra. Se pasará como parámetro el nuevo arma y sustituirá a la que lleve más tiempo asociada al personaje. Si el personaje tiene menos de 2 armas no se sustituirá ninguna
Luchar: se realizará una lucha entre 2 jugadores, el resultado será aleatorio, pero tendrá en cuenta la fuerza de la que dispone (incluida la aumentada por el arma) cada uno de ellos para calcular el resultado. Como resultado de la lucha se decrementará la vida del jugador perdedor en un valor aleatorio entre 5 y 10 unidades.  Para iniciar la lucha se comprobará que la distancia entre los dos personajes no es mayor de 5. Como resultado de la lucha se devolverá el personaje ganador o null si no se ha podido luchar.
Mostrar Estado. Mostrará en pantalla todos los atributos del jugador, incluidas las armas que posee y las características de estas. Si su vida es inferior a 25 pondrá HERIDO y si es 0 pondrá MUERTO
Realizar un programa principal, en la clase Juego, que cree varias armas y varios jugadores y pruebe el funcionamiento de los métodos anteriores. */

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

public class JuegoA9 {
    public static void main(String[] args) throws IOException {
        Personaje p1 = new Personaje("Buck", 50, 10, new Posicion(0, 0), new Arma("Espada filosa ancestral", 50), new Arma("Mamba negra", 75));
        Personaje p2 = new Personaje("Felipe Garcia", 30, 15, new Posicion(7, 0), new Arma("Dragon Slayer", 200), new Arma("Claymore", 100));

        p1.mostrarEstado();
        System.out.println();
        p2.mostrarEstado();
        System.out.println("\n===================================[Cambiar el arma de Buck]\n");
        p1.cambiarElArmaDisponible(new Arma("Katana Hattori Hanzo", 170));
        p1.mostrarEstado();
        System.out.println("\n===================================[Iniciar lucha]\n");
        p1.luchar(p2);

        System.out.println("\n===================================[Mover a Federico]\n");
        p2.moverEnUnaDireccion();
        p2.mostrarEstado();

        System.out.println("\n===================================[Iniciar Varias luchas]\n");
        p1.luchar(p2);
        p1.luchar(p2);
        p1.luchar(p2);
        p1.luchar(p2);

        p1.luchar(p2);
        p1.luchar(p2);
        p1.luchar(p2);
        p1.luchar(p2);
        p1.luchar(p2);
        p1.luchar(p2);

        System.out.println();
        p1.mostrarEstado();
        System.out.println();
        p2.mostrarEstado();

    }

}

class Personaje {

    private final static int CASILLAS = 10;
    private final static int FUERZA_MAX = 50;
    private final static int VIDA_MAX = 100;


    private String name;
    private int vida;
    private int fuerza;
    private Posicion pos;
    private Arma armaIzq;
    private Arma armaDer;
    private int fuerzaAumentada;

    Teclado t = new Teclado();


    public Personaje(String name, int vida, int fuerza, Posicion pos, Arma armaIzq, Arma armaDer) {
        this.name = name;
        this.vida = vida > VIDA_MAX || vida < 0 ? VIDA_MAX : vida;
        this.fuerza = fuerza > FUERZA_MAX || fuerza < 0 ? FUERZA_MAX : fuerza;
        this.pos = pos;
        this.armaIzq = armaIzq;
        this.armaDer = armaDer;
        actualizarFuerza();
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    void actualizarFuerza() {
        fuerzaAumentada = fuerza + (int) (fuerza * (armaIzq.getPorcentajeAumentoFuerza() / 100)) + (int) (fuerza * (armaDer.getPorcentajeAumentoFuerza() / 100));
        fuerzaAumentada = fuerzaAumentada > FUERZA_MAX ? FUERZA_MAX : fuerzaAumentada;
    }

    void moverEnUnaDireccion() throws IOException {
        char res;
        int casillasIzq;
        int casillasDer;
        int casillasArriba;
        int casillasAbajo;

        System.out.println("¿En que direccion se va a mover " + name + "?");
        System.out.println("Izq (a) - Der (d) - Arriba (w) + Abajo (s)");
        res = t.leerChar();

        casillasIzq = res == 'a' ? CASILLAS : 0;
        casillasDer = res == 'd' ? CASILLAS : 0;
        casillasArriba = res == 'w' ? CASILLAS : 0;
        casillasAbajo = res == 's' ? CASILLAS : 0;

        pos.moverIzq(casillasIzq);
        pos.moverDer(casillasDer);
        pos.moverArriba(casillasArriba);
        pos.moverAbajo(casillasAbajo);
    }

    void cambiarElArmaDisponible(Arma arma) {
        // Si el personaje tiene menos de dos armas no se sustituira ninguna
        // (nunca se va a ejecutar porque no hay forma de que el personaje tenga una sola arma)
        armaDer = armaDer == null && armaIzq != arma ? arma : armaDer;
        armaIzq = armaIzq == null && armaDer != arma ? arma : armaIzq;

        // El armaIzq pasa a ser armaDer y arma es la nueva ArmaIzq
        armaDer = armaIzq != null ? armaIzq : armaDer;
        armaIzq = armaDer != null ? arma : armaIzq;
        actualizarFuerza();
    }

    Personaje luchar(Personaje p2) {
        int damage = ((int) Math.random() * 5) + 5; // Valor entre 5 y 10
        int vida1;
        int vida2;
        Personaje p1 = this;
        int distancia = (int) (Posicion.discantiaEntrePuntos(p1.pos, p2.pos) - 0.5); // El 0.5 es un margen de error
        boolean hayLucha;

        hayLucha = distancia <= 5;

        Personaje elMasFuerte = p1.fuerzaAumentada > p2.fuerzaAumentada ? p1 : p2;

        // El mas fuerte tiene mas posibilidades de ganar
        boolean ganaElMasFuerte1 = (int) (Math.random() * 2) == 1;
        boolean ganaElMasFuerte2 = (int) (Math.random() * 2) == 1;
        boolean ganaElMasFuerte = ganaElMasFuerte1 || ganaElMasFuerte2;

        vida1 = p1 == elMasFuerte && ganaElMasFuerte || p1 != elMasFuerte && !ganaElMasFuerte ? p1.vida : p1.vida - damage;
        vida2 = p2 == elMasFuerte && ganaElMasFuerte || p2 != elMasFuerte && !ganaElMasFuerte ? p2.vida : p2.vida - damage;

        // Si recibe mas daño que la vida que tiene, pasa a tener 0 de vida
        vida1 = vida1 < 0 ? 0 : vida1;
        vida2 = vida2 < 0 ? 0 : vida2;

        // Si nunca se pudo luchar
        vida1 = hayLucha ? vida1 : p1.vida;
        vida2 = hayLucha ? vida2 : p2.vida;

        p1.setVida(vida1);
        p2.setVida(vida2);

        // Si se pudo luchar retorna res2, caso contrario retorna res1
        Personaje res2 = p1.vida > p2.vida ? p1 : p2;
        Personaje res1 = null;
        String mensaje = hayLucha? "[Encuentro finalizado] Vida " +  p1.name + ": " + p1.vida + " - Vida " + p2.name + ": " + p2.vida :"["+p1.name+" NO HA PODIDO INICIAR EL ENFRENTAMIENTO CON " + p2.name + " PORQUE SE ENCUENTRAN A " + distancia + "m DE DISTANCIA]";
        System.out.println(mensaje);
        return hayLucha ? res2 : res1;
    }

    void mostrarEstado() {
        String estadoSalud;
        String estadoVida;
        estadoSalud = vida > 25 ? "(SANO)" : "(HERIDO)";
        estadoVida = vida == 0 ? "(MUERTO)" : estadoSalud;

        System.out.println("Nombre: " + name + "\nVida: " + vida + " " + estadoVida
                + "\nFuerza: " + fuerza + "\nArma mano izquierda: " + armaIzq + "\nArma mano derecha: " + armaDer
                + "\nFuerza aumentada: " + fuerzaAumentada
                + "\n>>Posicion: " + pos.mostrarPunto());
    }
}

class Posicion {
    private double x;
    private double y;

    Posicion(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moverIzq(double incremento) {
        x -= incremento;
    }

    public void moverDer(double incremento) {
        x += incremento;
    }

    public void moverAbajo(double incremento) {
        y -= incremento;
    }

    public void moverArriba(double incremento) {
        y += incremento;
    }

    public static double discantiaEntrePuntos(Posicion pt1, Posicion pt2) {
        // Pitagoras: hipotenua = raiz de suma de catetos al cuadrado
        double cateto1 = pt2.x - pt1.x;
        double cateto2 = pt2.y - pt1.y;
        return Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
    }

    public String mostrarPunto() {
        return "x:" + x + " - y:" + y;
    }

}

class Arma {
    String name;
    private double porcentajeAumentoFuerza;

    public Arma(String name, double porcentajeAumentoFuerza) {
        this.name = name;
        this.porcentajeAumentoFuerza = porcentajeAumentoFuerza;
    }

    public String getName() {
        return name;
    }

    public double getPorcentajeAumentoFuerza() {
        return porcentajeAumentoFuerza;
    }

    @Override
    public String toString() {
        return "\n\tNombre: "+name+"\n\tPorcentaje de aumento de fuerza: " + porcentajeAumentoFuerza;
    }
}