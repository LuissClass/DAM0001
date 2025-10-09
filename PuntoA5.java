public class PuntoA5 {
    private double x;
    private double y;
    private final static PuntoA5 ptOrigen = new PuntoA5(0,0);

    PuntoA5 (double x, double y) {
        this.x=x;
        this.y=y;
    }

    public void moverX (double incremento) {
        x+=incremento;
    }

    public void moverY (double incremento) {
        y+=incremento;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public static double discantiaEntrePuntos(PuntoA5 pt1, PuntoA5 pt2) {
        // Pitagoras: hipotenua = raiz de suma de catetos al cuadrado
        double cateto1 = pt2.x - pt1.x;
        double cateto2 = pt2.y - pt1.y;
        return Math.sqrt((cateto1*cateto1)+(cateto2*cateto2));
    }

    public static PuntoA5 puntoCercanoAlOrigen(PuntoA5 pt1, PuntoA5 pt2) {
        return (discantiaEntrePuntos(pt1, ptOrigen) > discantiaEntrePuntos(pt2, ptOrigen)) ? pt2 : pt1;
    }

    public void mostrarPunto() {
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
    }


    public static void main(String[] args) {
        PuntoA5 B = new PuntoA5(5, 5);
        PuntoA5 A = new PuntoA5(0,1);
        System.out.println("Dstancia");
        System.out.println(discantiaEntrePuntos(A,B));
        System.out.println("Punto A: ");
        A.mostrarPunto();
        System.out.println("Punto B: ");
        B.mostrarPunto();
        System.out.println("Ultima func");
        puntoCercanoAlOrigen(A,B).mostrarPunto();
    }
}
