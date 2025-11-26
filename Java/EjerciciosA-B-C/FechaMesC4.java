package DAM1;

import java.io.IOException;

public class FechaMesC4 {
    int dia;
    int mes;
    int agno;

    FechaMesC4(int dia, int mes, int agno) {
        this.dia = dia;
        this.mes = mes;
        this.agno = agno;
    }

    boolean esBisiesto() {
        boolean retorno = false;
        if ((agno % 4 == 0) && (agno % 100 != 0) || (agno % 400 == 0)) {
            retorno = true;
        }
        return retorno;
    }

    int diasDelMes() {
        int dias = 0;
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            dias = 31;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            dias = 30;
        }
        if (mes == 2) {
            if (esBisiesto()) {
                dias = 29;
            } else {
                dias = 28;
            }
        }
        if (mes < 1 || mes > 12)
            dias = -1;
        return dias;
    }

    int diasDelMesv2() {
        int numDias = -1;
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
                numDias = 31;
                break;
            case 4, 6, 9, 11:
                numDias = 30;
                break;
            case 2:
                if (esBisiesto()) numDias = 29;
                else numDias = 28;
        }
        return numDias;
    }

    int diaSiguiente() {
        dia = dia + 1;
        if (dia > this.diasDelMes()) {
            dia = 1;
            mes = mes + 1;
        }
        if (mes > 12) {
            mes = 1;
            agno = agno + 1;
        }
        return dia;
    }

    void escribirCalendarioMes(int day) {
        int columnaCounter = day;
        String cadenaDias = "";

        System.out.println("L  M  X  J  V  S  D");

        for (int j = 1; j < columnaCounter; ++j) {
            cadenaDias += "   ";
        }

        for (int i = 1; i <= diasDelMes(); ++i) {
            if (columnaCounter == 8) {
                cadenaDias += "\n";
                columnaCounter = 1;
            }
            if (i <= 9) {
                cadenaDias += i + "  ";
                columnaCounter++;
            } else {
                cadenaDias += i + " ";
                columnaCounter++;
            }
        }
        System.out.println(cadenaDias);
    }

    void mostrar() {
        System.out.println(dia + "/" + mes + "/" + agno);
    }

    public static void main(String[] args) throws IOException {
        FechaMesC4 f1 = new FechaMesC4(15, 2, 2023);

        f1.escribirCalendarioMes(6);
    }
}