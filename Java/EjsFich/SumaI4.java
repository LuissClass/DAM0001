package DAM1.EjsFich;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumaI4 {
    public static void main(String[] args) {
        String ruta = "UwU\\hola11.txt";
        new SumaI4().sumarTodosLosNumerosEnElFich(ruta);
    }

    void sumarTodosLosNumerosEnElFich(String ruta) {
        String s;
        int suma = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while (br.ready()) {
                s = br.readLine();
                suma += devolverNums(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("SUMA TOTAL: " + suma);
    }

    int devolverNums(String s) {
        int n = 0;
        char[] caracteres = s.toCharArray();
        String ch;

        for (int i = 0; i < s.length(); i++) {
            ch = String.valueOf(caracteres[i]);

            try {
                n += Integer.parseInt(ch);
            } catch (NumberFormatException nfe) {
                System.out.println("El caracter '" + ch + "' no es un numero. Detalles: " + nfe);
            }
        }

        return n;
    }
}
