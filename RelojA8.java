
public class RelojA8 {
    public static void main(String[] args) {
        Hora hora1 = new Hora(23, 59, 57);
        hora1.mostrarHoraConFormato();
        hora1.incrementarSegundo();
        hora1.mostrarHoraConFormato();

        hora1.incrementarSegundo();
        hora1.mostrarHoraConFormato();

        hora1.incrementarSegundo();
        hora1.mostrarHoraConFormato();

        hora1.incrementarSegundo();
        hora1.mostrarHoraConFormato();
    }
}


class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    void mostrarHoraConFormato() {
        System.out.println(horas + ":" + minutos + ":" + segundos);
    }

    void incrementarSegundo() {
        boolean pasoSeg = false;
        boolean pasoMin = false;

        pasoSeg = segundos == 59? true : false;
        segundos = pasoSeg? 0 : segundos+1;

        minutos = pasoSeg? minutos+1 : minutos;
        pasoMin = minutos == 60? true : false;
        minutos = pasoSeg && pasoMin? 0 : minutos;

        horas = pasoMin? horas+1 : horas;
        horas = horas == 24? 0 : horas;

        pasoSeg = false;
        pasoMin = false;
    }
}


