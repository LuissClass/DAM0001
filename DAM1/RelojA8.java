
public class RelojA8 {
    public static void main(String[] args) {
        Hora hora1 = new Hora(23, 59, 57);
        hora1.mostrarHoraConFormato();
        for (int i=0; i < 10; ++i) {
            hora1.incrementarSegundo();
            hora1.mostrarHoraConFormato();
        }
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
        segundos = segundos == 59 ? 0 : segundos + 1;
        minutos = segundos == 0 ? minutos + 1 : minutos;
        minutos = segundos == 0 && minutos == 60 ? 0 : minutos;
        horas = segundos == 0 && minutos == 0? horas + 1 : horas;
        horas = horas == 24 ? 0 : horas;
    }
}


