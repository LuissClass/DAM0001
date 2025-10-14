public class CirculoA11 {
    PuntoA5 centro;
    double radio;

    public CirculoA11(double radio, PuntoA5 centro) {
        this.centro = centro;
        this.radio = radio;
    }

    public CirculoA11(int radio) {
        this.radio = radio;
        centro = new PuntoA5(0, 0);
    }

    void imprimirAtributos() {
        System.out.println("Punto central: " + centro.mostrarPunto() + "\nRadio: " + radio + "u");
    }

    void imprimirPerimetro() {
        System.out.println(2*Math.PI*radio);
    }

    static boolean seTocan(CirculoA11 c1, CirculoA11 c2) {
        double distanciaCentros = PuntoA5.distanciaEntrePuntos(c1.centro, c2.centro);
        double sumaRadios = c1.radio + c2.radio;
        return !(distanciaCentros >= sumaRadios);
    }

    void moverCentroEnEjeX(double paso) {
        centro.moverX(paso);
    }

    public static void main(String[] args) {
        CirculoA11 circuloRedondo = new CirculoA11(4);
        circuloRedondo.imprimirAtributos();
        circuloRedondo.imprimirPerimetro();

        System.out.println();

        CirculoA11 circuloCircular = new CirculoA11(2, new PuntoA5(5,5));
        circuloCircular.imprimirAtributos();

        System.out.println();
        System.out.println("Se tocan? " + seTocan(circuloCircular, circuloRedondo));

        System.out.println("[El circulo redondo se ha movido]");
        circuloRedondo.moverCentroEnEjeX(3);
        circuloRedondo.imprimirAtributos();

        System.out.println();
        System.out.println("Se tocan? " + seTocan(circuloCircular, circuloRedondo) + "\n");


    }
}
