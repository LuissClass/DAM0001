public class SeguroB3 {

    private final boolean esHombre;
    private final int tiempoDesdeUltimoParte;
    private final char tamanio;

    public SeguroB3(boolean esHombre, int tiempoDesdeUltimoParte, char tamanio) {
        this.esHombre = esHombre;
        this.tiempoDesdeUltimoParte = tiempoDesdeUltimoParte;
        this.tamanio = tamanio;
    }

    private double calcularTarifa() {
        int descuento = 0;
        double tarifa = 0.0;

        if (tamanio == 'p' && tiempoDesdeUltimoParte >= 5) descuento = 15; else descuento = 10;
        if (tamanio == 'm' && !esHombre) descuento = 16; else if (esHombre && tiempoDesdeUltimoParte >= 3) descuento = 17; else if (tiempoDesdeUltimoParte >= 3) descuento = 10;
        if (tamanio == 'g') {
            if (tiempoDesdeUltimoParte >= 7) descuento = 20;
            else if (!esHombre) descuento = 10;
            else descuento = 8;
        }

        if (tamanio == 'p') tarifa = calcularDescuento(400, descuento);
        else if (tamanio == 'm') tarifa = calcularDescuento(600, descuento);
        else if (tamanio == 'g') tarifa = calcularDescuento(900, descuento);

        return tarifa;
    }

    private double calcularDescuento(double tarifaBase, double descuento) {
        return tarifaBase + (tarifaBase * (descuento/100.0));
    }

    public void imprimitTarifa() {
        System.out.println(calcularTarifa());
    }

    public static void main(String[] args) {
        SeguroB3 s1 = new SeguroB3(false, 10, 'p');
        s1.imprimitTarifa();
    }
}
