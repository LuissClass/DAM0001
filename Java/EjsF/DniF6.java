package DAM1.EjsF;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DniF6 {
    public static void main(String[] args) {
        DniF6 f6 = new DniF6();
        String dni = "12345678Z";

        if (f6.esCorrecto(dni)) {
            System.out.println("ES CORRECTO!");
        } else {
            System.out.println("ESTÁ MAL!");
        }
    }

    String[] letras = {
            "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B",
            "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"
    };

    boolean esCorrecto(String dni) {
        boolean res = false;
        if (sizeEsCorrecto(dni) && letraEsCorrecto(dni)) {
            res = true;
        }

        return res;
    }

    boolean sizeEsCorrecto(String dni) {
        boolean res = false;
        res = dni.length() == 9;
        return res;
    }

    void formatoEsCorrecto(String dni) {
        // Si esta mal el formato dara error
        String.valueOf(dni.charAt(dni.length()-1));

        for (int i = 0; i < 8; i++) {
            Integer.valueOf(String.valueOf(dni.charAt(i)));
        }
    }

    boolean letraEsCorrecto(String dni) {
        boolean res = false;
        formatoEsCorrecto(dni);
        int numeroCalculado = 0;
        String letra = String.valueOf(dni.charAt(dni.length()-1));
        int numLetra = -1;

        for (int i = 0; i < letras.length; i++) {
            if (letra.equals(letras[i])) {
                numLetra = i;
                break;
            }
        }

        //numeroCalculado = devolverNum1(dni) % 23;
        numeroCalculado = devolverNum2(dni) % 23;

        res = numeroCalculado == numLetra;

        return res;
    }

    int devolverNum1(String dni) {
        int res = 0;
        String numsStr = "";
        for (int i = 0; i < 8; i++) {
            numsStr += dni.charAt(i);
        }
        res = Integer.valueOf(numsStr);
        return res;
    }

    int devolverNum2(String str) {
        int res = 0;
        String regex = "\\d+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);

        if (mat.find()) {
            res = Integer.valueOf(mat.group());
        }
        return res;
    }
}
