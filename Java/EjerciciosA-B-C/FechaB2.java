import java.io.IOException;

public class FechaB2 {
    private int day;
    private int month;
    private int year;
    private Teclado t = new Teclado();
    boolean isFormatoA = true;

    FechaB2(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    boolean elegirFormato() throws IOException {
        System.out.println("Que formato prefieres (A/B)?\n\tA) dd-mm-aaaa\n\tB) dd/mm/aaaa");
        String res = t.leerString();

        if (res.toUpperCase().equals("A")) {
            return true;
        } else if (res.toUpperCase().equals("B")) {
            return false;
        } else {
            System.out.println("Respuesta invalida! \tSe usara el formato A");
        }
        return false;
    }

    void mostrarConFormato() {
        if (isFormatoA) {
            System.out.println("\t" + day + "-" + month + "-" + year);
        } else {
            System.out.println("\t" + day + "/" + month + "/" + year);
        }
    }

    boolean esBisiesto() {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    void pasarDia() {
        switch (month) {
            case 4, 6, 9, 11:
                month = day == 30 ? month + 1 : month;
                day = day == 30 ? 0 : day;
                break;
            case 2:
                if (esBisiesto()) {
                    month = day == 29 ? month + 1 : month;
                    day = day == 29 ? 0 : day;
                } else {
                    month = day == 28 ? month + 1 : month;
                    day = day == 28 ? 0 : day;
                }
                break;
            default:
                year = month == 12 && day == 31? year + 1 : year;
                month = month == 12 && day == 31 ? 0 : month;
                month = day == 31 ? month + 1 : month;
                day = day == 31 ? 0 : day;
                break;
        }
        day += 1;
    }

    public static void main(String[] args) throws IOException {
        FechaB2 fecha1 = new FechaB2(26, 12, 2024);
        fecha1.elegirFormato();
        fecha1.mostrarConFormato();
        fecha1.pasarDia();
        fecha1.mostrarConFormato();
        fecha1.pasarDia();
        fecha1.mostrarConFormato();
        fecha1.pasarDia();
        fecha1.mostrarConFormato();
        fecha1.pasarDia();
        fecha1.mostrarConFormato();
        fecha1.pasarDia();
        fecha1.mostrarConFormato();
        fecha1.pasarDia();
        fecha1.mostrarConFormato();
    }
}
