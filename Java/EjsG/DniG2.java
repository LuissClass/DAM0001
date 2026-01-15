package DAM1.EjsG;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DniG2 {
    public static void main(String[] args) throws Exception {
        DniG2 f6 = new DniG2();
        String dni = "12345678Z";

        try {
            if (f6.esCorrecto(dni)) {
                System.out.println("ES CORRECTO!");
            } else {
                System.out.println("ESTÁ MAL!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    String[] letras = {
            "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B",
            "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"
    };

    boolean esCorrecto(String dni) throws Exception {
        boolean res = false;
        if (sizeEsCorrecto(dni) && letraEsCorrecto(dni)) {
            res = true;
        }

        return res;
    }

    boolean sizeEsCorrecto(String dni) throws Exception {
        boolean res = false;
        res = dni.length() == 9;

        if (!res) {
            throw new Exception("Numero incorrecto de carácteres");
        }

        return res;
    }

    void formatoEsCorrecto(String dni) throws Exception {
        try {
            String l = String.valueOf(dni.charAt(dni.length() - 1));
            boolean letraValida = false;

            for (String let : letras) {
                if (l.equalsIgnoreCase(let)) {
                    letraValida = true;
                    break;
                }
            }

            if (!letraValida) {
                throw new Exception("Caracter invalido");
            }

            for (int i = 0; i < 8; i++) {
                Integer.valueOf(String.valueOf(dni.charAt(i)));
            }
        } catch (NumberFormatException e) {
            throw new Exception("El formato es incorrecto (8 numeros y una letra)");
        }
    }

    boolean letraEsCorrecto(String dni) throws Exception {
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

        numeroCalculado = devolverNum2(dni) % 23;

        res = numeroCalculado == numLetra;

        if (!res) {
            throw  new Exception("Letra incorrecta");
        }

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
