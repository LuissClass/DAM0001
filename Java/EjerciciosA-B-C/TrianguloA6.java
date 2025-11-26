public class TrianguloA6 {
    private PuntoA5 vert1;
    private PuntoA5 vert2;
    private PuntoA5 vert3;
    double lado1;
    double lado2;
    double lado3;
    boolean hayPerimetro = false;

    TrianguloA6 (PuntoA5 vert1, PuntoA5 vert2) {
        this.vert1 = vert1;
        this.vert2 = vert2;
        vert3 = new PuntoA5(0,0);
    }

    TrianguloA6 (PuntoA5 vert1, PuntoA5 vert2, PuntoA5 vert3) {
        this.vert1 = vert1;
        this.vert2 = vert2;
        this.vert3 = vert3;
    }

    public double calcularPerimetro() {
        lado1 = PuntoA5.distanciaEntrePuntos(vert1,vert2);
        lado2 = PuntoA5.distanciaEntrePuntos(vert2,vert3);
        lado3 = PuntoA5.distanciaEntrePuntos(vert3,vert1);

        return lado1+lado2+lado3;
    }

    public void moveXs(double incremento){
        vert1.moverX(incremento);
        vert2.moverX(incremento);
        vert3.moverX(incremento);
    }

    public boolean esEquilatero() {
        this.calcularPerimetro(); // Para evitar errores
        return lado1 == lado2 && lado2 == lado3;
    }

    public void mostrarDatos() {
        System.out.println("Vert1 (" + vert1.getX() + ", " + vert1.getY() + ")");
        System.out.println("Vert2 (" + vert2.getX() + ", " + vert2.getY() + ")");
        System.out.println("Vert3 (" + vert3.getX() + ", " + vert3.getY() + ")");
    }


    public static void main(String[] args) {
        int incremento = 10;

        System.out.println("\n[Creando triangulo 1]");
        PuntoA5 A = new PuntoA5(1,1);
        PuntoA5 B = new PuntoA5(0,1);
        PuntoA5 C = new PuntoA5(1,0);

        TrianguloA6 tri1 = new TrianguloA6(A,B,C);
        tri1.mostrarDatos();

        System.out.println("\n[Creando triangulo 2: ]");
        PuntoA5 D = new PuntoA5(2,0);
        PuntoA5 E = new PuntoA5(0,69);
        PuntoA5 F = new PuntoA5(7,7);

        TrianguloA6 tri2 = new TrianguloA6(D,E,F);
        tri2.mostrarDatos();

        System.out.println();
        System.out.println("[Moviendo " + incremento +  " unidades a la derecha todos los vertices del triangulo 1]");
        tri1.moveXs(incremento);
        tri1.mostrarDatos();

        System.out.println();
        System.out.println("[Calculando perimetro de triangulo 1]");
        System.out.println("Perimetro:");
        System.out.println(tri1.calcularPerimetro());

        System.out.println();
        System.out.println("[Calculando perimetro de triangulo 2]");
        System.out.println("Perimetro:");
        System.out.println(tri2.calcularPerimetro());

        System.out.println();
        System.out.println("Triangulo 1 es equilatero: " + tri1.esEquilatero());
        System.out.println();
        System.out.println("Triangulo 2 es  equilatero: " + tri2.esEquilatero());
        System.out.println();

        System.out.println("Creando triangulo con Punto en (0,0)");
        TrianguloA6 tri3 = new TrianguloA6(A,F);
        tri3.mostrarDatos();
    }
}

// Para verificar: https://es.planetcalc.com/9423/

