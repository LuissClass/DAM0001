public class FechaB2 {
    private int day;
    private int month;
    private int year;

    FechaB2(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    void mostrarConFormato() {
        System.out.println(day + "-" + month + "-" + year);
    }

    boolean esBisiesto() {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    void pasarDia() {
        switch (month) {
            case 12:
                year = day == 31 ? year + 1: year;
                month = day == 31 ? 1 : month;
                day = day == 31 ? 0 : day;
                break;
            case 4, 6, 9, 11:
                month = day == 30 ? month + 1 : month;
                day = day == 30 ? 0 : day;
                break;
            case 2:
                if (esBisiesto()) {
                    day = day == 29 ? 0 : day;
                } else {
                    day = day == 28 ? 0 : day;
                }
                month += 1;
                break;
            default:
                month = day == 31 ? month + 1 : month;
                day = day == 31 ? 0 : day;
                break;
        }
        day += 1;
    }

    public static void main(String[] args) {
        FechaB2 fecha1 = new FechaB2(29, 12, 2024);
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
