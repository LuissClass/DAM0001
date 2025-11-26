package DAM1;

import javax.imageio.stream.ImageInputStream;

public class FechaC4 {

    void escribirCalendarioMes(int day) {
        int columnaCounter = day;
        String cadenaDias = "";

        System.out.println("L  M  X  J  V  S  D");

        for (int j = 1; j < columnaCounter; ++j) {
            cadenaDias += "   ";
        }

        for (int i = 1; i <= 31; ++i) {
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

    public static void main(String[] args) {
        FechaC4 fecha1 = new FechaC4();
        fecha1.escribirCalendarioMes(3);
    }
}
