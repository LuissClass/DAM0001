
// Usa la clase PuntoA5
public class RectanguloA10 {
    PuntoA5 verIzqSup;
    PuntoA5 verDerInf;
    PuntoA5 verDerSup;
    PuntoA5 verIzqInf;

    double largo;
    double alto;

    public RectanguloA10(PuntoA5 verIzqSup, PuntoA5 verDerInf) {
        this.verIzqSup = verIzqSup;
        this.verDerInf = verDerInf;
        verDerSup = new PuntoA5(verDerInf.getX(), verIzqSup.getY());
        verIzqInf = new PuntoA5(verIzqSup.getX(), verDerInf.getY());
    }


    void mostrarDatos() {
        System.out.println("Vertice 1: " + verIzqSup.mostrarPunto() + "\nVertice 2: " + verDerSup.mostrarPunto()
                + "\nVertice 3: " + verIzqInf.mostrarPunto() + "\nVertice 4: " + verDerInf.mostrarPunto());
    }

    void calcularLados() {
        largo = PuntoA5.distanciaEntrePuntos(verIzqSup, verDerSup);
        alto = PuntoA5.distanciaEntrePuntos(verIzqSup, verIzqInf);
    }

    double calcularPerimetro() {
        calcularLados();
        return largo*2 + alto *2;
    }

    void mostrarPerimetro() {
        System.out.println(this.calcularPerimetro());
    }

    void girarOrtogonalmente() {
        double oldLargo = largo;
        double oldAlto = alto;
        //V3
        verIzqInf.setX(verIzqSup.getX());
        verIzqInf.setY(verIzqSup.getY());
        //V1
        verIzqSup.moverY(largo);
        //V2
        verDerSup.setY(verIzqSup.getY());
        verDerSup.setX(verIzqSup.getX());
        System.out.println("E: " + verIzqSup.getX());
        verDerSup.moverX(alto);
        //V4
        verDerInf.setY(verIzqInf.getY());
        verDerInf.setX(verDerSup.getX());

        largo = oldAlto;
        alto = oldLargo;
    }

    public static void main(String[] args) {
        RectanguloA10 rectanguloPro = new RectanguloA10(new PuntoA5(3, 5), new PuntoA5(8, 1));
        rectanguloPro.mostrarDatos();
        rectanguloPro.mostrarPerimetro();
        rectanguloPro.girarOrtogonalmente();

        System.out.println();
        rectanguloPro.mostrarDatos();
    }
}
